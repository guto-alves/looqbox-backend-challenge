package com.looqbox.backendchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.looqbox.backendchallenge.repository.PokemonRepository;
import com.looqbox.backendchallenge.rest.PokemonResponse;

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

}
