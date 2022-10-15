package be.bnp.kata.tictactoe.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import be.bnp.kata.tictactoe.services.TicTacToeGame;

@WebMvcTest(TicTacToeController.class)
class TicTacToeControllerTest {

	@MockBean
	TicTacToeGame game;
	
	@Autowired
	MockMvc mockMvc;
		
	@Test
	void initGameShouldDisplayIndexPage() throws Exception {
		mockMvc.perform(get("/tictactoe"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}

	@Test
	void initGameShouldLaunchNewGame() throws Exception {
		mockMvc.perform(get("/tictactoe"));
		verify(game, times(1)).launchNewGame();
	}
}
