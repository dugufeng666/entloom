package io.entloom.server.ontology;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.entloom.server.project.ProjectNotFoundException;
import io.entloom.server.project.ProjectRepository;

@Service
@Transactional(readOnly = true)
public class OntologyService {

    private final OntologyRepository ontologyRepository;
    private final ProjectRepository projectRepository;
    private final OntologyClassRepository classRepository;
    private final OntologyPropertyRepository propertyRepository;
    private final OntologyRelationRepository relationRepository;
    private final ObjectMapper objectMapper;

    public OntologyService(
            OntologyRepository ontologyRepository,
            ProjectRepository projectRepository,
            OntologyClassRepository classRepository,
            OntologyPropertyRepository propertyRepository,
            OntologyRelationRepository relationRepository,
            ObjectMapper objectMapper) {
        this.ontologyRepository = ontologyRepository;
        this.projectRepository = projectRepository;
        this.classRepository = classRepository;
        this.propertyRepository = propertyRepository;
        this.relationRepository = relationRepository;
        this.objectMapper = objectMapper;
    }

    public List<OntologyResponse> list(UUID projectId) {
        requireProject(projectId);
        return ontologyRepository.findAllByProjectIdOrderByUpdatedAtDesc(projectId).stream()
                .map(OntologyResponse::from)
                .toList();
    }

    public OntologyResponse get(UUID projectId, UUID id) {
        requireProject(projectId);
        return OntologyResponse.from(requireOntology(projectId, id));
    }

    @Transactional
    public OntologyResponse create(UUID projectId, CreateOntologyRequest request) {
        requireProject(projectId);
        Ontology ontology = ontologyRepository.save(Ontology.create(
                projectId,
                request.name().trim(),
                normalize(request.description())));
        return OntologyResponse.from(ontology);
    }

    @Transactional
    public OntologyResponse update(UUID projectId, UUID id, UpdateOntologyRequest request) {
        Ontology ontology = requireOntology(projectId, id);
        ontology.updateDetails(request.name().trim(), normalize(request.description()), request.requireClassProperties(), request.allowSelfRelations());
        ontologyRepository.saveAndFlush(ontology);
        return OntologyResponse.from(ontology);
    }

    @Transactional
    public OntologyResponse changeStatus(UUID projectId, UUID id, OntologyStatus status) {
        Ontology ontology = requireOntology(projectId, id);
        ontology.changeStatus(status);
        ontologyRepository.saveAndFlush(ontology);
        return OntologyResponse.from(ontology);
    }

    @Transactional
    public OntologyResponse fork(UUID projectId, UUID id, ForkOntologyRequest request) {
        Ontology source = requireOntology(projectId, id);
        Ontology fork = ontologyRepository.saveAndFlush(Ontology.create(projectId, request.name().trim(), normalize(request.description())));
        fork.updateDetails(fork.getName(), fork.getDescription(), source.isValidationRequireClassProperties(), source.isValidationAllowSelfRelations());
        ontologyRepository.saveAndFlush(fork);
        Map<UUID, UUID> classIds = new HashMap<>();
        for (OntologyClass sourceClass : classRepository.findAllByOntologyIdOrderByUpdatedAtDesc(source.getId())) {
            OntologyClass targetClass = classRepository.save(OntologyClass.create(fork.getId(), sourceClass.getName(), sourceClass.getDescription()));
            classIds.put(sourceClass.getId(), targetClass.getId());
        }
        classRepository.flush();
        for (OntologyClass sourceClass : classRepository.findAllByOntologyIdOrderByUpdatedAtDesc(source.getId())) {
            for (OntologyProperty property : propertyRepository.findAllByClassIdOrderByUpdatedAtDesc(sourceClass.getId())) {
                propertyRepository.save(OntologyProperty.create(fork.getId(), classIds.get(sourceClass.getId()), property.getName(), property.getDescription(), property.getValueType(), property.isRequired()));
            }
        }
        for (OntologyRelation relation : relationRepository.findAllByOntologyIdOrderByUpdatedAtDesc(source.getId())) {
            UUID sourceClassId = classIds.get(relation.getSourceClassId());
            UUID targetClassId = classIds.get(relation.getTargetClassId());
            if (sourceClassId != null && targetClassId != null) {
                relationRepository.save(OntologyRelation.create(fork.getId(), sourceClassId, targetClassId, relation.getName(), relation.getDescription(), relation.getCardinality()));
            }
        }
        return OntologyResponse.from(fork);
    }

