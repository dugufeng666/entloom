package io.entloom.server.ontology;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OntologyNotFoundException extends RuntimeException {

    public OntologyNotFoundException(UUID id) {
        super("Ontology not found: " + id);
    }
}
