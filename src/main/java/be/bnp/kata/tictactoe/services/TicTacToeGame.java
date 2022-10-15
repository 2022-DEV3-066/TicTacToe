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

	public void updateBoardWithSelectedSlot(int slotNumber) {
		if (slotNumber < 0 || slotNumber > 8)
			throw new IllegalArgumentException(WRONG_SLOT_NUMBER);
		
		board.setSlotType(currentPlayer, slotNumber);
		
		if (currentPlayer == SlotType.X)
			currentPlayer = SlotType.O;
		else
			currentPlayer = SlotType.X;
	}

	public SlotType checkForAWinner() {
		
		SlotType row1col1 = board.getSlotList().get(0).getSlotType();
		if (row1col1 != SlotType.A && row1col1 == board.getSlotType(1)	&& row1col1 == board.getSlotType(2))
			return row1col1;
		
		SlotType row2col1 = board.getSlotType(3);
		if (row2col1 != SlotType.A && row2col1 == board.getSlotType(4) && row2col1 == board.getSlotType(5))
			return row2col1;
		
		SlotType row3col1 = board.getSlotType(6);
		if (row3col1 != SlotType.A && row3col1 == board.getSlotType(7) && row3col1 == board.getSlotType(8))
			return row3col1;
		
		return null;
	}
	
}
