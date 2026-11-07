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
