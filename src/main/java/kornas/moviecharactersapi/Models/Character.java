package kornas.moviecharactersapi.Models;

import javax.persistence.*;

@Entity
@Table
public class Character {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // Full name
    @Column
    public String name;

    // Alias (if applicable)
    @Column
    public String alias;

    // Gender
    @Column
    public String gender;

    // Picture (URL to photo – do not store an image)
    @Column
    public String photoURL;

}
