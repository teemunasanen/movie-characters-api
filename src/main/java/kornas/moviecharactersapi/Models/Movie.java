package kornas.moviecharactersapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Movie {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    // Movie title
    @Column
    private String title;


    // Genre (just a simple string of comma separated genres, there is no genre modelling required as a base)
    @Column
    private String genre;


    // Release year
    @Column
    private Integer year;

    // Director (just a string name, no director modelling required as a base)
    @Column
    private String director;

    // Picture (URL to a movie poster)
    @Column
    private String posterURL;

    // Trailer (YouTube link most likely)
    @Column
    private String trailerURL;

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", trailerURL='" + trailerURL + '\'' +
                '}';
    }
}
