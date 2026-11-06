CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(120) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    display_name VARCHAR(160) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT uk_users_username UNIQUE (username)
);

CREATE TABLE user_roles (
    user_id UUID NOT NULL,
    role VARCHAR(80) NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (user_id, role),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE INDEX idx_user_roles_role ON user_roles (role);
