create table character
(
    id       serial
        primary key,
    alias    varchar(255) not null,
    gender   varchar(255) not null,
    name     varchar(255) not null,
    photourl varchar(255) not null
);


create table franchise
(
    id          serial
        primary key,
    description varchar(255) not null,
    name        varchar(255) not null
);

create table movie
(
    id         serial
        primary key,
    director   varchar(255) not null,
    genre      varchar(255) not null,
    posterurl  varchar(255),
    title      varchar(255) not null,
    trailerurl varchar(255),
    year       integer not null
);


insert into character
    (alias, gender, name, photourl) values
           ('Will', 'Male', 'Will Smith', 'asdasd'),
           ('Bruce', 'Male', 'Bruce Willis', 'asdasd');

insert into franchise
(description, name) values
('star wars saga', 'Star Wars Saga'),
                           ('lord of the rings trilogy', 'Lord of The Rings Trilogy');

insert into movie
(director, genre, posterurl, title, trailerurl, "year") values
('Ridley Scott', 'Action', null, 'Gladiator', null, 2000)

