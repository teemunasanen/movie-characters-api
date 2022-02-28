package kornas.moviecharactersapi.Models;

import javax.persistence.*;

@Entity
@Table
public class Movie {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    // Movie title
    @Column
    public String title;


    // Genre (just a simple string of comma separated genres, there is no genre modelling required as a base)
    @Column
    public String genre;


    // Release year
    @Column
    public Integer year;

    // Director (just a string name, no director modelling required as a base)
    @Column
    public String director;

    // Picture (URL to a movie poster)
    @Column
    public String posterURL;

    // Trailer (YouTube link most likely)
    @Column
    public String trailerURL;
}
