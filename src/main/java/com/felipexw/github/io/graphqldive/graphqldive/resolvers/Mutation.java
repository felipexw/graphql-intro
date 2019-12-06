package com.felipexw.github.io.graphqldive.graphqldive.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.felipexw.github.io.graphqldive.graphqldive.models.Orientation;
import com.felipexw.github.io.graphqldive.graphqldive.models.SuperCharacter;
import com.felipexw.github.io.graphqldive.graphqldive.models.SuperGroup;
import com.felipexw.github.io.graphqldive.graphqldive.repository.SuperCharacterRepository;
import com.felipexw.github.io.graphqldive.graphqldive.repository.SuperGroupRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mutation implements GraphQLMutationResolver {

    private final SuperCharacterRepository repository;
    private final SuperGroupRepository superGroupRepository;

    public Mutation(final SuperCharacterRepository repository, final SuperGroupRepository superGroupRepository){
        this.repository = repository;
        this.superGroupRepository = superGroupRepository;
    }

    public SuperCharacter addCharacter(String id, String name, Integer age){
        final SuperCharacter character =
        SuperCharacter.builder()//
                .id(id)//
                .name(name)//
                .age(age)//
                .build();
        this.repository.addCharacter(character);

        return character;
    }

    public SuperGroup addGroupName(String name, Orientation orientation){
        final SuperGroup superGroup = SuperGroup.builder()//
                .orientation(orientation)//
                .name(name)//
                .build();

        this.superGroupRepository.add(superGroup);

        return superGroup;
    }
}
