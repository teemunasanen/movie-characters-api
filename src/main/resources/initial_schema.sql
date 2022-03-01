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
    franchise_id bigint
        constraint fkgawjcjwjfiy273d7gcjd6s4yb
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
    franchise_id bigint
        constraint fke6bia0emn9rgc6498fspevei
            references franchise
);

create table movie_characters
(
    movie_id     bigint not null
        constraint fkdq7l2xdr2sg2xy6svy09qaa7m
            references movie,
    character_id bigint not null
        constraint fk8d7tg9re0e9rhhynj9h5e6xtt
            references character
);