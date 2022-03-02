package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Character;
import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Repositories.MovieRepository;
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
    private MovieRepository movieRepository;

    //create
    @PostMapping("/")
    public Movie createMovie(@RequestBody Movie movie) {
        movie = movieRepository.save(movie);
        return movie;
    }

    // Get All
    @GetMapping(value = "/")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    //Read
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        Movie movie = null;
        if (movieRepository.existsById(id)) {
            // find will guarantee to find a unique movie
            movie = movieRepository.findById(id).get();
        }
        return movie;
    }


    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setMovie_id(id);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        }
    }

}