    public OntologyLayoutResponse layout(UUID projectId, UUID id) {
        return new OntologyLayoutResponse(readLayout(requireOntology(projectId, id).getGraphLayoutJson()));
    }

    @Transactional
    public OntologyLayoutResponse updateLayout(UUID projectId, UUID id, UpdateOntologyLayoutRequest request) {
        Ontology ontology = requireOntology(projectId, id);
        try {
            String json = objectMapper.writeValueAsString(request.positions());
            ontology.updateGraphLayout(json);
            ontologyRepository.saveAndFlush(ontology);
            return new OntologyLayoutResponse(request.positions());
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException("Unable to save ontology graph layout", exception);
        }
    }

    public OntologyTransferRequest export(UUID projectId, UUID id) {
        Ontology ontology = requireOntology(projectId, id);
        List<OntologyClass> classes = classRepository.findAllByOntologyIdOrderByUpdatedAtDesc(id);
        Map<UUID, String> classNames = classes.stream().collect(java.util.stream.Collectors.toMap(OntologyClass::getId, OntologyClass::getName));
        List<OntologyTransferRequest.ClassTransfer> classTransfers = classes.stream().map(ontologyClass -> new OntologyTransferRequest.ClassTransfer(
                ontologyClass.getName(), ontologyClass.getDescription(), propertyRepository.findAllByClassIdOrderByUpdatedAtDesc(ontologyClass.getId()).stream().map(property -> new OntologyTransferRequest.PropertyTransfer(property.getName(), property.getDescription(), property.getValueType(), property.isRequired())).toList())).toList();
        List<OntologyTransferRequest.RelationTransfer> relationTransfers = relationRepository.findAllByOntologyIdOrderByUpdatedAtDesc(id).stream().map(relation -> new OntologyTransferRequest.RelationTransfer(
                relation.getName(), relation.getDescription(), classNames.get(relation.getSourceClassId()), classNames.get(relation.getTargetClassId()), relation.getCardinality())).toList();
        return new OntologyTransferRequest(ontology.getName(), ontology.getDescription(), classTransfers, relationTransfers);
    }

    @Transactional
    public OntologyResponse importOntology(UUID projectId, OntologyTransferRequest request) {
        requireProject(projectId);
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(projectId, request.name().trim(), normalize(request.description())));
        Map<String, UUID> classIds = new HashMap<>();
        List<OntologyTransferRequest.ClassTransfer> classes = request.classes() == null ? List.<OntologyTransferRequest.ClassTransfer>of() : request.classes();
        List<OntologyTransferRequest.RelationTransfer> relations = request.relations() == null ? List.<OntologyTransferRequest.RelationTransfer>of() : request.relations();
        for (OntologyTransferRequest.ClassTransfer item : classes) {
            OntologyClass ontologyClass = classRepository.save(OntologyClass.create(ontology.getId(), item.name().trim(), normalize(item.description())));
            classIds.put(item.name().trim(), ontologyClass.getId());
        }
        classRepository.flush();
        for (OntologyTransferRequest.ClassTransfer item : classes) {
            UUID classId = classIds.get(item.name().trim());
            List<OntologyTransferRequest.PropertyTransfer> properties = item.properties() == null ? List.<OntologyTransferRequest.PropertyTransfer>of() : item.properties();
            for (OntologyTransferRequest.PropertyTransfer property : properties) {
                propertyRepository.save(OntologyProperty.create(ontology.getId(), classId, property.name().trim(), normalize(property.description()), property.valueType(), property.required()));
            }
        }
        for (OntologyTransferRequest.RelationTransfer relation : relations) {
            UUID source = classIds.get(relation.sourceClass());
            UUID target = classIds.get(relation.targetClass());
            if (source != null && target != null) relationRepository.save(OntologyRelation.create(ontology.getId(), source, target, relation.name().trim(), normalize(relation.description()), relation.cardinality()));
        }
        return OntologyResponse.from(ontology);
    }

    private void requireProject(UUID projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException(projectId);
        }
    }

    private Ontology requireOntology(UUID projectId, UUID id) {
        return ontologyRepository.findByIdAndProjectId(id, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(id));
    }

    private String normalize(String description) {
        if (description == null || description.isBlank()) {
            return null;
        }
        return description.trim();
    }

    private Map<String, OntologyLayoutPosition> readLayout(String json) {
        try {
            return objectMapper.readValue(json == null || json.isBlank() ? "{}" : json, new TypeReference<>() { });
        } catch (JsonProcessingException exception) {
            return Map.of();
        }
    }
}
