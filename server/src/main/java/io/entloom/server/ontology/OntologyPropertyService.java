package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OntologyPropertyService {

    private final OntologyPropertyRepository propertyRepository;
    private final OntologyRepository ontologyRepository;
    private final OntologyClassRepository classRepository;

    public OntologyPropertyService(
            OntologyPropertyRepository propertyRepository,
            OntologyRepository ontologyRepository,
            OntologyClassRepository classRepository) {
        this.propertyRepository = propertyRepository;
        this.ontologyRepository = ontologyRepository;
        this.classRepository = classRepository;
    }

    public List<OntologyPropertyResponse> list(UUID projectId, UUID ontologyId, UUID classId) {
        requireDraftContext(projectId, ontologyId, classId, false);
        return propertyRepository.findAllByClassIdOrderByUpdatedAtDesc(classId).stream()
                .map(OntologyPropertyResponse::from)
                .toList();
    }

    public OntologyPropertyResponse get(UUID projectId, UUID ontologyId, UUID classId, UUID id) {
        requireDraftContext(projectId, ontologyId, classId, false);
        return OntologyPropertyResponse.from(requireProperty(classId, id));
    }

    @Transactional
    public OntologyPropertyResponse create(
            UUID projectId,
            UUID ontologyId,
            UUID classId,
            CreateOntologyPropertyRequest request) {
        Ontology ontology = requireDraftContext(projectId, ontologyId, classId, true);
        OntologyProperty property = propertyRepository.save(OntologyProperty.create(
                ontology.getId(),
                classId,
                request.name().trim(),
                normalize(request.description()),
                request.valueType(),
                request.required()));
        return OntologyPropertyResponse.from(property);
    }

    @Transactional
    public OntologyPropertyResponse update(
            UUID projectId,
            UUID ontologyId,
            UUID classId,
            UUID id,
            UpdateOntologyPropertyRequest request) {
        requireDraftContext(projectId, ontologyId, classId, true);
        OntologyProperty property = requireProperty(classId, id);
        property.updateDetails(
                request.name().trim(),
                normalize(request.description()),
                request.valueType(),
                request.required());
        propertyRepository.saveAndFlush(property);
        return OntologyPropertyResponse.from(property);
    }

    @Transactional
    public void delete(UUID projectId, UUID ontologyId, UUID classId, UUID id) {
        requireDraftContext(projectId, ontologyId, classId, true);
        propertyRepository.delete(requireProperty(classId, id));
        propertyRepository.flush();
    }

    private Ontology requireDraftContext(UUID projectId, UUID ontologyId, UUID classId, boolean draftRequired) {
        Ontology ontology = ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
        if (classRepository.findByIdAndOntologyId(classId, ontologyId).isEmpty()) {
            throw new OntologyClassNotFoundException(classId);
        }
        if (draftRequired) {
            ontology.ensureDraft();
        }
        return ontology;
    }

    private OntologyProperty requireProperty(UUID classId, UUID id) {
        return propertyRepository.findByIdAndClassId(id, classId)
                .orElseThrow(() -> new OntologyPropertyNotFoundException(id));
    }

    private String normalize(String description) {
        if (description == null || description.isBlank()) {
            return null;
        }
        return description.trim();
    }
}
