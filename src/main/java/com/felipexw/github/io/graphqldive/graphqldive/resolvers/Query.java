package com.felipexw.github.io.graphqldive.graphqldive.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.felipexw.github.io.graphqldive.graphqldive.models.SuperCharacter;
import com.felipexw.github.io.graphqldive.graphqldive.models.SuperGroup;
import com.felipexw.github.io.graphqldive.graphqldive.repository.SuperCharacterRepository;
import com.felipexw.github.io.graphqldive.graphqldive.repository.SuperGroupRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class Query implements GraphQLQueryResolver {

    private final SuperCharacterRepository repository;
    private  final SuperGroupRepository superGroupRepository;

    public Query(final SuperCharacterRepository superCharacterRepository, SuperGroupRepository superGroupRepository){
        this.repository = superCharacterRepository;
        this.superGroupRepository = superGroupRepository;
    }

    public SuperCharacter characterById(String id){
        return this.repository.characterById(id);
    }

    public List<SuperGroup> groups(){
        return  this.superGroupRepository.groups();
    }

    public SuperGroup groupByName(String name){
        return this.superGroupRepository.groupByName(name);
    }

    public List<SuperCharacter> characters(){
        return repository.getCaracters();
    }
}
