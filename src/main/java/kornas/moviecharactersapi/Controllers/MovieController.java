package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //create
    @PostMapping("/")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // Get All
    @GetMapping(value = "/")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    //Read
    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }


    @PutMapping("/{movieId}")
    public ResponseEntity<String> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie) {
        try {
            movieService.updateMovie(movieId, movie);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long movieId) {
        try {
            movieService.deleteMovieById(movieId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
