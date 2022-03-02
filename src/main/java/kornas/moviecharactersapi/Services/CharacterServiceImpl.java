package kornas.moviecharactersapi.Services;

import kornas.moviecharactersapi.Models.Character;
import kornas.moviecharactersapi.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{
    @Autowired
    private CharacterRepository characterRepository;
    @Override
    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }
    @Override
    public Character getCharacterById(Long characterId) {
        return characterRepository.findById(characterId).get();
    }
    @Override
    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    @Override
    public void updateCharacter(Long characterId, Character character) {
        // check if the user with the passed id exists or not
        Character characterDB = characterRepository.findById(characterId).orElseThrow();
        // If user exists then updated
        characterRepository.save(character);
    }

    @Override
    public void deleteCharacterById(Long characterId) {
        try {
            characterRepository.deleteById(characterId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
