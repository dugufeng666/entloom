package io.entloom.server.project;

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
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponse> list() {
        return projectService.list();
    }

    @GetMapping("/{id}")
    public ProjectResponse get(@PathVariable UUID id) {
        return projectService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(@Valid @RequestBody CreateProjectRequest request) {
        return projectService.create(request);
    }

    @PatchMapping("/{id}")
    public ProjectResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateProjectRequest request) {
        return projectService.update(id, request);
    }

    @PatchMapping("/{id}/status")
    public ProjectResponse changeStatus(
            @PathVariable UUID id,
            @Valid @RequestBody ChangeProjectStatusRequest request) {
        return projectService.changeStatus(id, request.status());
    }
}
