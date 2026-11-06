CREATE TABLE ontology_properties (
    id UUID PRIMARY KEY,
    ontology_id UUID NOT NULL,
    class_id UUID NOT NULL,
    name VARCHAR(120) NOT NULL,
    description VARCHAR(1000),
    value_type VARCHAR(32) NOT NULL,
    required BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT fk_ontology_properties_ontology FOREIGN KEY (ontology_id) REFERENCES ontologies (id) ON DELETE CASCADE,
    CONSTRAINT fk_ontology_properties_class FOREIGN KEY (class_id) REFERENCES ontology_classes (id) ON DELETE CASCADE,
    CONSTRAINT uk_ontology_properties_class_name UNIQUE (class_id, name)
);

CREATE INDEX idx_ontology_properties_class_updated ON ontology_properties (class_id, updated_at DESC);
