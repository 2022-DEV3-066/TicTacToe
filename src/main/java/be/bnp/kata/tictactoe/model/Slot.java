package be.bnp.kata.tictactoe.model;

public class Slot {
	
	private SlotType slotType;
	
	public Slot() {
		slotType = SlotType.A;
	}

	public SlotType getSlotType() {
		return slotType;
	}

	public void setSlotType(SlotType o) {
		slotType = o;
	}

}
