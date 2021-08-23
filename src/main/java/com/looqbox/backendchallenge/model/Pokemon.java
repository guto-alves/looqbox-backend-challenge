package com.looqbox.backendchallenge.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pokemons")
public class Pokemon {
	@Id
	private String name;
	
	@Transient
	private String highlight;

	public Pokemon() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pokemon)) {
			return false;
		}
		Pokemon other = (Pokemon) obj;
		return Objects.equals(name, other.name);
	}

}
