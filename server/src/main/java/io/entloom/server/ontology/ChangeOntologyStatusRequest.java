package io.entloom.server.ontology;

import jakarta.validation.constraints.NotNull;

public record ChangeOntologyStatusRequest(@NotNull OntologyStatus status) {
}
