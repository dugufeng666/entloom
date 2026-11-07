package io.entloom.server.ontology;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

@Service
public class OntologyValidationService {

    private final OntologyRepository ontologyRepository;
    private final OntologyClassRepository classRepository;
    private final OntologyPropertyRepository propertyRepository;
    private final OntologyRelationRepository relationRepository;
    private final OntologyValidationJobRepository jobRepository;
    private final ObjectMapper objectMapper;

    public OntologyValidationService(
            OntologyRepository ontologyRepository,
            OntologyClassRepository classRepository,
            OntologyPropertyRepository propertyRepository,
            OntologyRelationRepository relationRepository,
            OntologyValidationJobRepository jobRepository,
            ObjectMapper objectMapper) {
        this.ontologyRepository = ontologyRepository;
        this.classRepository = classRepository;
        this.propertyRepository = propertyRepository;
        this.relationRepository = relationRepository;
        this.jobRepository = jobRepository;
        this.objectMapper = objectMapper;
    }

    public OntologyValidationResponse validate(UUID projectId, UUID ontologyId) {
        Ontology ontology = ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
        List<OntologyValidationResponse.Issue> issues = new ArrayList<>();
        List<OntologyClass> classes = classRepository.findAllByOntologyIdOrderByUpdatedAtDesc(ontologyId);
        if (classes.isEmpty()) {
            issues.add(new OntologyValidationResponse.Issue("ERROR", "NO_CLASSES", "An ontology must define at least one class.", "ontology"));
        }
        for (OntologyClass ontologyClass : classes) {
            if (propertyRepository.findAllByClassIdOrderByUpdatedAtDesc(ontologyClass.getId()).isEmpty()) {
                issues.add(new OntologyValidationResponse.Issue(ontology.isValidationRequireClassProperties() ? "ERROR" : "WARNING", "CLASS_WITHOUT_PROPERTIES", "Class has no properties yet.", "Class / " + ontologyClass.getName()));
            }
        }
        for (OntologyRelation relation : relationRepository.findAllByOntologyIdOrderByUpdatedAtDesc(ontologyId)) {
            if (relation.getSourceClassId().equals(relation.getTargetClassId())) {
                issues.add(new OntologyValidationResponse.Issue(ontology.isValidationAllowSelfRelations() ? "WARNING" : "ERROR", "SELF_RELATION", "Relation points from a class to itself.", "Relation / " + relation.getName()));
            }
        }
        boolean valid = issues.stream().noneMatch(issue -> "ERROR".equals(issue.severity()));
        return new OntologyValidationResponse(valid, List.copyOf(issues));
    }

    @org.springframework.transaction.annotation.Transactional
    public OntologyValidationJobResponse runJob(UUID projectId, UUID ontologyId) {
        ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
        OntologyValidationJob job = jobRepository.saveAndFlush(OntologyValidationJob.create(ontologyId));
        OntologyValidationResponse result = validate(projectId, ontologyId);
        try {
            job.complete(objectMapper.writeValueAsString(result.issues()));
            jobRepository.saveAndFlush(job);
            return toResponse(job);
        } catch (JsonProcessingException exception) {
            job.fail();
            jobRepository.saveAndFlush(job);
            throw new IllegalStateException("Unable to save validation result", exception);
        }
    }

    public List<OntologyValidationJobResponse> listJobs(UUID projectId, UUID ontologyId) {
        ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
        return jobRepository.findAllByOntologyIdOrderByCreatedAtDesc(ontologyId).stream().map(this::toResponse).toList();
    }

    private OntologyValidationJobResponse toResponse(OntologyValidationJob job) {
        try {
            List<OntologyValidationResponse.Issue> issues = objectMapper.readValue(job.getIssuesJson(), new TypeReference<>() { });
            return new OntologyValidationJobResponse(job.getId(), job.getOntologyId(), job.getStatus(), issues, job.getCreatedAt(), job.getFinishedAt());
        } catch (JsonProcessingException exception) {
            return new OntologyValidationJobResponse(job.getId(), job.getOntologyId(), job.getStatus(), List.of(), job.getCreatedAt(), job.getFinishedAt());
        }
    }
}
