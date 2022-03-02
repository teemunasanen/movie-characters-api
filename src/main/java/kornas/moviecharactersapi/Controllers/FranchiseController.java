package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Franchise;
import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseRepository franchiseRepository;

    //create
    @PostMapping("/")
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        franchise = franchiseRepository.save(franchise);
        return franchise;
    }

    // Get All
    @GetMapping(value = "/")
    public List<Franchise> getFranchises() {
        return franchiseRepository.findAll();
    }

    //Read
    @GetMapping("/{id}")
    public Franchise getFranchise(@PathVariable Long id) {
        Franchise franchise = null;
        if (franchiseRepository.existsById(id)) {
            // find will guarantee to find a unique franchise
            franchise = franchiseRepository.findById(id).get();
        }
        return franchise;
    }

    @PutMapping("/{id}")
    public Franchise updateFranchise(@PathVariable Long id, @RequestBody Franchise franchise) {
        franchise.setFranchise_id(id);
        return franchiseRepository.save(franchise);
    }

    @DeleteMapping("/{id}")
    public void deleteFranchise(@PathVariable Long id) {
        if (franchiseRepository.existsById(id)) {
            franchiseRepository.deleteById(id);
        }
    }

}
