package kornas.moviecharactersapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class Franchise {

    // Autoincrement Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer franchise_id;

    // Name
    @Column
    @NotBlank
    @Size(max= 200)
    private String name;

    // Description
    @Column
    private String description;

    public Integer getFranchise_id() {
        return franchise_id;
    }

    public void setFranchise_id(Integer franchise_id) {
        this.franchise_id = franchise_id;
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
