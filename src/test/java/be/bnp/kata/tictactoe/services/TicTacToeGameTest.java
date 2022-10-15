package be.bnp.kata.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.bnp.kata.tictactoe.model.SlotType;

class TicTacToeGameTest {
	
	private TicTacToeGame game;
	
	@BeforeEach
	void setUp() {
		game = new TicTacToeGame();
	}

	@Test
	void launchNewGameShouldCreateNewBoard() {
		game.launchNewGame();
		assertNotNull(game.getBoard());
	}

	@Test
	void nextPlayerShouldBeX_WhenLaunchingNewGame() {
		game.launchNewGame();
		assertEquals(SlotType.X, game.getCurrentPlayer());
	}

	@Test
	void updatingBoardShouldThrowException_IfSelectedSlotNumberSmallerThan0() {
		game.launchNewGame();
		assertThrows(Exception.class, () -> game.updateBoardWithSelectedSlot(-1));
	}
	
	@Test
	void updatingBoardShouldNotThrowException_IfSelectedSlotNumberBetween0And8() {
		game.launchNewGame();
		assertDoesNotThrow(() -> game.updateBoardWithSelectedSlot(2));
	}
	
	@Test
	void updatingBoardShouldChangeNextPlayerSlotType() {
		game.launchNewGame();
		SlotType currentPlayer = game.getCurrentPlayer();
		game.updateBoardWithSelectedSlot(2);
		assertNotEquals(currentPlayer, game.getCurrentPlayer());
	}
}
