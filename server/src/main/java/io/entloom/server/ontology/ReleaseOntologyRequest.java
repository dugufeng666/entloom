package io.entloom.server.ontology;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ReleaseOntologyRequest(
        @NotBlank @Pattern(regexp = "\\d+\\.\\d+\\.\\d+", message = "version must use MAJOR.MINOR.PATCH") String version,
        @Size(max = 2000) String notes) {
}
