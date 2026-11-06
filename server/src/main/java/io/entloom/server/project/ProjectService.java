package io.entloom.server.project;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectResponse> list() {
        return projectRepository.findAllByOrderByUpdatedAtDesc().stream()
                .map(ProjectResponse::from)
                .toList();
    }

    public ProjectResponse get(UUID id) {
        return ProjectResponse.from(requireProject(id));
    }

    @Transactional
    public ProjectResponse create(CreateProjectRequest request) {
        Project project = projectRepository.save(Project.create(request.name().trim(), normalize(request.description())));
        return ProjectResponse.from(project);
    }

    @Transactional
    public ProjectResponse update(UUID id, UpdateProjectRequest request) {
        Project project = requireProject(id);
        project.updateDetails(request.name().trim(), normalize(request.description()));
        projectRepository.saveAndFlush(project);
        return ProjectResponse.from(project);
    }

    @Transactional
    public ProjectResponse changeStatus(UUID id, ProjectStatus status) {
        Project project = requireProject(id);
        project.changeStatus(status);
        projectRepository.saveAndFlush(project);
        return ProjectResponse.from(project);
    }

    private Project requireProject(UUID id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    private String normalize(String description) {
        if (description == null || description.isBlank()) {
            return null;
        }
        return description.trim();
    }
}
