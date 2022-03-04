package kornas.moviecharactersapi.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/api/v1/franchises")

public class FranchiseController {

    @Autowired
    FranchiseService franchiseService;

    @Operation(summary = "Create Franchise")

    //create
    @PreAuthorize("hasAuthority('ROLE_user')")
    @SecurityRequirement(name = "keycloak_implicit")
    @PostMapping("/")
    public Franchise addFranchise(@RequestBody Franchise franchise) {
        return franchiseService.addFranchise(franchise);
    }

    @Operation(summary = "Get Franchises")
    @GetMapping(value = "/")
    public List<Franchise> getFranchises() {
        return franchiseService.getAllFranchises();
    }

    @Operation(summary = "Get Franchise by ID")
    @GetMapping("/{franchiseId}")
    public Franchise getFranchise(@Parameter(description = "ID of Franchise to be searched")@PathVariable Long franchiseId) {
        return franchiseService.getFranchiseById(franchiseId);
    }

    @Operation(summary = "Update Franchise by ID")
    @PreAuthorize("hasAuthority('ROLE_user')")
    @SecurityRequirement(name = "keycloak_implicit")
    @PutMapping("/{franchiseId}")
    public ResponseEntity<String> updateFranchise(@Parameter(description = "ID of Franchise to be updated")@PathVariable Long franchiseId, @RequestBody Franchise franchise) {
        try {
            franchiseService.updateFranchise(franchiseId, franchise);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete Franchise by ID")
    @PreAuthorize("hasAuthority('ROLE_user')")
    @SecurityRequirement(name = "keycloak_implicit")
    @DeleteMapping("/{franchiseId}")
    public ResponseEntity<String> deleteFranchise(@Parameter(description = "ID of Franchise to be deleted")@PathVariable Long franchiseId) {
        try {
            franchiseService.deleteFranchiseById(franchiseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
