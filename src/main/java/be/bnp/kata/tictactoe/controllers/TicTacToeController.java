package be.bnp.kata.tictactoe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicTacToeController {

	@GetMapping("/tictactoe")
	public String initGame() {
		return "index";
	}
}
