create table franchise
(
    franchise_id bigserial
        primary key,
    description  varchar(255),
    name         varchar(255)
);

create table character
(
    character_id bigserial
        primary key,
    alias        varchar(255),
    gender       varchar(255),
    name         varchar(255),
    photourl     varchar(255),
    franchise_id integer
            references franchise
);

create table movie
(
    movie_id     bigserial
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
    movie_id     bigint not null
            references movie,
    character_id bigint not null
            references character
);

insert into franchise
(description, name) values
                        ('star wars saga', 'Star Wars Saga'),
                        ('lord of the rings trilogy', 'Lord of The Rings Trilogy');

insert into character
    (alias, gender, name, photourl, franchise_id) VALUES
           ('Will', 'Male', 'Will Smith', null, 1),
           ('Bruce', 'Male', 'Bruce Willis', null, 2);


insert into movie
    (director, genre, posterurl, title, trailerurl, "year", franchise_id) values
                                                                                 ('Ridley Scott', 'Action', null, 'Gladiator', null, 2000, null)

