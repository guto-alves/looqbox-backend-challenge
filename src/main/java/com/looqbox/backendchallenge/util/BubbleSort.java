package com.looqbox.backendchallenge.util;

import java.util.List;

import com.looqbox.backendchallenge.model.Pokemon;

public class BubbleSort implements Sortable {

	@Override
	public void sort(List<Pokemon> pokemons, SortOrder sortOrder) {
		for (int i = 0; i < pokemons.size() - 1; i++) {
			for (int j = i + 1; j < pokemons.size(); j++) {
				Pokemon pokemon1 = pokemons.get(i);
				Pokemon pokemon2 = pokemons.get(j);
				
				if (sortOrder.compare(pokemon1, pokemon2) > 0) {
					pokemons.set(i, pokemon2);
					pokemons.set(j, pokemon1);
				}
			}
		}
	}

}
