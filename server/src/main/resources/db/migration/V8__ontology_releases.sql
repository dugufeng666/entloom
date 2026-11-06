CREATE TABLE ontology_releases (
    id UUID PRIMARY KEY,
    ontology_id UUID NOT NULL,
    release_version VARCHAR(40) NOT NULL,
    notes VARCHAR(2000),
    released_by VARCHAR(120) NOT NULL,
    released_at TIMESTAMP WITH TIME ZONE NOT NULL,
    class_count BIGINT NOT NULL DEFAULT 0,
    property_count BIGINT NOT NULL DEFAULT 0,
    relation_count BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT fk_ontology_releases_ontology FOREIGN KEY (ontology_id) REFERENCES ontologies (id) ON DELETE CASCADE,
    CONSTRAINT uk_ontology_releases_version UNIQUE (ontology_id, release_version)
);

CREATE INDEX idx_ontology_releases_ontology_released ON ontology_releases (ontology_id, released_at DESC);
