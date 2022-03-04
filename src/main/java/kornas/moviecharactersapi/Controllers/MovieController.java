package kornas.moviecharactersapi.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "keycloak_implicit")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Operation(summary = "Create Movie")
    //create
    @PreAuthorize("hasAuthority('ROLE_user')")
    @PostMapping("/")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @Operation(summary = "Get Movies")
    @GetMapping(value = "/")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @Operation(summary = "Get Movie by ID")
    @GetMapping("/{movieId}")
    public Movie getMovie(@Parameter(description = "ID of Movie to be searched")@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @Operation(summary = "Update Movie by ID")
    @PreAuthorize("hasAuthority('ROLE_user')")
    @PutMapping("/{movieId}")
    public ResponseEntity<String> updateMovie(@Parameter(description = "ID of Movie to be updated")@PathVariable Long movieId, @RequestBody Movie movie) {
        try {
            movieService.updateMovie(movieId, movie);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete Movie by ID")
    @PreAuthorize("hasAuthority('ROLE_user')")
    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@Parameter(description = "ID of Movie to be deleted")@PathVariable Long movieId) {
        try {
            movieService.deleteMovieById(movieId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
