package io.entloom.server.ontology;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OntologyClassNotFoundException extends RuntimeException {

    public OntologyClassNotFoundException(UUID id) {
        super("Ontology class not found: " + id);
    }
}
