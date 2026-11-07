package io.entloom.server.ontology;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OntologyValidationJobResponse(
        UUID id,
        UUID ontologyId,
        OntologyValidationJob.Status status,
        List<OntologyValidationResponse.Issue> issues,
        Instant createdAt,
        Instant finishedAt) { }
