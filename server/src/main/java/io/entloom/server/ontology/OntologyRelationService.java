package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OntologyRelationService {

    private final OntologyRelationRepository relationRepository;
    private final OntologyRepository ontologyRepository;
    private final OntologyClassRepository classRepository;

    public OntologyRelationService(
            OntologyRelationRepository relationRepository,
            OntologyRepository ontologyRepository,
            OntologyClassRepository classRepository) {
        this.relationRepository = relationRepository;
        this.ontologyRepository = ontologyRepository;
        this.classRepository = classRepository;
    }

    public List<OntologyRelationResponse> list(UUID projectId, UUID ontologyId) {
        requireOntology(projectId, ontologyId);
        return relationRepository.findAllByOntologyIdOrderByUpdatedAtDesc(ontologyId).stream()
                .map(OntologyRelationResponse::from)
                .toList();
    }

    public OntologyRelationResponse get(UUID projectId, UUID ontologyId, UUID id) {
        requireOntology(projectId, ontologyId);
        return OntologyRelationResponse.from(requireRelation(ontologyId, id));
    }

    @Transactional
    public OntologyRelationResponse create(
            UUID projectId,
            UUID ontologyId,
            CreateOntologyRelationRequest request) {
        Ontology ontology = requireDraftOntology(projectId, ontologyId);
        requireClass(ontologyId, request.sourceClassId());
        requireClass(ontologyId, request.targetClassId());
        OntologyRelation relation = relationRepository.save(OntologyRelation.create(
                ontology.getId(),
                request.sourceClassId(),
                request.targetClassId(),
                request.name().trim(),
                normalize(request.description()),
                request.cardinality()));
        return OntologyRelationResponse.from(relation);
    }

    @Transactional
    public OntologyRelationResponse update(
            UUID projectId,
            UUID ontologyId,
            UUID id,
            UpdateOntologyRelationRequest request) {
        Ontology ontology = requireDraftOntology(projectId, ontologyId);
        requireClass(ontologyId, request.sourceClassId());
        requireClass(ontologyId, request.targetClassId());
        OntologyRelation relation = requireRelation(ontology.getId(), id);
        relation.updateDetails(
                request.name().trim(),
                normalize(request.description()),
                request.sourceClassId(),
                request.targetClassId(),
                request.cardinality());
        relationRepository.saveAndFlush(relation);
        return OntologyRelationResponse.from(relation);
    }

    private Ontology requireDraftOntology(UUID projectId, UUID ontologyId) {
        Ontology ontology = requireOntology(projectId, ontologyId);
        ontology.ensureDraft();
        return ontology;
    }

    private Ontology requireOntology(UUID projectId, UUID ontologyId) {
        return ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
    }

    private void requireClass(UUID ontologyId, UUID classId) {
        if (classRepository.findByIdAndOntologyId(classId, ontologyId).isEmpty()) {
            throw new OntologyClassNotFoundException(classId);
        }
    }

    private OntologyRelation requireRelation(UUID ontologyId, UUID id) {
        return relationRepository.findByIdAndOntologyId(id, ontologyId)
                .orElseThrow(() -> new OntologyRelationNotFoundException(id));
    }

    private String normalize(String description) {
        if (description == null || description.isBlank()) {
            return null;
        }
        return description.trim();
    }
}
