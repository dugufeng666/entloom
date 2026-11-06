package io.entloom.server.ontology;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OntologyPropertyRepository extends JpaRepository<OntologyProperty, UUID> {

    List<OntologyProperty> findAllByClassIdOrderByUpdatedAtDesc(UUID classId);

    long countByOntologyId(UUID ontologyId);

    Optional<OntologyProperty> findByIdAndClassId(UUID id, UUID classId);
}
