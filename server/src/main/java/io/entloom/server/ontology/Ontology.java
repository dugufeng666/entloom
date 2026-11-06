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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "ontologies")
public class Ontology {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private OntologyStatus status = OntologyStatus.DRAFT;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @Version
    @Column(nullable = false)
    private long version;

    protected Ontology() {
    }

    public static Ontology create(UUID projectId, String name, String description) {
        Ontology ontology = new Ontology();
        ontology.projectId = projectId;
        ontology.name = name;
        ontology.description = description;
        return ontology;
    }

    public void updateDetails(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void changeStatus(OntologyStatus requested) {
        if (requested == status) {
            return;
        }
        boolean allowed = status == OntologyStatus.DRAFT
                && (requested == OntologyStatus.RELEASED || requested == OntologyStatus.ARCHIVED)
                || status == OntologyStatus.RELEASED && requested == OntologyStatus.ARCHIVED;
        if (!allowed) {
            throw new OntologyLifecycleException(status, requested);
        }
        status = requested;
    }

    public void ensureDraft() {
        if (status != OntologyStatus.DRAFT) {
            throw new OntologyReadOnlyException(status);
        }
    }

    @PrePersist
    void onCreate() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OntologyStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public long getVersion() {
        return version;
    }
}
