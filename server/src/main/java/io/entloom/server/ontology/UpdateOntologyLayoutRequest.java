package io.entloom.server.ontology;

import java.util.Map;

import jakarta.validation.Valid;

public record UpdateOntologyLayoutRequest(
        @Valid Map<String, OntologyLayoutPosition> positions) {
}
