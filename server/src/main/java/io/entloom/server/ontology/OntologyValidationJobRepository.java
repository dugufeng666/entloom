package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OntologyValidationJobRepository extends JpaRepository<OntologyValidationJob, UUID> {
    List<OntologyValidationJob> findAllByOntologyIdOrderByCreatedAtDesc(UUID ontologyId);
}
