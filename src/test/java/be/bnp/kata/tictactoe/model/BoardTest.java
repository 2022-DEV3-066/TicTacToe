package be.bnp.kata.tictactoe.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void creatingNewBoardShouldCreateAListOfSlot() {
		assertNotNull(new Board().getSlotList());
	}
}
