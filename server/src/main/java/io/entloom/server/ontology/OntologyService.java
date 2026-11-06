package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.entloom.server.project.ProjectNotFoundException;
import io.entloom.server.project.ProjectRepository;

@Service
@Transactional(readOnly = true)
public class OntologyService {

    private final OntologyRepository ontologyRepository;
    private final ProjectRepository projectRepository;

    public OntologyService(OntologyRepository ontologyRepository, ProjectRepository projectRepository) {
        this.ontologyRepository = ontologyRepository;
        this.projectRepository = projectRepository;
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
        ontology.updateDetails(request.name().trim(), normalize(request.description()));
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
}
