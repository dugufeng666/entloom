package io.entloom.server.ontology;

import java.util.Map;

public record OntologyLayoutResponse(Map<String, OntologyLayoutPosition> positions) {
}
