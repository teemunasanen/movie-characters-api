create table character
(
    character_id       serial
        primary key,
    alias    varchar(255),
    gender   varchar(255),
    name     varchar(255),
    photourl varchar(255)
);

create table franchise
(
    franchise_id          serial
        primary key,
    description varchar(255),
    name        varchar(255)
);

create table movie
(
    movie_id     serial
        primary key,
    director     varchar(255),
    genre        varchar(255),
    posterurl    varchar(255),
    title        varchar(255),
    trailerurl   varchar(255),
    year         integer,
    franchise_id integer
            references franchise
);

create table movie_characters
(
    character_id integer
            references character,
    movie_id     integer
            references movie
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
(director, genre, posterurl, title, trailerurl, year, franchise_id) values
('Ridley Scott', 'Action', null, 'Gladiator', null, 2000, null)

