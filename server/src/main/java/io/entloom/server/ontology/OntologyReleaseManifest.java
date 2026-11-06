package io.entloom.server.ontology;

import java.util.List;
import java.util.UUID;

public record OntologyReleaseManifest(
        List<ClassSnapshot> classes,
        List<PropertySnapshot> properties,
        List<RelationSnapshot> relations) {

    public record ClassSnapshot(UUID id, String name, String description) {
    }

    public record PropertySnapshot(
            UUID id,
            UUID classId,
            String name,
            String description,
            OntologyPropertyValueType valueType,
            boolean required) {
    }

    public record RelationSnapshot(
            UUID id,
            UUID sourceClassId,
            UUID targetClassId,
            String name,
            String description,
            OntologyRelationCardinality cardinality) {
    }

    static OntologyReleaseManifest of(
            List<OntologyClass> classes,
            List<OntologyProperty> properties,
            List<OntologyRelation> relations) {
        return new OntologyReleaseManifest(
                classes.stream().map(item -> new ClassSnapshot(item.getId(), item.getName(), item.getDescription())).toList(),
                properties.stream().map(item -> new PropertySnapshot(item.getId(), item.getClassId(), item.getName(), item.getDescription(), item.getValueType(), item.isRequired())).toList(),
                relations.stream().map(item -> new RelationSnapshot(item.getId(), item.getSourceClassId(), item.getTargetClassId(), item.getName(), item.getDescription(), item.getCardinality())).toList());
    }
}
