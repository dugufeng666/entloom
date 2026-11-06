package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OntologyClassService {

    private final OntologyClassRepository ontologyClassRepository;
    private final OntologyRepository ontologyRepository;

    public OntologyClassService(
            OntologyClassRepository ontologyClassRepository,
            OntologyRepository ontologyRepository) {
        this.ontologyClassRepository = ontologyClassRepository;
        this.ontologyRepository = ontologyRepository;
    }

    public List<OntologyClassResponse> list(UUID projectId, UUID ontologyId) {
        requireOntology(projectId, ontologyId);
        return ontologyClassRepository.findAllByOntologyIdOrderByUpdatedAtDesc(ontologyId).stream()
                .map(OntologyClassResponse::from)
                .toList();
    }

    public OntologyClassResponse get(UUID projectId, UUID ontologyId, UUID id) {
        requireOntology(projectId, ontologyId);
        return OntologyClassResponse.from(requireClass(ontologyId, id));
    }

    @Transactional
    public OntologyClassResponse create(
            UUID projectId,
            UUID ontologyId,
            CreateOntologyClassRequest request) {
        Ontology ontology = requireOntology(projectId, ontologyId);
        ontology.ensureDraft();
        OntologyClass ontologyClass = ontologyClassRepository.save(OntologyClass.create(
                ontologyId,
                request.name().trim(),
                normalize(request.description())));
        return OntologyClassResponse.from(ontologyClass);
    }

    @Transactional
    public OntologyClassResponse update(
            UUID projectId,
            UUID ontologyId,
            UUID id,
            UpdateOntologyClassRequest request) {
        Ontology ontology = requireOntology(projectId, ontologyId);
        ontology.ensureDraft();
        OntologyClass ontologyClass = requireClass(ontologyId, id);
        ontologyClass.updateDetails(request.name().trim(), normalize(request.description()));
        ontologyClassRepository.saveAndFlush(ontologyClass);
        return OntologyClassResponse.from(ontologyClass);
    }

    private Ontology requireOntology(UUID projectId, UUID ontologyId) {
        return ontologyRepository.findByIdAndProjectId(ontologyId, projectId)
                .orElseThrow(() -> new OntologyNotFoundException(ontologyId));
    }

    private OntologyClass requireClass(UUID ontologyId, UUID id) {
        return ontologyClassRepository.findByIdAndOntologyId(id, ontologyId)
                .orElseThrow(() -> new OntologyClassNotFoundException(id));
    }

    private String normalize(String description) {
        if (description == null || description.isBlank()) {
            return null;
        }
        return description.trim();
    }
}
