ALTER TABLE ontologies ADD COLUMN validation_require_class_properties BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE ontologies ADD COLUMN validation_allow_self_relations BOOLEAN NOT NULL DEFAULT TRUE;
