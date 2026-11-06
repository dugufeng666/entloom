create table projects (
    id uuid primary key,
    name varchar(120) not null,
    description varchar(1000),
    status varchar(32) not null,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null,
    version bigint not null
);

create index idx_projects_updated_at on projects (updated_at desc);
