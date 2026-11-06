package io.entloom.server.ontology;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OntologyReleaseConflictException extends RuntimeException {

    public OntologyReleaseConflictException(String message) {
        super(message);
    }
}
