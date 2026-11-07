package io.entloom.server.ontology;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record OntologyTransferRequest(
        @NotBlank String name,
        String description,
        List<@Valid ClassTransfer> classes,
        List<@Valid RelationTransfer> relations) {

    public record ClassTransfer(@NotBlank String name, String description, List<@Valid PropertyTransfer> properties) {
    }

    public record PropertyTransfer(
            @NotBlank String name,
            String description,
            OntologyPropertyValueType valueType,
            boolean required) {
    }

    public record RelationTransfer(
            @NotBlank String name,
            String description,
            String sourceClass,
            String targetClass,
            OntologyRelationCardinality cardinality) {
    }
}
