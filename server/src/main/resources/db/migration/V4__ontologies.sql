CREATE TABLE ontologies (
    id UUID PRIMARY KEY,
    project_id UUID NOT NULL,
    name VARCHAR(120) NOT NULL,
    description VARCHAR(1000),
    status VARCHAR(32) NOT NULL DEFAULT 'DRAFT',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT fk_ontologies_project FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

CREATE INDEX idx_ontologies_project_updated ON ontologies (project_id, updated_at DESC);
