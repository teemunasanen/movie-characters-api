package kornas.moviecharactersapi.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URL;
import java.util.List;

@Entity
@Table
public class Character {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long character_id;

    // Full name
    @Column(name = "name")
    @NotBlank
    @Size(min= 3, max= 100)
    private String name;

    // Alias (if applicable)
    @Column
    @Size(max= 100)
    private String alias;

    // Gender
    @Enumerated(EnumType.STRING)
    @Column
    private GenderType gender;

    // Picture (URL to photo – do not store an image)
    @Column
    private URL photoURL;

    @ManyToMany
    @JoinTable(
            name = "movie_characters",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private List<Movie> movies;


    public Long getCharacter_id() {
        return character_id;
    }

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    public Franchise franchise;

    @JsonGetter("franchise")
    public String franchiseGetter() {
        System.out.println(franchise);
        if(franchise != null){
            return "/api/v1/franchise" + franchise.getFranchise_id();
        }
        return null;
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

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public URL getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(URL photoURL) {
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
