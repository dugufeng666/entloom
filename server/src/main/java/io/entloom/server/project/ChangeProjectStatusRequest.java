package io.entloom.server.project;

import jakarta.validation.constraints.NotNull;

public record ChangeProjectStatusRequest(@NotNull ProjectStatus status) {
}
