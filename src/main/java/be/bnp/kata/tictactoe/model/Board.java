package be.bnp.kata.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Slot> slotList;
	
	public Board() {
		slotList = new ArrayList<>();
		for (int count = 1 ; count <= 9 ; count++)
			slotList.add(new Slot());
	}

	public List<Slot> getSlotList() {
		return slotList;
	}

	public void setSlotType(SlotType slotType, int slotNumber) {
		Slot selectedSlot = slotList.get(slotNumber);
		if (selectedSlot.getSlotType() != SlotType.A)
			throw new IllegalArgumentException();
		selectedSlot.setSlotType(slotType);
	}

}
