insert into franchise
(description, name) values
    ('star wars saga', 'Star Wars Saga'),
    ('lord of the rings trilogy', 'Lord of The Rings Trilogy'),
    ('The Expendables 2010, The Expendables 2 2012, The Expendables 3 2014', 'The Expendables'),
    ('M.I.B','Men inBlack'),
    ('The Marvel Cinematic Universe (MCU) films are a series of American superhero films produced by Marvel Studios based on characters that appear in publications by Marvel Comics.','Marvel Cinematic Universe'),
    ('All five films revolve around the main character of John McClane, a New York City/Los Angeles police detective who continually finds himself in the middle of a crisis where he is the only hope against disaster.','Die Hard');


insert into character
(alias, gender, name, photo_url, franchise_id) VALUES
    ('Will', 'Male', 'Will Smith', 'https://imdb-api.com/images/original/MV5BYWY3ZDRjNzItNzcyZS00NGFiLWEzMWYtOTg5N2NlNTBhNWE0XkEyXkFqcGdeQXVyMDI2NDg0NQ@@._V1_Ratio2.5800_AL_.jpg', 4),
    ('Bruce', 'Male', 'Bruce Willis', 'https://imdb-api.com/images/original/MV5BZGFmMDg1M2ItNDA0Ni00OTNmLTgwOWUtMmJmMzE1ZTJlOWZjXkEyXkFqcGdeQXVyNTk5NzQ5Ng@@._V1_Ratio1.0000_AL_.jpg', 3),
    ('Sly', 'Male', 'Sylvester Stallone','https://imdb-api.com/images/original/MV5BZDBiZDI5MzMtNGY3NC00YWZlLWI4N2MtMDhhZTI5MmMzZWMzXkEyXkFqcGdeQXVyMDc2NTEzMw@@._V1_Ratio1.0000_AL_.jpg', 3),
    (null, 'Female', 'Scarlett Johansson','https://imdb-api.com/images/original/MV5BYTQ4YjE0NzQtN2RhYy00OTI4LTliYmItMjMyNzFjNDI2ZmE4XkEyXkFqcGdeQXVyMzk3NTUwOQ@@._V1_Ratio1.3200_AL_.jpg', 5),
    (null, 'Male', 'Ewan McGregor','https://imdb-api.com/images/original/MV5BMTIwNjFmODUtNGRhMi00MmE4LTg5ZGUtMmM1MWZlN2NhYmIzXkEyXkFqcGdeQXVyODY0NzcxNw@@._V1_Ratio1.7800_AL_.jpg',1),
    (null, 'Female', 'Kate Winslet','https://imdb-api.com/images/original/MV5BYWRhZTRjNjctOWE4Ni00NzVkLWE2MDctOWU2YTg4NjQ5ODc3XkEyXkFqcGdeQXVyMTI3MDk3MzQ@._V1_Ratio1.8400_AL_.jpg', null ),
    ('R2-D2', 'Male', 'Kenny Baker','https://imdb-api.com/images/original/MV5BZDQ5MjMwZjItMmIzMS00NjhmLTljMjktY2VmMmZkZjhhZjgwXkEyXkFqcGdeQXVyNjUxMjc1OTM@._V1_Ratio2.3400_AL_.jpg', 1),
    ('Frodo', 'Male', 'Elijah Wood','https://imdb-api.com/images/original/MV5BODM1MGNhY2UtZDYzMS00Y2ZmLWEwNTQtNjUxYWU4MzdjY2UyXkEyXkFqcGdeQXVyMzQ3Nzk5MTU@._V1_Ratio1.2400_AL_.jpg', 2),
    ('Bruce', 'Male', 'Bruce Willis', 'https://imdb-api.com/images/original/MV5BZGFmMDg1M2ItNDA0Ni00OTNmLTgwOWUtMmJmMzE1ZTJlOWZjXkEyXkFqcGdeQXVyNTk5NzQ5Ng@@._V1_Ratio1.0000_AL_.jpg', 6);
    /* second Bruce*/

insert into movie
(director, genre, poster_url, title, trailer_url, "year", franchise_id) values
    ('Ridley Scott', 'Action', null, 'Gladiator', null, 2000, null),
    ('James Cameron', 'Drama',null,'Titanic',null, 1998, null),
    ('Sylvester Stallone', 'Action, Adventure, Thriller', 'https://image.tmdb.org/t/p/original/8jaGgmv8TB8exGRHngoMnpldueN.jpg', 'The Expendables', 'https://www.imdb.com/video/vi3501000217', 2010, 3),
    ('Barry Sonnenfeld', 'Action, Adventure, Comedy', 'https://image.tmdb.org/t/p/original/r3sQG7LkOtau4z89JxA1vQeZgRE.jpg', 'Men in Black', 'https://www.imdb.com/video/vi1466737177', 1997, 4),
    ('Joss Whedon', 'Action, Adventure', 'https://imdb-api.com/posters/original/teYOVI8LefohywmizwsYdoBTul3.jpg', 'The Avengers', 'https://www.imdb.com/video/vi1891149081', 2012, 5),
    ('Gearge Lucas', 'Action, Adventure, Fantasy', 'https://imdb-api.com/posters/original/ct7BSqV6Cxwd6dMUAVsBefXA3vz.jpg', 'Star Wars: Episode I - The Phantom Menace', 'https://www.imdb.com/video/vi2143788569', 1999, 1),
    ('Francis Lawrence', 'Action, Drama', 'https://imdb-api.com/posters/original/iPDkaSdKk2jRLTM65UOEoKtsIZ8.jpg', 'I Am Legend', 'https://www.imdb.com/video/vi3820028185',2007 , null),
    ('Peter Jackson', 'Action, Adventure, Drama', 'https://imdb-api.com/posters/original/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg', 'The Lord of the Rings: The Fellowship of the Ring', 'https://www.imdb.com/video/vi684573465',2001 ,2);


insert into movie_characters
    (movie_id, character_id) values
        (1,5),(1,6),(5,4),(4,1),(3,3),(6,7),(7,1),(3,2),(8,8);

/* insert into franchise_characters(franchise_id, character_id) values( , );*/

