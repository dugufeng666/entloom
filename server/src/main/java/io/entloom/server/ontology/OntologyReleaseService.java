package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

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

    public OntologyReleaseService(
            OntologyReleaseRepository releaseRepository,
            OntologyRepository ontologyRepository,
            OntologyClassRepository classRepository,
            OntologyPropertyRepository propertyRepository,
            OntologyRelationRepository relationRepository) {
        this.releaseRepository = releaseRepository;
        this.ontologyRepository = ontologyRepository;
        this.classRepository = classRepository;
        this.propertyRepository = propertyRepository;
        this.relationRepository = relationRepository;
    }

    public List<OntologyReleaseResponse> list(UUID projectId, UUID ontologyId) {
        requireOntology(projectId, ontologyId);
        return releaseRepository.findAllByOntologyIdOrderByReleasedAtDesc(ontologyId).stream()
                .map(OntologyReleaseResponse::from)
                .toList();
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

        OntologyRelease release = releaseRepository.save(OntologyRelease.create(
                ontologyId,
                request.version(),
                normalize(request.notes()),
                releasedBy,
                classRepository.countByOntologyId(ontologyId),
                propertyRepository.countByOntologyId(ontologyId),
                relationRepository.countByOntologyId(ontologyId)));
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
}
