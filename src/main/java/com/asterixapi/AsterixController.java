package com.asterixapi;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AsterixController {

    CharacterRepo characterRepo;

    public AsterixController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping("/asterix/characters")
    public List<Character> getAllCharacters() {
        return characterRepo.findAll();
    }

    @PostMapping("/asterix/character/create")
    public void createCharacter(Character character) {
        characterRepo.save(character);
        ResponseEntity.ok("Character has been added");
    }

    @DeleteMapping("/asterix/character/{id}")
    public void deleteCharacter(@PathVariable String id){
        if(characterRepo.findById(id).isPresent()) {
            characterRepo.deleteById(id);
            ResponseEntity.ok("Character has been removed");
        }
        else ResponseEntity.badRequest();



    }
}
