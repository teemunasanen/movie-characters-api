package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    //create
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie)
    {
        movie = movieRepository.save(movie);
        return movie;
    }

    //Read
    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Integer id)
    {
        Movie movie = null;
        if(movieRepository.existsById(id))
        {
            // find will guarantee to find a unique movie
            movie = movieRepository.findById(id).get();
        }
        return movie;
    }

}
