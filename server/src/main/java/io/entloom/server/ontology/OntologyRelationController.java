package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations")
public class OntologyRelationController {

    private final OntologyRelationService relationService;

    public OntologyRelationController(OntologyRelationService relationService) {
        this.relationService = relationService;
    }

    @GetMapping
    public List<OntologyRelationResponse> list(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId) {
        return relationService.list(projectId, ontologyId);
    }

    @GetMapping("/{id}")
    public OntologyRelationResponse get(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID id) {
        return relationService.get(projectId, ontologyId, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OntologyRelationResponse create(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @Valid @RequestBody CreateOntologyRelationRequest request) {
        return relationService.create(projectId, ontologyId, request);
    }

    @PatchMapping("/{id}")
    public OntologyRelationResponse update(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID id,
            @Valid @RequestBody UpdateOntologyRelationRequest request) {
        return relationService.update(projectId, ontologyId, id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID projectId, @PathVariable UUID ontologyId, @PathVariable UUID id) {
        relationService.delete(projectId, ontologyId, id);
    }
}
