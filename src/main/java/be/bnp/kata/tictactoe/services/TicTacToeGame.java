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
		
		SlotType firstColumn;
		
		for (int index = 0; index < 7 ; index += 3) {
			firstColumn = board.getSlotType(index);
			if (firstColumn == SlotType.A)
				continue;
			if (firstColumn.equals(board.getSlotType(index + 1)) 
					&& firstColumn.equals(board.getSlotType(index +2))) {
				return firstColumn;
			}
		}

		SlotType row1col1 = board.getSlotType(0);
		if (row1col1 != SlotType.A && row1col1 == board.getSlotType(3) && row1col1 == board.getSlotType(6))
			return row1col1;

		SlotType row1col2 = board.getSlotType(1);
		if (row1col2 != SlotType.A && row1col2 == board.getSlotType(4) && row1col2 == board.getSlotType(7))
			return row1col2;
		
		return null;
	}
	
}
