package be.bnp.kata.tictactoe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.bnp.kata.tictactoe.services.TicTacToeGame;

@Controller
public class TicTacToeController {
	
	private final TicTacToeGame game;
	
	public TicTacToeController(TicTacToeGame game) {
		this.game = game;
	}

	@GetMapping({"/tictactoe", "/"})
	public String initGame(Model model) {
		game.launchNewGame();
		model.addAttribute("board", game.getBoard());
		model.addAttribute("currentPlayer", game.getCurrentPlayer());
		model.addAttribute("slotsAvailable", game.getBoard().availableSlotsRemain());
		return "index";
	}
	
	@GetMapping("/tictactoe/slot/{slotNumber}")
	public String selectSlot(@PathVariable String slotNumber, Model model) {
		game.updateBoardWithSelectedSlot(Integer.valueOf(slotNumber));
		model.addAttribute("board", game.getBoard());
		model.addAttribute("currentPlayer", game.getCurrentPlayer());
		model.addAttribute("winner", game.checkForAWinner());
		model.addAttribute("slotsAvailable", game.getBoard().availableSlotsRemain());
		return "index";
	}
}
