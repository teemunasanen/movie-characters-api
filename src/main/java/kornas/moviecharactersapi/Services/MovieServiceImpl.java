package kornas.moviecharactersapi.Services;

import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).get();
    }
    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public void updateMovie(Long movieId, Movie movie) {
        // check if the user with the passed id exists or not
        Movie movieDB = movieRepository.findById(movieId).orElseThrow();
        // If user exists then updated
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        try {
            movieRepository.deleteById(movieId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
