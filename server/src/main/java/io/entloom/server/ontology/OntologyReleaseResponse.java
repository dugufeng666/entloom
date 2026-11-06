package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

public record OntologyReleaseResponse(
        UUID id,
        UUID ontologyId,
        String version,
        String notes,
        String releasedBy,
        Instant releasedAt,
        long classCount,
        long propertyCount,
        long relationCount) {

    static OntologyReleaseResponse from(OntologyRelease release) {
        return new OntologyReleaseResponse(
                release.getId(),
                release.getOntologyId(),
                release.getVersion(),
                release.getNotes(),
                release.getReleasedBy(),
                release.getReleasedAt(),
                release.getClassCount(),
                release.getPropertyCount(),
                release.getRelationCount());
    }
}
