package com.felipexw.github.io.graphqldive.graphqldive.repository;

import com.felipexw.github.io.graphqldive.graphqldive.models.Orientation;
import com.felipexw.github.io.graphqldive.graphqldive.models.SuperCharacter;
import com.felipexw.github.io.graphqldive.graphqldive.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperGroupRepository {
    private final List<SuperGroup> groups = new ArrayList<>();

    public SuperGroupRepository(){
        seedGroup();
    }

    private void seedGroup(){
        final List<SuperCharacter> characters = new ArrayList<>();
        characters.add(SuperCharacter.builder()//
                .name("SuperCharacter inside super group name")//
                .id("SuperCharacter id")//
                .age(25)//
                .build());

        final SuperGroup supergroup = SuperGroup.builder()//
                .characters(characters)//
                .name("SuperGroup name")//
                .orientation(Orientation.HERO)//
        .build();

        this.groups.add(supergroup);
    }

    public List<SuperGroup> groups(){
        return this.groups;
    }

    public SuperGroup add(final SuperGroup superGroup) {
        this.groups.add(superGroup);

        return superGroup;
    }

    public SuperGroup groupByName(String name) {
        final List<SuperGroup> superGroups= groups.stream().filter(superGroup ->  superGroup.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return superGroups.isEmpty()  ? null : superGroups.get(0);
    }
}
