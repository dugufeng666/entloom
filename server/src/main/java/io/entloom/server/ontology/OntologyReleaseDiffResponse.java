package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

public record OntologyReleaseDiffResponse(
        UUID fromReleaseId,
        String fromVersion,
        UUID toReleaseId,
        String toVersion,
        List<OntologyReleaseChange> changes) {

    public record OntologyReleaseChange(
            String kind,
            String changeType,
            UUID itemId,
            String name,
            String location,
            Object before,
            Object after) {
    }
}
