create table users (
                       id                    bigserial,
                       username              varchar(30) not null unique,
                       password              varchar(80) not null,
                       email                 varchar(50) unique,
                       primary key (id)
);

-- create table roles (
--                        id                    serial,
--                        name                  varchar(50) not null,
--                        primary key (id)
-- );

create table access_permission (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

-- CREATE TABLE users_roles (
--                              user_id               bigint not null,
--                              role_id               int not null,
--                              primary key (user_id, role_id),
--                              foreign key (user_id) references users (id),
--                              foreign key (role_id) references roles (id)
-- );

CREATE TABLE users_access_permission (
                             user_id               bigint not null,
                             access_permission_id               int not null,
                             primary key (user_id, access_permission_id),
                             foreign key (user_id) references users (id),
                             foreign key (access_permission_id) references access_permission (id)
);

insert into access_permission (name)
values
    ('USER'), ('ADMIN');

-- insert into roles (name)
-- values
--     ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email)
values
    ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

-- insert into users_roles (user_id, role_id)
-- values
--     (1, 1);

insert into users_access_permission (user_id, access_permission_id)
values
    (1, 1);