package io.entloom.server.ontology;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OntologyPropertyNotFoundException extends RuntimeException {

    public OntologyPropertyNotFoundException(UUID id) {
        super("Ontology property not found: " + id);
    }
}
