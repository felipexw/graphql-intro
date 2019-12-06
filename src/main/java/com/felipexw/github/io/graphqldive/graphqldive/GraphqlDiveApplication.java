package com.felipexw.github.io.graphqldive.graphqldive;

import com.felipexw.github.io.graphqldive.graphqldive.repository.SuperCharacterRepository;
import com.felipexw.github.io.graphqldive.graphqldive.repository.SuperGroupRepository;
import com.felipexw.github.io.graphqldive.graphqldive.resolvers.Mutation;
import com.felipexw.github.io.graphqldive.graphqldive.resolvers.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlDiveApplication {

	@Autowired
	private SuperCharacterRepository repository;
	@Autowired
	private SuperGroupRepository superGroupRepository;

	@Bean
	public Query query() {
		return new Query(repository, superGroupRepository);
	}

	@Bean
	public Mutation mutation(){
		return new Mutation(repository, superGroupRepository);
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDiveApplication.class, args);
	}

}
