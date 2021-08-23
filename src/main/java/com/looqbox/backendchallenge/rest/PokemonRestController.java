package com.looqbox.backendchallenge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.looqbox.backendchallenge.service.PokemonService;

@RestController
@RequestMapping("pokemons")
public class PokemonRestController {

	@Autowired
	private PokemonService service;

	@GetMapping
	public ResponseEntity<PokemonResponse> getPokemons(@RequestParam("q") String query) {
		return ResponseEntity.ok(new PokemonResponse(service.getPokemons(query)));
	}

}
