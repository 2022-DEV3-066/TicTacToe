package be.bnp.kata.tictactoe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SlotTest {

	@Test
	void newSlotShouldHaveAvailableSlotType() {
		Slot slot = new Slot();
		assertEquals(SlotType.A, slot.getSlotType());
	}
}
