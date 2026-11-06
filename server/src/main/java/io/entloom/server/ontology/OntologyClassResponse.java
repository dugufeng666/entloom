package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

public record OntologyClassResponse(
        UUID id,
        UUID ontologyId,
        String name,
        String description,
        Instant createdAt,
        Instant updatedAt,
        long version) {

    static OntologyClassResponse from(OntologyClass ontologyClass) {
        return new OntologyClassResponse(
                ontologyClass.getId(),
                ontologyClass.getOntologyId(),
                ontologyClass.getName(),
                ontologyClass.getDescription(),
                ontologyClass.getCreatedAt(),
                ontologyClass.getUpdatedAt(),
                ontologyClass.getVersion());
    }
}
