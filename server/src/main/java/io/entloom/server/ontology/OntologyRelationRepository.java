package io.entloom.server.ontology;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OntologyRelationRepository extends JpaRepository<OntologyRelation, UUID> {

    List<OntologyRelation> findAllByOntologyIdOrderByUpdatedAtDesc(UUID ontologyId);

    Optional<OntologyRelation> findByIdAndOntologyId(UUID id, UUID ontologyId);
}
