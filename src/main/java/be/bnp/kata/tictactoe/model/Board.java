package be.bnp.kata.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	List<Slot> slotList;

	public List<Slot> getSlotList() {
		slotList = new ArrayList<>();
		for (int count = 1 ; count <= 9 ; count++)
			slotList.add(new Slot());
		return slotList;
	}

}
