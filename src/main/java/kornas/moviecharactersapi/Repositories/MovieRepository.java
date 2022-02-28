package kornas.moviecharactersapi.Repositories;

import kornas.moviecharactersapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
