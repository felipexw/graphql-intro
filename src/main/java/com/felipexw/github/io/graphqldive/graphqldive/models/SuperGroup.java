package com.felipexw.github.io.graphqldive.graphqldive.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Builder
public class SuperGroup {

    private String name;
    private Orientation orientation;
    private List<SuperCharacter> characters = new ArrayList<>();

    public void addCharacter(final SuperCharacter superCharacter) {
        if (superCharacter != null)
            characters.add(superCharacter);
    }

    public void removeCharacter(final SuperCharacter superCharacter) {
        this.characters = characters.stream().filter(c -> !c.getName().equalsIgnoreCase(superCharacter.getName())).collect(Collectors.toList());
    }
}
