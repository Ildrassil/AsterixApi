package com.asterixapi;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

public interface CharacterRepo extends MongoRepository<Character, String> {
    List<Character> characters = new ArrayList<>();

    List<Character> findAllBy(Query query);




    }

