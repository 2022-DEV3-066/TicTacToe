package be.bnp.kata.tictactoe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void creatingNewBoardShouldCreateAListOfSlot() {
		assertNotNull(new Board().getSlotList());
	}
	
	@Test
	void newSlotListShouldHaveExactlyNineSlots() {
		assertEquals(9, new Board().getSlotList().size());
	}

	@Test
	void settingSlotTypeToSlotNumberShouldUpdateSlotInBoardSlotList() {
		Board board = new Board();
		board.setSlotType(SlotType.O, 2);
		assertEquals(SlotType.O, board.getSlotList().get(2).getSlotType());
	}
}
