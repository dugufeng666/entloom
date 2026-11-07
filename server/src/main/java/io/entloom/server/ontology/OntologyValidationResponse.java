package io.entloom.server.ontology;

import java.util.List;

public record OntologyValidationResponse(boolean valid, List<Issue> issues) {

    public record Issue(String severity, String code, String message, String location) {
    }
}
