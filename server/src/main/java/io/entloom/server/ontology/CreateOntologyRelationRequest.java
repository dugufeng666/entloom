package io.entloom.server.ontology;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateOntologyRelationRequest(
        @NotBlank @Size(max = 120) String name,
        @Size(max = 1000) String description,
        @NotNull UUID sourceClassId,
        @NotNull UUID targetClassId,
        @NotNull OntologyRelationCardinality cardinality) {
}
