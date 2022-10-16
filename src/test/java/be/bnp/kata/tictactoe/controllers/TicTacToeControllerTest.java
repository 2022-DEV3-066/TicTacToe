package be.bnp.kata.tictactoe.controllers;

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
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/tictactoe"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	void callingRootURLShouldCallInitGame() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/"));
		verify(game, times(1)).launchNewGame();
	}

	@Test
	void initGameShouldLaunchNewGame() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
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
		when(game.getBoard()).thenReturn(new Board());
		when(game.getCurrentPlayer()).thenReturn(SlotType.X);
		mockMvc.perform(get("/tictactoe"))
		.andExpect(model().attribute("currentPlayer", SlotType.X));
	}
	
	@Test
	void selectingSlot2ShouldDisplayIndexPage() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/tictactoe/slot/2"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	void selectingSlot4ShouldCallupdateBoardWithSelectedSlot() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/tictactoe/slot/4"));
		verify(game, times(1)).updateBoardWithSelectedSlot(4);
	}
	
	@Test
	void selectingSlot6ShouldAddBoardToModel() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/tictactoe/slot/6"))
		.andExpect(model().attributeExists("board"));
	}
	
	@Test
	void selectingSlot5ShouldAddCurrentPlayerToModel() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		when(game.getCurrentPlayer()).thenReturn(SlotType.X);
		mockMvc.perform(get("/tictactoe/slot/5"))
		.andExpect(model().attributeExists("currentPlayer"));
	}
	
	@Test
	void selectingSlot3ShouldAddWinnerAttributeToModel() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		when(game.checkForAWinner()).thenReturn(SlotType.X);
		mockMvc.perform(get("/tictactoe/slot/3"))
		.andExpect(model().attributeExists("winner"));
	}
	
	@Test
	void selectingSlot2ShouldAddSlotsAvailableAttributeToModel() throws Exception {
		when(game.getBoard()).thenReturn(new Board());
		mockMvc.perform(get("/tictactoe/slot/2"))
		.andExpect(model().attributeExists("slotsAvailable"));
	}
}
