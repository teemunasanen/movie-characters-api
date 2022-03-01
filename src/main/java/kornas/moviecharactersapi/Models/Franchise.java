package kornas.moviecharactersapi.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class Franchise {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // Name
    @Column
    @NotBlank
    @Size(max= 200)
    public String name;

    // Description
    @Column
    public String description;
}
