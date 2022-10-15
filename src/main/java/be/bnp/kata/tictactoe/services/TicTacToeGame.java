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
		
		SlotType firstSlotType;
		
		// checking all three rows
		for (int index = 0; index < 7 ; index += 3) {
			firstSlotType = board.getSlotType(index);
			if (firstSlotType == SlotType.A)
				continue;
			if (firstSlotType == board.getSlotType(index + 1) && firstSlotType == board.getSlotType(index +2))
				return firstSlotType;
		}
		
		// checking all three columns
		for (int index = 0; index < 3 ; index ++) {
			firstSlotType = board.getSlotType(index);
			if (firstSlotType == SlotType.A)
				continue;
			if (firstSlotType == board.getSlotType(index + 3) && firstSlotType == board.getSlotType(index +6))
				return firstSlotType;
		}
		
		return null;
	}
	
}
