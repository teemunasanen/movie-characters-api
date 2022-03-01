create table character
(
    id       serial
        primary key,
    alias    varchar not null,
    gender   varchar not null,
    name     varchar not null,
    photourl varchar not null
);


create table franchise
(
    id          serial
        primary key,
    description varchar(255),
    name        varchar(255)
);

create table movie
(
    id         serial
        primary key,
    director   varchar(255),
    genre      varchar(255),
    posterurl  varchar(255),
    title      varchar(255),
    trailerurl varchar(255),
    year       integer
);


insert into character
    (alias, gender, name, photourl) values
           ('Will', 'Male', 'Will Smith', 'asdasd'),
           ('Bruce', 'Male', 'Bruce Willis', 'asdasd');
