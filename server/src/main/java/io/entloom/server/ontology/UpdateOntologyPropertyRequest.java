package io.entloom.server.ontology;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateOntologyPropertyRequest(
        @NotBlank @Size(max = 120) String name,
        @Size(max = 1000) String description,
        @NotNull OntologyPropertyValueType valueType,
        @NotNull Boolean required) {
}
