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
@Table(name = "ontology_relations")
public class OntologyRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ontology_id", nullable = false)
    private UUID ontologyId;

    @Column(name = "source_class_id", nullable = false)
    private UUID sourceClassId;

    @Column(name = "target_class_id", nullable = false)
    private UUID targetClassId;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private OntologyRelationCardinality cardinality;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @Version
    @Column(nullable = false)
    private long version;

    protected OntologyRelation() {
    }

    public static OntologyRelation create(
            UUID ontologyId,
            UUID sourceClassId,
            UUID targetClassId,
            String name,
            String description,
            OntologyRelationCardinality cardinality) {
        OntologyRelation relation = new OntologyRelation();
        relation.ontologyId = ontologyId;
        relation.sourceClassId = sourceClassId;
        relation.targetClassId = targetClassId;
        relation.name = name;
        relation.description = description;
        relation.cardinality = cardinality;
        return relation;
    }

    public void updateDetails(
            String name,
            String description,
            UUID sourceClassId,
            UUID targetClassId,
            OntologyRelationCardinality cardinality) {
        this.name = name;
        this.description = description;
        this.sourceClassId = sourceClassId;
        this.targetClassId = targetClassId;
        this.cardinality = cardinality;
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

    public UUID getOntologyId() {
        return ontologyId;
    }

    public UUID getSourceClassId() {
        return sourceClassId;
    }

    public UUID getTargetClassId() {
        return targetClassId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OntologyRelationCardinality getCardinality() {
        return cardinality;
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
