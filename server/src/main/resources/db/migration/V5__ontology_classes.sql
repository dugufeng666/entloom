CREATE TABLE ontology_classes (
    id UUID PRIMARY KEY,
    ontology_id UUID NOT NULL,
    name VARCHAR(120) NOT NULL,
    description VARCHAR(1000),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT fk_ontology_classes_ontology FOREIGN KEY (ontology_id) REFERENCES ontologies (id) ON DELETE CASCADE,
    CONSTRAINT uk_ontology_classes_name UNIQUE (ontology_id, name)
);

CREATE INDEX idx_ontology_classes_ontology_updated ON ontology_classes (ontology_id, updated_at DESC);
