package be.bnp.kata.tictactoe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

	final static public int VALID_SLOT_NUMBER = 4;
	
	Board board;
	
	@BeforeEach
	void setUp() {
		board = new Board();
	}
	
	@Test
	void creatingNewBoardShouldCreateAListOfSlot() {
		assertNotNull(board.getSlotList());
	}
	
	@Test
	void newSlotListShouldHaveExactlyNineSlots() {
		assertEquals(9, board.getSlotList().size());
	}

	@Test
	void settingSlotTypeToSlotNumberShouldUpdateSlotInBoardSlotList() {
		board.setSlotType(SlotType.O, VALID_SLOT_NUMBER);
		assertEquals(SlotType.O, board.getSlotList().get(VALID_SLOT_NUMBER).getSlotType());
	}
	
	@Test
	void selectedSlotWithANonAvailableSlotTypeShouldThrowException() {
		Slot selectedSlot = board.getSlotList().get(VALID_SLOT_NUMBER);
		selectedSlot.setSlotType(SlotType.O);
		assertThrows(IllegalArgumentException.class, () -> board.setSlotType(SlotType.X, VALID_SLOT_NUMBER));
	}
}
