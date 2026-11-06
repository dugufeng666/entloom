package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes")
public class OntologyClassController {

    private final OntologyClassService ontologyClassService;

    public OntologyClassController(OntologyClassService ontologyClassService) {
        this.ontologyClassService = ontologyClassService;
    }

    @GetMapping
    public List<OntologyClassResponse> list(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId) {
        return ontologyClassService.list(projectId, ontologyId);
    }

    @GetMapping("/{id}")
    public OntologyClassResponse get(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID id) {
        return ontologyClassService.get(projectId, ontologyId, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OntologyClassResponse create(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @Valid @RequestBody CreateOntologyClassRequest request) {
        return ontologyClassService.create(projectId, ontologyId, request);
    }

    @PatchMapping("/{id}")
    public OntologyClassResponse update(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID id,
            @Valid @RequestBody UpdateOntologyClassRequest request) {
        return ontologyClassService.update(projectId, ontologyId, id, request);
    }
}
