CREATE TABLE ontology_validation_jobs (
    id UUID PRIMARY KEY,
    ontology_id UUID NOT NULL,
    status VARCHAR(20) NOT NULL,
    issues_json TEXT NOT NULL DEFAULT '[]',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    finished_at TIMESTAMP WITH TIME ZONE,
    CONSTRAINT fk_ontology_validation_jobs_ontology FOREIGN KEY (ontology_id) REFERENCES ontologies (id) ON DELETE CASCADE
);
CREATE INDEX idx_ontology_validation_jobs_ontology_created ON ontology_validation_jobs (ontology_id, created_at DESC);
