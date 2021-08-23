package com.looqbox.backendchallenge.util;

import com.looqbox.backendchallenge.model.Pokemon;

public enum SortOrder {
	ALPHABETICAL((pokemon1, pokemon2) -> {
		return pokemon1.getName().compareTo(pokemon2.getName());
	}), 
	LENGTH((pokemon1, pokemon2) -> {
		if (pokemon1.getName().length() == pokemon2.getName().length()) {
			return 0;
		}
		return pokemon1.getName().length() > pokemon2.getName().length() ? 1 : -1;
	});

	private final Comparable comparable;

	private SortOrder(Comparable comparable) {
		this.comparable = comparable;
	}

	public int compare(Pokemon pokemon1, Pokemon pokemon2) {
		return comparable.compare(pokemon1, pokemon2);
	}
}
