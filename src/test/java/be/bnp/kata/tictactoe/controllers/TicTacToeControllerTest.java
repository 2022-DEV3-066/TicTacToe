package be.bnp.kata.tictactoe.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TicTacToeController.class)
class TicTacToeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void initGameShouldDisplayIndexPage() throws Exception {
		mockMvc.perform(get("/tictactoe"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}

}
