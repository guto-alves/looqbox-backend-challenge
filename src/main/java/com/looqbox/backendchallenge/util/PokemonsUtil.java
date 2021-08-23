package com.looqbox.backendchallenge.util;

import java.util.List;

import com.looqbox.backendchallenge.model.Pokemon;

public class PokemonsUtil {

	public static void sort(List<Pokemon> pokemons, SortOrder sortingType) {
		sort(pokemons, new BubbleSort(), sortingType);
	}

	public static void sort(List<Pokemon> pokemons, Sortable sortable, SortOrder sortingType) {
		sortable.sort(pokemons, sortingType);
	}

}
