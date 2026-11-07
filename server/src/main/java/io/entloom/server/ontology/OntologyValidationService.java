package io.entloom.server.ontology;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class OntologyValidationService {

    private final OntologyRepository ontologyRepository;
    private final OntologyClassRepository classRepository;
    private final OntologyPropertyRepository propertyRepository;
    private final OntologyRelationRepository relationRepository;

    public OntologyValidationService(
            OntologyRepository ontologyRepository,
            OntologyClassRepository classRepository,
            OntologyPropertyRepository propertyRepository,
            OntologyRelationRepository relationRepository) {
        this.ontologyRepository = ontologyRepository;
        this.classRepository = classRepository;
        this.propertyRepository = propertyRepository;
        this.relationRepository = relationRepository;
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
}
