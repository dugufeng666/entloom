package io.entloom.server.ontology;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OntologyRepository extends JpaRepository<Ontology, UUID> {

    List<Ontology> findAllByProjectIdOrderByUpdatedAtDesc(UUID projectId);

    Optional<Ontology> findByIdAndProjectId(UUID id, UUID projectId);
}
