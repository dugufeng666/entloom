CREATE TABLE ontology_relations (
    id UUID PRIMARY KEY,
    ontology_id UUID NOT NULL,
    source_class_id UUID NOT NULL,
    target_class_id UUID NOT NULL,
    name VARCHAR(120) NOT NULL,
    description VARCHAR(1000),
    cardinality VARCHAR(32) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT fk_ontology_relations_ontology FOREIGN KEY (ontology_id) REFERENCES ontologies (id) ON DELETE CASCADE,
    CONSTRAINT fk_ontology_relations_source_class FOREIGN KEY (source_class_id) REFERENCES ontology_classes (id) ON DELETE CASCADE,
    CONSTRAINT fk_ontology_relations_target_class FOREIGN KEY (target_class_id) REFERENCES ontology_classes (id) ON DELETE CASCADE,
    CONSTRAINT uk_ontology_relations_name UNIQUE (ontology_id, name)
);

CREATE INDEX idx_ontology_relations_ontology_updated ON ontology_relations (ontology_id, updated_at DESC);
