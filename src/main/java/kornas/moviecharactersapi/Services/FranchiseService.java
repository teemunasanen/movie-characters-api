package kornas.moviecharactersapi.Services;

import kornas.moviecharactersapi.Models.Franchise;

import java.util.List;

public interface FranchiseService {
    Franchise addFranchise(Franchise franchise);
    Franchise getFranchiseById(Long franchiseId);
    void updateFranchise(Long franchiseId, Franchise franchise);
    void deleteFranchiseById(Long franchiseId);
    List<Franchise> getAllFranchises();
}
