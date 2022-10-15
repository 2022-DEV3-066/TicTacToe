package be.bnp.kata.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import be.bnp.kata.tictactoe.model.SlotType;

class TicTacToeGameTest {

	@Test
	void launchNewGameShouldCreateNewBoard() {
		TicTacToeGame game = new TicTacToeGame();
		game.launchNewGame();
		assertNotNull(game.getBoard());
	}

	@Test
	void nextPlayerShouldBeX_WhenLaunchingNewGame() {
		TicTacToeGame game = new TicTacToeGame();
		game.launchNewGame();
		assertEquals(SlotType.X, game.getCurrentPlayer());
	}
}
