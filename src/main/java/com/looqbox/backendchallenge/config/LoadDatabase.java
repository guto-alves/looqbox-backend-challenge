package com.looqbox.backendchallenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.looqbox.backendchallenge.service.PokemonService;

@Configuration
public class LoadDatabase implements CommandLineRunner {

	@Autowired
	private PokemonService pokemonService;
	
	@Override
	public void run(String... args) throws Exception {
		pokemonService.loadData();
	}

}
