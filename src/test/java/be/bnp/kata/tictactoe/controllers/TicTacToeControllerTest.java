package be.bnp.kata.tictactoe.controllers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import be.bnp.kata.tictactoe.model.Board;
import be.bnp.kata.tictactoe.model.SlotType;
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
	void callingRootURLShouldCallInitGame() throws Exception {
		mockMvc.perform(get("/"));
		verify(game, times(1)).launchNewGame();
	}

	@Test
	void initGameShouldLaunchNewGame() throws Exception {
		mockMvc.perform(get("/tictactoe"));
		verify(game, times(1)).launchNewGame();
	}
	
	@Test
	void whenInitGameCalledModelShouldHaveBoardAttribute() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/tictactoe"))
		.andExpect(model().attributeExists("board"));
	}
	
	@Test
	void whenInitGameCalledModelShouldHaveCurrentPlayerEqualsToX() throws Exception {
		when(game.getCurrentPlayer()).thenReturn(SlotType.X);
		mockMvc.perform(get("/tictactoe"))
		.andExpect(model().attribute("currentPlayer", SlotType.X));
	}
	
	@Test
	void selectingSlot9ShouldThrowException() {
		assertThrows(Exception.class, () -> mockMvc.perform(get("/tictactoe/slot/9")));
	}
}
