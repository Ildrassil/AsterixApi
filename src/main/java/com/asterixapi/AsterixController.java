package com.asterixapi;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
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

    @GetMapping("/asterix/character/{query}")
    public List<Character> findAllby(@PathVariable Query query){
        return characterRepo.findAllBy(query);
    }

    @PostMapping("/asterix/character")
    public ResponseEntity<String> createCharacter(@RequestBody Character character) {
        characterRepo.save(character);
        return ResponseEntity.ok("Character has been added");
    }

    @DeleteMapping("/asterix/character/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable String id){
        if(characterRepo.findById(id).isPresent()) {
            characterRepo.deleteById(id);
            return ResponseEntity.ok("Character has been removed");
        }
        else return ResponseEntity.ok("Bad request");



    }
}
