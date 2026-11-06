package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases")
public class OntologyReleaseController {

    private final OntologyReleaseService releaseService;

    public OntologyReleaseController(OntologyReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping
    public List<OntologyReleaseResponse> list(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId) {
        return releaseService.list(projectId, ontologyId);
    }

    @GetMapping("/diff")
    public OntologyReleaseDiffResponse diff(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @RequestParam UUID from,
            @RequestParam UUID to) {
        return releaseService.diff(projectId, ontologyId, from, to);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OntologyReleaseResponse release(
            @PathVariable UUID projectId,
            @PathVariable UUID ontologyId,
            @Valid @RequestBody ReleaseOntologyRequest request,
            Authentication authentication) {
        return releaseService.release(projectId, ontologyId, request, authentication.getName());
    }
}
