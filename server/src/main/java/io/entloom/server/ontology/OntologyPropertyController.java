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
@RequestMapping("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties")
public class OntologyPropertyController {

    private final OntologyPropertyService propertyService;

    public OntologyPropertyController(OntologyPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<OntologyPropertyResponse> list(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID classId) {
        return propertyService.list(projectId, ontologyId, classId);
    }

    @GetMapping("/{id}")
    public OntologyPropertyResponse get(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID classId,
            @PathVariable UUID id) {
        return propertyService.get(projectId, ontologyId, classId, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OntologyPropertyResponse create(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID classId,
            @Valid @RequestBody CreateOntologyPropertyRequest request) {
        return propertyService.create(projectId, ontologyId, classId, request);
    }

    @PatchMapping("/{id}")
    public OntologyPropertyResponse update(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @PathVariable UUID classId,
            @PathVariable UUID id,
            @Valid @RequestBody UpdateOntologyPropertyRequest request) {
        return propertyService.update(projectId, ontologyId, classId, id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID projectId, @PathVariable UUID ontologyId, @PathVariable UUID classId, @PathVariable UUID id) {
        propertyService.delete(projectId, ontologyId, classId, id);
    }
}
