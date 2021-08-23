package com.looqbox.backendchallenge.rest;

import java.util.ArrayList;
import java.util.List;

import com.looqbox.backendchallenge.model.Pokemon;

public class PokemonResponse {

	private List<Pokemon> results = new ArrayList<>();

	public PokemonResponse() {
	}
	
	public PokemonResponse(List<Pokemon> results) {
		this.results = results;
	}

	public List<Pokemon> getResults() {
		return results;
	}
	
	public long getCount() {
		return results.size();
	}

}
