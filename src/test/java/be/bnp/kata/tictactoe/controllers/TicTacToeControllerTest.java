package be.bnp.kata.tictactoe.controllers;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
	
	@Mock
	Board board = new Board();
	
	@Autowired
	MockMvc mockMvc;
		
	@Test
	void initGameShouldDisplayIndexPage() throws Exception {
		when(game.getBoard()).thenReturn(board);
		mockMvc.perform(get("/tictactoe"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	void callingRootURLShouldCallInitGame() throws Exception {
		when(game.getBoard()).thenReturn(board);
		mockMvc.perform(get("/"));
		verify(game, times(1)).launchNewGame();
	}

	@Test
	void initGameShouldLaunchNewGame() throws Exception {
		when(game.getBoard()).thenReturn(board);
		mockMvc.perform(get("/tictactoe"));
		verify(game, times(1)).launchNewGame();
	}
	
	@Test
	void whenInitGameCalledModelShouldHaveBoardAttribute() throws Exception {
		when(game.getBoard()).thenReturn(board);
		mockMvc.perform(get("/tictactoe"))
		.andExpect(model().attributeExists("board"));
	}
	
	@Test
	void whenInitGameCalledModelShouldHaveCurrentPlayerEqualsToX() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(game.getCurrentPlayer()).thenReturn(SlotType.X);
		mockMvc.perform(get("/tictactoe"))
		.andExpect(model().attribute("currentPlayer", SlotType.X));
	}
	
	@Test
	void initGameShouldAddSlotsAvailableAttributeToModel() throws Exception {
		when(game.getBoard()).thenReturn(board);
		mockMvc.perform(get("/tictactoe"))
		.andExpect(model().attributeExists("slotsAvailable"));
	}
	
	@Test
	void selectingSlot2ShouldDisplayIndexPage() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(board.availableSlotsRemain()).thenReturn(true);
		mockMvc.perform(get("/tictactoe/slot/2"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	void selectingSlot4ShouldCallupdateBoardWithSelectedSlot() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(board.availableSlotsRemain()).thenReturn(true);
		mockMvc.perform(get("/tictactoe/slot/4"));
		verify(game, times(1)).updateBoardWithSelectedSlot(4);
	}
	
	@Test
	void selectingSlot6ShouldAddBoardToModel() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(board.availableSlotsRemain()).thenReturn(true);
		mockMvc.perform(get("/tictactoe/slot/6"))
		.andExpect(model().attributeExists("board"));
	}
	
	@Test
	void selectingSlot5ShouldAddCurrentPlayerToModel() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(game.getCurrentPlayer()).thenReturn(SlotType.X);
		when(board.availableSlotsRemain()).thenReturn(true);
		mockMvc.perform(get("/tictactoe/slot/5"))
		.andExpect(model().attributeExists("currentPlayer"));
	}
	
	@Test
	void selectingSlot2ShouldAddSlotsAvailableAttributeToModel() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(board.availableSlotsRemain()).thenReturn(true);
		mockMvc.perform(get("/tictactoe/slot/2"))
		.andExpect(model().attributeExists("slotsAvailable"));
	}
	
	@Test
	void ifBoardIsNullWhenSelectingSlot7_ThenShouldRedirectToInitGame() throws Exception {
		when(game.getBoard()).thenReturn(null);
		mockMvc.perform(get("/tictactoe/slot/7"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/tictactoe"));
	}
	
	@Test
	void selectingSlotIfWinnerNotNullOrNoSlotsAvailableShouldRedirectToInitGame() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(game.checkForAWinner()).thenReturn(SlotType.X);
		when(board.availableSlotsRemain()).thenReturn(false);
		mockMvc.perform(get("/tictactoe/slot/2"))
		.andExpect(view().name("redirect:/tictactoe"));
	}
	
	@Test
	void ifSelectingSlotThrowNewIllegalArgumentException_ThenReturnToIndexPage() throws Exception {
		when(game.getBoard()).thenReturn(board);
		when(board.availableSlotsRemain()).thenReturn(true);
		doThrow(new IllegalArgumentException()).when(game).updateBoardWithSelectedSlot(9);;
		mockMvc.perform(get("/tictactoe/slot/9"))
		.andExpect(view().name("index"));
	}
}
