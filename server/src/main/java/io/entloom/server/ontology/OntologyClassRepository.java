package io.entloom.server.ontology;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OntologyClassRepository extends JpaRepository<OntologyClass, UUID> {

    List<OntologyClass> findAllByOntologyIdOrderByUpdatedAtDesc(UUID ontologyId);

    Optional<OntologyClass> findByIdAndOntologyId(UUID id, UUID ontologyId);
}
