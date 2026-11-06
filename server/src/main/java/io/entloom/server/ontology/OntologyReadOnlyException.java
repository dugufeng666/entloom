package io.entloom.server.ontology;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OntologyReadOnlyException extends RuntimeException {

    public OntologyReadOnlyException(OntologyStatus status) {
        super("Ontology is read-only in status " + status);
    }
}
