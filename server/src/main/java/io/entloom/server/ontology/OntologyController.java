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
@RequestMapping("/api/v1/projects/{projectId}/ontologies")
public class OntologyController {

    private final OntologyService ontologyService;
    private final OntologyValidationService validationService;

    public OntologyController(OntologyService ontologyService, OntologyValidationService validationService) {
        this.ontologyService = ontologyService;
        this.validationService = validationService;
    }

    @GetMapping
    public List<OntologyResponse> list(@PathVariable UUID projectId) {
        return ontologyService.list(projectId);
    }

    @GetMapping("/{id}")
    public OntologyResponse get(@PathVariable UUID projectId, @PathVariable UUID id) {
        return ontologyService.get(projectId, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OntologyResponse create(
            @PathVariable UUID projectId,
            @Valid @RequestBody CreateOntologyRequest request) {
        return ontologyService.create(projectId, request);
    }

    @PatchMapping("/{id}")
    public OntologyResponse update(
            @PathVariable UUID projectId,
            @PathVariable UUID id,
            @Valid @RequestBody UpdateOntologyRequest request) {
        return ontologyService.update(projectId, id, request);
    }

    @PatchMapping("/{id}/status")
    public OntologyResponse changeStatus(
            @PathVariable UUID projectId,
            @PathVariable UUID id,
            @Valid @RequestBody ChangeOntologyStatusRequest request) {
        return ontologyService.changeStatus(projectId, id, request.status());
    }

    @PostMapping("/{id}/fork")
    @ResponseStatus(HttpStatus.CREATED)
    public OntologyResponse fork(
            @PathVariable UUID projectId,
            @PathVariable UUID id,
            @Valid @RequestBody ForkOntologyRequest request) {
        return ontologyService.fork(projectId, id, request);
    }

    @GetMapping("/{id}/validation")
    public OntologyValidationResponse validate(@PathVariable UUID projectId, @PathVariable UUID id) {
        return validationService.validate(projectId, id);
    }

    @GetMapping("/{id}/layout")
    public OntologyLayoutResponse layout(@PathVariable UUID projectId, @PathVariable UUID id) {
        return ontologyService.layout(projectId, id);
    }

    @PatchMapping("/{id}/layout")
    public OntologyLayoutResponse updateLayout(
            @PathVariable UUID projectId,
            @PathVariable UUID id,
            @Valid @RequestBody UpdateOntologyLayoutRequest request) {
        return ontologyService.updateLayout(projectId, id, request);
    }
}
