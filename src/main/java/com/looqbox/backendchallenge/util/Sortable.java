package com.looqbox.backendchallenge.util;

import java.util.List;

import com.looqbox.backendchallenge.model.Pokemon;

public interface Sortable {

	void sort(List<Pokemon> pokemons, SortOrder type);

}
