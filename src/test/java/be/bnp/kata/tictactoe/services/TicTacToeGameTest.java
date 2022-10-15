package be.bnp.kata.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TicTacToeGameTest {

	@Test
	void launchNewGameShouldCreateNewBoard() {
		TicTacToeGame game = new TicTacToeGame();
		game.launchNewGame();
		assertNotNull(game.getBoard());
	}

}
