package com.looqbox.backendchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.looqbox.backendchallenge.model.Pokemon;
import com.looqbox.backendchallenge.repository.PokemonRepository;
import com.looqbox.backendchallenge.rest.PokemonResponse;
import com.looqbox.backendchallenge.util.PokemonsUtil;
import com.looqbox.backendchallenge.util.SortOrder;

@Service
public class PokemonService {

	@Value("${pokemon-api.url}")
	private String URL;

	@Autowired
	private PokemonRepository pokemonRepository;

	public void loadData() {
		PokemonResponse response = new RestTemplate()
				.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<PokemonResponse>() {})
				.getBody();

		pokemonRepository.saveAll(response.getResults());
	}

	public List<Pokemon> getPokemons(String query, String sortOrder) {
		List<Pokemon> pokemons = pokemonRepository.findByNameStartingWith(query);
		
		PokemonsUtil.sort(pokemons, SortOrder.valueOf(sortOrder.toUpperCase()));
		
		return pokemons;
	}

}
