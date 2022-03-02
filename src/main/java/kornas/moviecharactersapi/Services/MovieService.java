package kornas.moviecharactersapi.Services;

import kornas.moviecharactersapi.Models.Movie;

import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    Movie getMovieById(Long movieId);
    void updateMovie(Long movieId, Movie movie);
    void deleteMovieById(Long movieId);
    List<Movie> getAllMovies();
}
