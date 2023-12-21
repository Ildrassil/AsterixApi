package com.asterixapi;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
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

    @GetMapping("/asterix/character/{query}")
    public List<Character> findAllby(@PathVariable Query query){
        return characterRepo.findAllBy(query);
    }

    @PostMapping("/asterix/character")
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestBody Character character) {
        return characterRepo.save(character);

    }

    @DeleteMapping("/asterix/character/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Character> deleteCharacter(@PathVariable String id){
        if(characterRepo.findById(id).isPresent()) {
            characterRepo.deleteById(id);
            return characterRepo.findAll();
        }
        else throw new NoSuchElementException("The Element you want to delete does not exist");



    }
}
