package com.felipexw.github.io.graphqldive.graphqldive.repository;

import com.felipexw.github.io.graphqldive.graphqldive.models.SuperCharacter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class SuperCharacterRepository {

    private final Map<String, SuperCharacter> caracters = new HashMap<>();

    public void seedCharacters() {
        final  SuperCharacter character = SuperCharacter.builder()//
                .id("id1")//
                .name("Super Character one")//
                .age(33)//
                .build();

        final SuperCharacter character2 = SuperCharacter.builder()//
                .id("id2")//
                .name("Super Character two")//
                .age(147)//
                .build();
    this.caracters.put("id1", character);
    this.caracters.put("id2", character2);
    }

    public SuperCharacterRepository(){
        this.seedCharacters();
    }

    public SuperCharacter addCharacter(SuperCharacter newCharacter){
        this.caracters.put(newCharacter.getId(), newCharacter);

        return newCharacter;
    }

    public SuperCharacter characterById(String id){
        return this.caracters.get(id);
    }

    public List<SuperCharacter> getCaracters() {
        return (List<SuperCharacter>) this.caracters.values();
    }
}
