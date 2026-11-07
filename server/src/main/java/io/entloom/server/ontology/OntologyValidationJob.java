package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "ontology_validation_jobs")
public class OntologyValidationJob {

    public enum Status { PENDING, RUNNING, SUCCEEDED, FAILED }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ontology_id", nullable = false)
    private UUID ontologyId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status;
    @Column(name = "issues_json", nullable = false, columnDefinition = "TEXT")
    private String issuesJson = "[]";
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    private Instant finishedAt;

    protected OntologyValidationJob() { }

    static OntologyValidationJob create(UUID ontologyId) {
        OntologyValidationJob job = new OntologyValidationJob();
        job.ontologyId = ontologyId;
        job.status = Status.PENDING;
        return job;
    }

    void complete(String issuesJson) { this.status = Status.SUCCEEDED; this.issuesJson = issuesJson; this.finishedAt = Instant.now(); }
    void fail() { this.status = Status.FAILED; this.finishedAt = Instant.now(); }
    public UUID getId() { return id; }
    public UUID getOntologyId() { return ontologyId; }
    public Status getStatus() { return status; }
    public String getIssuesJson() { return issuesJson; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getFinishedAt() { return finishedAt; }

    @PrePersist
    void onCreate() { createdAt = Instant.now(); }
}
