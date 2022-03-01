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
    ('Ridley Scott', 'Action', null, 'Gladiator', null, 2000, null),
    ('James Cameron', 'Drama',null,'Titanic',null, 1998, 1);

insert into movie_characters
    (movie_id, character_id) values
        (1,1),
        (1,2);

