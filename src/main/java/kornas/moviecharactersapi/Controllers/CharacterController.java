package kornas.moviecharactersapi.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import kornas.moviecharactersapi.Models.Character;
import kornas.moviecharactersapi.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "keycloak_implicit")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    //create
    @PreAuthorize("hasAuthority('ROLE_user')")
    @Operation(summary = "Create Character")
    @PostMapping("/")
    public Character addCharacter(@RequestBody Character character) {
        return characterService.addCharacter(character);
    }

    @Operation(summary = "Get Characters")
    @GetMapping(value = "/")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @Operation(summary = "Get Character by ID")
    @GetMapping("/{characterId}")
    public Character getCharacter(@Parameter(description = "ID of Character to be searched")@PathVariable Long characterId) {
        return characterService.getCharacterById(characterId);
    }

    @Operation(summary = "Update Character")
    @PreAuthorize("hasAuthority('ROLE_user')")
    @PutMapping("/{characterId}")
    public ResponseEntity<String> updateCharacter(@Parameter(description = "ID of Character to be updated")@PathVariable Long characterId, @RequestBody Character character) {
       try {
           characterService.updateCharacter(characterId, character);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (RuntimeException e) {
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PreAuthorize("hasAuthority('ROLE_user')")
    @Operation(summary = "Delete Character by ID")
    @DeleteMapping("/{characterId}")
    public ResponseEntity<String> deleteCharacter(@Parameter(description = "ID of Character to be deleted")@PathVariable Long characterId) {
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
