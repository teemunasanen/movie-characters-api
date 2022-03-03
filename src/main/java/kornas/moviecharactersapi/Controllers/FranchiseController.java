package kornas.moviecharactersapi.Controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import kornas.moviecharactersapi.Models.Franchise;
import kornas.moviecharactersapi.Services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "keycloak_implicit")
@RequestMapping("/api/v1/franchises")
@PreAuthorize("hasAuthority('GROUP_user')")
public class FranchiseController {

    @Autowired
    FranchiseService franchiseService;

    //create
    @PostMapping("/")
    public Franchise addFranchise(@RequestBody Franchise franchise) {
        return franchiseService.addFranchise(franchise);
    }

    // Get All
    @GetMapping(value = "/")
    public List<Franchise> getFranchises() {
        return franchiseService.getAllFranchises();
    }

    //Read
    @GetMapping("/{franchiseId}")
    public Franchise getFranchise(@PathVariable Long franchiseId) {
        return franchiseService.getFranchiseById(franchiseId);
    }

    @PutMapping("/{franchiseId}")
    public ResponseEntity<String> updateFranchise(@PathVariable Long franchiseId, @RequestBody Franchise franchise) {
        try {
            franchiseService.updateFranchise(franchiseId, franchise);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{franchiseId}")
    public ResponseEntity<String> deleteFranchise(@PathVariable Long franchiseId) {
        try {
            franchiseService.deleteFranchiseById(franchiseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
