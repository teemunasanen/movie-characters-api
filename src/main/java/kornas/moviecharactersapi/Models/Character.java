package kornas.moviecharactersapi.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URL;

@Entity
@Table
public class Character {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // Full name
    @Column
    @NotBlank
    @Size(min= 3, max= 100)
    public String name;

    // Alias (if applicable)
    @Column
    @Size(max= 100)
    public String alias;

    // Gender
    @Enumerated(EnumType.STRING)
    @Column
    public GenderType gender;

    // Picture (URL to photo – do not store an image)
    @Column
    public URL photoURL;

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
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", gender='" + gender + '\'' +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
