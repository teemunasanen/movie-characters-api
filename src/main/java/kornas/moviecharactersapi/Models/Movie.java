package kornas.moviecharactersapi.Models;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URL;

@Entity
@Table
public class Movie {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    // Movie title
    @Column
    @NotBlank
    @Size(min= 3, max= 200)
    public String title;


    // Genre (just a simple string of comma separated genres, there is no genre modelling required as a base)
    @Enumerated(EnumType.STRING)
    @Column
    public GenreType genre;


    // Release year
    @Column
    @Size(min=1888)
    public Integer year;

    // Director (just a string name, no director modelling required as a base)
    @Column
    public String director;

    // Picture (URL to a movie poster)
    @Column
    public URL posterURL;

    // Trailer (YouTube link most likely)
    @Column
    public URL trailerURL;
}
