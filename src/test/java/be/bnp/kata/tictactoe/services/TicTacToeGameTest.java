package be.bnp.kata.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.bnp.kata.tictactoe.model.Board;
import be.bnp.kata.tictactoe.model.SlotType;

class TicTacToeGameTest {
	
	final static public int VALID_SLOT_NUMBER = 2;

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
		assertDoesNotThrow(() -> game.updateBoardWithSelectedSlot(VALID_SLOT_NUMBER));
	}
	
	@Test
	void updatingBoardShouldChangeNextPlayerSlotType() {
		game.launchNewGame();
		SlotType currentPlayer = game.getCurrentPlayer();
		game.updateBoardWithSelectedSlot(VALID_SLOT_NUMBER);
		assertNotEquals(currentPlayer, game.getCurrentPlayer());
	}
	
	@Test
	void updatingBoardShouldUpdateSlotListForSelectedSlot() {
		game.launchNewGame();
		SlotType currentPlayer = game.getCurrentPlayer();
		game.updateBoardWithSelectedSlot(VALID_SLOT_NUMBER);
		assertEquals(currentPlayer, game.getBoard().getSlotList().get(VALID_SLOT_NUMBER).getSlotType());
	}

	@Test
	void threeXInFirstRowShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.X, 0);
		board.setSlotType(SlotType.X, 1);
		board.setSlotType(SlotType.X, 2);
		assertEquals(SlotType.X, game.checkForAWinner());
	}
	
	@Test
	void threeOInFirstRowShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.O, 0);
		board.setSlotType(SlotType.O, 1);
		board.setSlotType(SlotType.O, 2);
		assertEquals(SlotType.O, game.checkForAWinner());
	}
	
	@Test
	void threeOInSecondRowShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.O, 3);
		board.setSlotType(SlotType.O, 4);
		board.setSlotType(SlotType.O, 5);
		assertEquals(SlotType.O, game.checkForAWinner());
	}
	
	@Test
	void threeXInThirdRowShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.X, 6);
		board.setSlotType(SlotType.X, 7);
		board.setSlotType(SlotType.X, 8);
		assertEquals(SlotType.X, game.checkForAWinner());
	}
	
	@Test
	void threeOInFirstColumnShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.O, 0);
		board.setSlotType(SlotType.O, 3);
		board.setSlotType(SlotType.O, 6);
		assertEquals(SlotType.O, game.checkForAWinner());
	}
	
	@Test
	void threeXInSecondColumnShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.X, 1);
		board.setSlotType(SlotType.X, 4);
		board.setSlotType(SlotType.X, 7);
		assertEquals(SlotType.X, game.checkForAWinner());
	}
	
	@Test
	void threeOInThirdColumnShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.O, 2);
		board.setSlotType(SlotType.O, 5);
		board.setSlotType(SlotType.O, 8);
		assertEquals(SlotType.O, game.checkForAWinner());
	}
	
	@Test
	void threeXInFirstDiagonalShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.X, 0);
		board.setSlotType(SlotType.X, 4);
		board.setSlotType(SlotType.X, 8);
		assertEquals(SlotType.X, game.checkForAWinner());
	}
	
	@Test
	void threeOInSecondDiagonalShouldWinTheGame() {
		game.launchNewGame();
		Board board = game.getBoard();
		board.setSlotType(SlotType.O, 2);
		board.setSlotType(SlotType.O, 4);
		board.setSlotType(SlotType.O, 6);
		assertEquals(SlotType.O, game.checkForAWinner());
	}
}
