package be.bnp.kata.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	public final static String SELECTED_SLOT_NOT_AVAILABLE = "Selected slot must be available";
	
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
			throw new IllegalArgumentException(SELECTED_SLOT_NOT_AVAILABLE);
		selectedSlot.setSlotType(slotType);
	}

	public SlotType getSlotType(int slotNumber) {
		return slotList.get(slotNumber).getSlotType();
	}

	public boolean availableSlotsRemain() {
		
		for (Slot currentSlot : slotList) {
			if (currentSlot.getSlotType() == SlotType.A) {
				return true;
			}
		}
		return false;
	}
}
