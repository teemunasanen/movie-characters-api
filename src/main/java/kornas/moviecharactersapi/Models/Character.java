package kornas.moviecharactersapi.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
public class Character {
    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long character_id;

    // Full name
    @Column
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    // Alias (if applicable)
    @Column
    @Size(max = 100)
    private String alias;

    // Gender
    @Column
    private String gender;

    // Picture (URL to photo – do not store an image)
    @Column(name = "photo_url")
    private String photoURL;

    @ManyToMany
    @JoinTable(
            name = "movie_characters",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private List<Movie> movies;

    @JsonGetter("movies")
    public List<String> movieGetter() {
        if (movies != null) {
            return movies.stream()
                    .map(movie -> "/api/v1/movies/" + movie.getMovie_id()).collect(Collectors.toList());
        }
        return null;
    }

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    @Nullable
    public Franchise franchise;

    @JsonGetter("franchise")
    public String franchiseGetter() {
        if (franchise != null) {
            return "/api/v1/franchise" + franchise.getFranchise_id();
        }
        return null;
    }

    public Long getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Long character_id) {
        this.character_id = character_id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "Character{" +
                "character_id=" + character_id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", gender=" + gender +
                ", photoURL=" + photoURL +
                ", movies=" + movies +
                '}';
    }
}
