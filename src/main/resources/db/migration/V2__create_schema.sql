create table role(
                     pk_id uuid primary key default gen_random_uuid(),
                     role_name varchar(100) not null unique,
                     role_description varchar(255)
);

create table team(
                     pk_id uuid primary key default gen_random_uuid(),
                     team_name varchar(100) not null,
                     team_nickname varchar(100),
                     team_description varchar(255),
                     ui_release_date date,
                     api_release_date date,
                     ui_app_version varchar(5),
                     api_app_version varchar(5)
);

create table member(
                pk_id uuid primary key,
                first_name varchar(100) not null,
                last_name varchar(100) not null,
                email varchar(60) not null unique,
                torque_start_date date,
                fk_team_id uuid not null,
                fk_role_id uuid not null,
                foreign key (fk_team_id) references team(pk_id)
                 on update cascade,
                foreign key (fk_role_id) references role(pk_id)
                 on update cascade
);


