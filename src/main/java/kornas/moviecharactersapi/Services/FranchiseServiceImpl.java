package kornas.moviecharactersapi.Services;

import kornas.moviecharactersapi.Models.Franchise;
import kornas.moviecharactersapi.Repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;
    @Override
    public Franchise addFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }
    @Override
    public Franchise getFranchiseById(Long franchiseId) {
        return franchiseRepository.findById(franchiseId).get();
    }
    @Override
    public List<Franchise> getAllFranchises(){
        return franchiseRepository.findAll();
    }

    @Override
    public void updateFranchise(Long franchiseId, Franchise franchise) {
        // check if the user with the passed id exists or not
        Franchise franchiseDB = franchiseRepository.findById(franchiseId).orElseThrow();
        // If user exists then updated
        franchiseRepository.save(franchise);
    }

    @Override
    public void deleteFranchiseById(Long franchiseId) {
        try {
            franchiseRepository.deleteById(franchiseId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
