package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Character;
import kornas.moviecharactersapi.Models.Movie;
import kornas.moviecharactersapi.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    //create
    @PostMapping("/")
    public Character createCharacter(@RequestBody Character character) {
        characterRepository.save(character);
        return character;
    }

    // Get All
    @GetMapping(value = "/")
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    //Read
    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable Long id) {
        Character character = null;
        if (characterRepository.existsById(id)) {
            // find will guarantee to find a unique character
            character = characterRepository.findById(id).get();
        }
        return character;
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        character.setCharacter_id(id);
        return characterRepository.save(character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        if (characterRepository.existsById(id)) {
            characterRepository.deleteById(id);
        }
    }

}
