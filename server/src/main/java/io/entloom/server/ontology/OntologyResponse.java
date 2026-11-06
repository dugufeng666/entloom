package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

public record OntologyResponse(
        UUID id,
        UUID projectId,
        String name,
        String description,
        OntologyStatus status,
        Instant createdAt,
        Instant updatedAt,
        long version) {

    static OntologyResponse from(Ontology ontology) {
        return new OntologyResponse(
                ontology.getId(),
                ontology.getProjectId(),
                ontology.getName(),
                ontology.getDescription(),
                ontology.getStatus(),
                ontology.getCreatedAt(),
                ontology.getUpdatedAt(),
                ontology.getVersion());
    }
}
