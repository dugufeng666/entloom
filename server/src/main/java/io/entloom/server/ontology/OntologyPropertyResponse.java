package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

public record OntologyPropertyResponse(
        UUID id,
        UUID ontologyId,
        UUID classId,
        String name,
        String description,
        OntologyPropertyValueType valueType,
        boolean required,
        Instant createdAt,
        Instant updatedAt,
        long version) {

    static OntologyPropertyResponse from(OntologyProperty property) {
        return new OntologyPropertyResponse(
                property.getId(),
                property.getOntologyId(),
                property.getClassId(),
                property.getName(),
                property.getDescription(),
                property.getValueType(),
                property.isRequired(),
                property.getCreatedAt(),
                property.getUpdatedAt(),
                property.getVersion());
    }
}
