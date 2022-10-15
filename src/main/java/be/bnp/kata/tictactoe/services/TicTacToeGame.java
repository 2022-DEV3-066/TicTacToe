package be.bnp.kata.tictactoe.services;

import org.springframework.stereotype.Service;

import be.bnp.kata.tictactoe.model.Board;
import be.bnp.kata.tictactoe.model.SlotType;

@Service
public class TicTacToeGame {

	public final static String WRONG_SLOT_NUMBER = "Selected slot number should be between 0 and 8";

	private Board board;
	private SlotType currentPlayer;
	
	public void launchNewGame() {
		board = new Board();
		currentPlayer = SlotType.X;
	}

	public Board getBoard() {
		return board;
	}

	public SlotType getCurrentPlayer() {
		return currentPlayer;
	}

	public void updateBoardWithSelectedSlot(int i) {
		if (i < 0 || i > 8)
			throw new IllegalArgumentException(WRONG_SLOT_NUMBER);
	}
	
}
