package com.looqbox.backendchallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.looqbox.backendchallenge.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String> {
	
	List<Pokemon> findByNameStartingWith(String name);
	
}
