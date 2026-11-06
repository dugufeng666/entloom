package io.entloom.server.ontology;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "ontology_releases", uniqueConstraints = @UniqueConstraint(
        name = "uk_ontology_releases_version",
        columnNames = {"ontology_id", "release_version"}))
public class OntologyRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ontology_id", nullable = false)
    private UUID ontologyId;

    @Column(name = "release_version", nullable = false, length = 40)
    private String version;

    @Column(length = 2000)
    private String notes;

    @Column(name = "released_by", nullable = false, length = 120)
    private String releasedBy;

    @Column(name = "released_at", nullable = false)
    private Instant releasedAt;

    @Column(name = "class_count", nullable = false)
    private long classCount;

    @Column(name = "property_count", nullable = false)
    private long propertyCount;

    @Column(name = "relation_count", nullable = false)
    private long relationCount;

    protected OntologyRelease() {
    }

    public static OntologyRelease create(
            UUID ontologyId,
            String version,
            String notes,
            String releasedBy,
            long classCount,
            long propertyCount,
            long relationCount) {
        OntologyRelease release = new OntologyRelease();
        release.ontologyId = ontologyId;
        release.version = version;
        release.notes = notes;
        release.releasedBy = releasedBy;
        release.classCount = classCount;
        release.propertyCount = propertyCount;
        release.relationCount = relationCount;
        return release;
    }

    @PrePersist
    void onCreate() {
        releasedAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getOntologyId() {
        return ontologyId;
    }

    public String getVersion() {
        return version;
    }

    public String getNotes() {
        return notes;
    }

    public String getReleasedBy() {
        return releasedBy;
    }

    public Instant getReleasedAt() {
        return releasedAt;
    }

    public long getClassCount() {
        return classCount;
    }

    public long getPropertyCount() {
        return propertyCount;
    }

    public long getRelationCount() {
        return relationCount;
    }
}
