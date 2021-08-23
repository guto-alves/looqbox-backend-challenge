package com.looqbox.backendchallenge.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonRestControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetPokemonsSuccess() throws Exception {
		mockMvc.perform(get("/pokemons?q={query}", "bu"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("count", is(9)))
			.andExpect(jsonPath("results", hasSize(9)))
			.andExpect(jsonPath("results[0].name", is("budew")))
			.andExpect(jsonPath("results[0].highlight", is("<pre>bu</pre>dew")));
		
		mockMvc.perform(get("/pokemons?q={query}&order={order}", "pi", "length"))
			.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("count", is(29)))
			.andExpect(jsonPath("results", hasSize(29)))
			.andExpect(jsonPath("results[9].name", is("pikachu")))
			.andExpect(jsonPath("results[9].highlight", is("<pre>pi</pre>kachu")));
		
		mockMvc.perform(get("/pokemons?q={query}&order={order}", "pi", "alphabetical"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("count", is(29)))
			.andExpect(jsonPath("results", hasSize(29)))
			.andExpect(jsonPath("results[7].name", is("pikachu")))
			.andExpect(jsonPath("results[7].highlight", is("<pre>pi</pre>kachu")));
	}
	
	@Test
	public void testGetPokemonsNoResult() throws Exception {
		mockMvc.perform(get("/pokemons?q={query}", "asfdasdfasfda"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("count").value(0))
			.andExpect(jsonPath("results", hasSize(0)));
	}
	
	@Test
	public void testGetPokemonsError() throws Exception {
		mockMvc.perform(get("/pokemons"))
			.andExpect(status().isBadRequest());
		
		mockMvc.perform(get("/pokemons?q={query}&order={order}", "bu", "InvalidOrder"))
			.andDo(print())
			.andExpect(status().isBadRequest());
	}
	
}
