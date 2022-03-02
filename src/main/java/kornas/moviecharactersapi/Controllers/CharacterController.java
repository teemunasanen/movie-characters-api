package kornas.moviecharactersapi.Controllers;

import kornas.moviecharactersapi.Models.Character;
import kornas.moviecharactersapi.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    //create
    @PostMapping("/")
    public Character addCharacter(@RequestBody Character character) {
        return characterService.addCharacter(character);
    }

    // Get All
    @GetMapping(value = "/")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    //Read
    @GetMapping("/{characterId}")
    public Character getCharacter(@PathVariable Long characterId) {
        return characterService.getCharacterById(characterId);
    }

    @PutMapping("/{characterId}")
    public ResponseEntity<String> updateCharacter(@PathVariable Long characterId, @RequestBody Character character) {
       try {
           characterService.updateCharacter(characterId, character);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (RuntimeException e) {
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{characterId}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long characterId) {
        try {
            characterService.deleteCharacterById(characterId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(RuntimeException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
