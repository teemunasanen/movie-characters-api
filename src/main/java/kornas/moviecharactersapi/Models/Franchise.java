package kornas.moviecharactersapi.Models;

import javax.persistence.*;

@Entity
@Table
public class Franchise {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // Name
    @Column
    public String name;

    // Description
    @Column
    public String description;
}
