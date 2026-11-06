package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

public record OntologyRelationResponse(
        UUID id,
        UUID ontologyId,
        UUID sourceClassId,
        UUID targetClassId,
        String name,
        String description,
        OntologyRelationCardinality cardinality,
        Instant createdAt,
        Instant updatedAt,
        long version) {

    static OntologyRelationResponse from(OntologyRelation relation) {
        return new OntologyRelationResponse(
                relation.getId(),
                relation.getOntologyId(),
                relation.getSourceClassId(),
                relation.getTargetClassId(),
                relation.getName(),
                relation.getDescription(),
                relation.getCardinality(),
                relation.getCreatedAt(),
                relation.getUpdatedAt(),
                relation.getVersion());
    }
}
