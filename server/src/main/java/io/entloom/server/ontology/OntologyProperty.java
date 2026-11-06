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
@Table(name = "ontology_properties")
public class OntologyProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ontology_id", nullable = false)
    private UUID ontologyId;

    @Column(name = "class_id", nullable = false)
    private UUID classId;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "value_type", nullable = false, length = 32)
    private OntologyPropertyValueType valueType;

    @Column(nullable = false)
    private boolean required;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @Version
    @Column(nullable = false)
    private long version;

    protected OntologyProperty() {
    }

    public static OntologyProperty create(
            UUID ontologyId,
            UUID classId,
            String name,
            String description,
            OntologyPropertyValueType valueType,
            boolean required) {
        OntologyProperty property = new OntologyProperty();
        property.ontologyId = ontologyId;
        property.classId = classId;
        property.name = name;
        property.description = description;
        property.valueType = valueType;
        property.required = required;
        return property;
    }

    public void updateDetails(
            String name,
            String description,
            OntologyPropertyValueType valueType,
            boolean required) {
        this.name = name;
        this.description = description;
        this.valueType = valueType;
        this.required = required;
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

    public UUID getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OntologyPropertyValueType getValueType() {
        return valueType;
    }

    public boolean isRequired() {
        return required;
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
