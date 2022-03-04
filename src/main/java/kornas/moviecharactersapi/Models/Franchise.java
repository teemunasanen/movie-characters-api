package kornas.moviecharactersapi.Models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
public class Franchise {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long franchise_id;

    // Name
    @Column
    @NotBlank
    @Size(max = 200)
    private String name;

    // Description
    @Column
    private String description;

    @OneToMany(mappedBy = "franchise")
    public List<Character> characters;

    @JsonGetter("characters")
    public List<String> characterGetter() {
        if (characters != null) {
            return characters.stream()
                    .map(character -> {
                        return "/api/v1/characters/" + character.getCharacter_id();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    @OneToMany(mappedBy = "franchise")
    public List<Movie> movies;

    @JsonGetter("movies")
    public List<String> movieGetter() {
        if (movies != null) {
            return movies.stream()
                    .map(movie -> "/api/v1/movies/" + movie.getMovie_id()).collect(Collectors.toList());
        }
        return null;
    }


    public Long getFranchise_id() {
        return franchise_id;
    }

    public void setFranchise_id(Long franchise_id) {
        this.franchise_id = franchise_id;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Franchise{" +
                "franchise_id=" + franchise_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
