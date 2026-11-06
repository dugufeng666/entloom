package io.entloom.server.ontology;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OntologyLifecycleException extends RuntimeException {

    public OntologyLifecycleException(OntologyStatus current, OntologyStatus requested) {
        super("Cannot transition ontology from " + current + " to " + requested);
    }
}
