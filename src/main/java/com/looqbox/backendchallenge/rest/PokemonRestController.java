package com.looqbox.backendchallenge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.looqbox.backendchallenge.model.Pokemon;
import com.looqbox.backendchallenge.service.PokemonService;

@RestController
@RequestMapping("pokemons")
public class PokemonRestController {

	@Autowired
	private PokemonService service;

	@GetMapping
	public ResponseEntity<PokemonResponse> getPokemons(@RequestParam("q") String query, 
			@RequestParam(value = "order", required = false, defaultValue = "alphabetical") String sortOrder) {
		List<Pokemon> pokemons = service.getPokemons(query, sortOrder);
		return ResponseEntity.ok(new PokemonResponse(pokemons));
	}

}
