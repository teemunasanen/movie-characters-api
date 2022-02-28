package kornas.moviecharactersapi.Repositories;

import kornas.moviecharactersapi.Models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
