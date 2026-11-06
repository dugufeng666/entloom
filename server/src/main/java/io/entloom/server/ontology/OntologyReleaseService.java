package io.entloom.server.ontology;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OntologyReleaseService {

    private final OntologyReleaseRepository releaseRepository;
    private final OntologyRepository ontologyRepository;
    private final OntologyClassRepository classRepository;
    private final OntologyPropertyRepository propertyRepository;
    private final OntologyRelationRepository relationRepository;
    private final ObjectMapper objectMapper;

    public OntologyReleaseService(
            OntologyReleaseRepository releaseRepository,
            OntologyRepository ontologyRepository,
            OntologyClassRepository classRepository,
            OntologyPropertyRepository propertyRepository,
            OntologyRelationRepository relationRepository,
            ObjectMapper objectMapper) {
        this.releaseRepository = releaseRepository;
        this.ontologyRepository = ontologyRepository;
        this.classRepository = classRepository;
        this.propertyRepository = propertyRepository;
        this.relationRepository = relationRepository;
        this.objectMapper = objectMapper;
    }

    public List<OntologyReleaseResponse> list(UUID projectId, UUID ontologyId) {
        requireOntology(projectId, ontologyId);
        return releaseRepository.findAllByOntologyIdOrderByReleasedAtDesc(ontologyId).stream()
                .map(OntologyReleaseResponse::from)
                .toList();
    }

    public OntologyReleaseDiffResponse diff(UUID projectId, UUID ontologyId, UUID fromId, UUID toId) {
        requireOntology(projectId, ontologyId);
        OntologyRelease from = releaseRepository.findById(fromId)
                .filter(item -> item.getOntologyId().equals(ontologyId))
                .orElseThrow(() -> new OntologyNotFoundException(fromId));
        OntologyRelease to = releaseRepository.findById(toId)
                .filter(item -> item.getOntologyId().equals(ontologyId))
                .orElseThrow(() -> new OntologyNotFoundException(toId));
        return new OntologyReleaseDiffResponse(from.getId(), from.getVersion(), to.getId(), to.getVersion(), compare(readManifest(from), readManifest(to)));
    }

    @Transactional
    public OntologyReleaseResponse release(
            UUID projectId,
            UUID ontologyId,
            ReleaseOntologyRequest request,
            String releasedBy) {
        Ontology ontology = requireOntology(projectId, ontologyId);
        ontology.ensureDraft();
        if (releaseRepository.existsByOntologyIdAndVersion(ontologyId, request.version())) {
            throw new OntologyReleaseConflictException("Release version already exists: " + request.version());
        }

        List<OntologyClass> classes = classRepository.findAllByOntologyIdOrderByUpdatedAtDesc(ontologyId);
        List<OntologyProperty> properties = classes.stream().flatMap(item -> propertyRepository.findAllByClassIdOrderByUpdatedAtDesc(item.getId()).stream()).toList();
        List<OntologyRelation> relations = relationRepository.findAllByOntologyIdOrderByUpdatedAtDesc(ontologyId);
        String manifestJson = writeManifest(OntologyReleaseManifest.of(classes, properties, relations));
        OntologyRelease release = releaseRepository.save(OntologyRelease.create(
                ontologyId,
                request.version(),
                normalize(request.notes()),
                releasedBy,
                classRepository.countByOntologyId(ontologyId),
                propertyRepository.countByOntologyId(ontologyId),
                relationRepository.countByOntologyId(ontologyId),
                manifestJson));
        ontology.changeStatus(OntologyStatus.RELEASED);
        ontologyRepository.saveAndFlush(ontology);
        releaseRepository.flush();
        return OntologyReleaseResponse.from(release);
    }

    private Ontology requireOntology(UUID projectId, UUID ontologyId) {
        return ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
    }

    private String normalize(String notes) {
        if (notes == null || notes.isBlank()) {
            return null;
        }
        return notes.trim();
    }

    private String writeManifest(OntologyReleaseManifest manifest) {
        try {
            return objectMapper.writeValueAsString(manifest);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException("Unable to serialize ontology release manifest", exception);
        }
    }

    private OntologyReleaseManifest readManifest(OntologyRelease release) {
        try {
            return objectMapper.readValue(release.getManifestJson(), OntologyReleaseManifest.class);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException("Unable to read ontology release manifest", exception);
        }
    }

    private List<OntologyReleaseDiffResponse.OntologyReleaseChange> compare(OntologyReleaseManifest from, OntologyReleaseManifest to) {
        List<OntologyReleaseDiffResponse.OntologyReleaseChange> changes = new ArrayList<>();
        Map<UUID, String> classNames = new java.util.HashMap<>();
        from.classes().forEach(item -> classNames.put(item.id(), item.name()));
        to.classes().forEach(item -> classNames.put(item.id(), item.name()));
        compareClasses(from.classes(), to.classes(), changes);
        compareProperties(from.properties(), to.properties(), classNames, changes);
        compareRelations(from.relations(), to.relations(), classNames, changes);
        return changes;
    }

    private void compareClasses(List<OntologyReleaseManifest.ClassSnapshot> from, List<OntologyReleaseManifest.ClassSnapshot> to, List<OntologyReleaseDiffResponse.OntologyReleaseChange> changes) {
        Map<UUID, OntologyReleaseManifest.ClassSnapshot> before = from.stream().collect(java.util.stream.Collectors.toMap(OntologyReleaseManifest.ClassSnapshot::id, item -> item));
        Map<UUID, OntologyReleaseManifest.ClassSnapshot> after = to.stream().collect(java.util.stream.Collectors.toMap(OntologyReleaseManifest.ClassSnapshot::id, item -> item));
        compareMap("CLASS", before, after, OntologyReleaseManifest.ClassSnapshot::id, OntologyReleaseManifest.ClassSnapshot::name, item -> "Class / " + item.name(), changes);
    }

    private void compareProperties(List<OntologyReleaseManifest.PropertySnapshot> from, List<OntologyReleaseManifest.PropertySnapshot> to, Map<UUID, String> classNames, List<OntologyReleaseDiffResponse.OntologyReleaseChange> changes) {
        Map<UUID, OntologyReleaseManifest.PropertySnapshot> before = from.stream().collect(java.util.stream.Collectors.toMap(OntologyReleaseManifest.PropertySnapshot::id, item -> item));
        Map<UUID, OntologyReleaseManifest.PropertySnapshot> after = to.stream().collect(java.util.stream.Collectors.toMap(OntologyReleaseManifest.PropertySnapshot::id, item -> item));
        compareMap("PROPERTY", before, after, OntologyReleaseManifest.PropertySnapshot::id, OntologyReleaseManifest.PropertySnapshot::name, item -> "Property / " + classNames.getOrDefault(item.classId(), "Unknown class") + " / " + item.name(), changes);
    }

    private void compareRelations(List<OntologyReleaseManifest.RelationSnapshot> from, List<OntologyReleaseManifest.RelationSnapshot> to, Map<UUID, String> classNames, List<OntologyReleaseDiffResponse.OntologyReleaseChange> changes) {
        Map<UUID, OntologyReleaseManifest.RelationSnapshot> before = from.stream().collect(java.util.stream.Collectors.toMap(OntologyReleaseManifest.RelationSnapshot::id, item -> item));
        Map<UUID, OntologyReleaseManifest.RelationSnapshot> after = to.stream().collect(java.util.stream.Collectors.toMap(OntologyReleaseManifest.RelationSnapshot::id, item -> item));
        compareMap("RELATION", before, after, OntologyReleaseManifest.RelationSnapshot::id, OntologyReleaseManifest.RelationSnapshot::name, item -> "Relation / " + classNames.getOrDefault(item.sourceClassId(), "Unknown class") + " → " + classNames.getOrDefault(item.targetClassId(), "Unknown class") + " / " + item.name(), changes);
    }

    private <T> void compareMap(String kind, Map<UUID, T> before, Map<UUID, T> after, java.util.function.Function<T, UUID> id, java.util.function.Function<T, String> name, java.util.function.Function<T, String> location, List<OntologyReleaseDiffResponse.OntologyReleaseChange> changes) {
        before.forEach((itemId, item) -> {
            if (!after.containsKey(itemId)) changes.add(new OntologyReleaseDiffResponse.OntologyReleaseChange(kind, "DELETED", itemId, name.apply(item), location.apply(item), item, null));
            else if (!Objects.equals(item, after.get(itemId))) changes.add(new OntologyReleaseDiffResponse.OntologyReleaseChange(kind, "MODIFIED", itemId, name.apply(after.get(itemId)), location.apply(after.get(itemId)), item, after.get(itemId)));
        });
        after.forEach((itemId, item) -> { if (!before.containsKey(itemId)) changes.add(new OntologyReleaseDiffResponse.OntologyReleaseChange(kind, "ADDED", itemId, name.apply(item), location.apply(item), null, item)); });
    }
}
