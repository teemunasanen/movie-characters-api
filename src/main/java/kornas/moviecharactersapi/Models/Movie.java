package kornas.moviecharactersapi.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
public class Movie {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id;

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
    @Column(name = "poster_url")
    private String posterURL;

    // Trailer (YouTube link most likely)
    @Column(name = "trailer_url")
    private String trailerURL;

    @ManyToMany
    @JoinTable(
            name = "movie_characters",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    @Nullable
    public List<Character> characters;

    @JsonGetter("characters")
    public List<String> characterGetter() {
        if(characters != null){
            return characters.stream()
                    .map(character -> "/api/v1/characters/" + character.getCharacter_id()).collect(Collectors.toList());
        }
        return null;
    }

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    @Nullable
    private Franchise franchise;

    @JsonGetter("franchise")
    public String franchiseGetter() {
        if(franchise != null){
            return "/api/v1/franchise" + franchise.getFranchise_id();
        }
        return null;
    }

    public Movie() {
        super();
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
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
