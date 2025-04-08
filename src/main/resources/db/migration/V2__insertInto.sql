
insert into role( name, description, active, created_at, created_by)
values ('admin', 'can perform crud operations', 1, now(), 'flyway');

insert into role(name, description, active, created_at, created_by)
values ('user', 'can perform read operations', 1, now(), 'flyway');

insert into doc_type(name, description, active, created_at, created_by)
values('DNI', 'Documento Nacional de Identidad', 1, now(), 'flyway');

insert into doc_type(name, description, active, created_at, created_by)
values('CE', 'Carnet de Extranjeria', 1, now(), 'flyway');