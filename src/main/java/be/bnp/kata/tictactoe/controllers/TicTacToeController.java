package be.bnp.kata.tictactoe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import be.bnp.kata.tictactoe.services.TicTacToeGame;

@Controller
public class TicTacToeController {
	
	private final TicTacToeGame game;
	
	public TicTacToeController(TicTacToeGame game) {
		this.game = game;
	}

	@GetMapping("/tictactoe")
	public String initGame() {
		game.launchNewGame();
		return "index";
	}
}
