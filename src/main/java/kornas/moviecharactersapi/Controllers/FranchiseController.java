package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Franchise;
import kornas.moviecharactersapi.Repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FranchiseController {

    private FranchiseRepository franchiseRepository;


    //create
    @PostMapping("/franchise")
    public Franchise createFranchise(@RequestBody Franchise franchise)
    {
        franchise = franchiseRepository.save(franchise);
        return franchise;
    }

    //Read
    @GetMapping("/franchise/{id}")
    public Franchise getFranchise(@PathVariable Integer id)
    {
        Franchise franchise = null;
        if(franchiseRepository.existsById(id))
        {
            // find will guarantee to find a unique franchise
            franchise = franchiseRepository.findById(id).get();
        }
        return franchise;
    }

}
