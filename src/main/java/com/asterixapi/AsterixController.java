package com.asterixapi;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
