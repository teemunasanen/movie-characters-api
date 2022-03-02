package kornas.moviecharactersapi.Services;

import kornas.moviecharactersapi.Models.Character;

import java.util.List;

public interface CharacterService {
    Character addCharacter(Character character);
    Character getCharacterById(Long characterId);
    void updateCharacter(Long characterId, Character character);
    void deleteCharacterById(Long characterId);
    List<Character> getAllCharacters();
}
