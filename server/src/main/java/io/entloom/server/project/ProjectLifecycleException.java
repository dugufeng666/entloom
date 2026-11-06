package io.entloom.server.project;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProjectLifecycleException extends RuntimeException {

    public ProjectLifecycleException(ProjectStatus current, ProjectStatus requested) {
        super("Cannot transition project from " + current + " to " + requested);
    }
}
