package be.bnp.kata.tictactoe.services;

import org.springframework.stereotype.Service;

import be.bnp.kata.tictactoe.model.Board;

@Service
public class TicTacToeGame {
	
	private Board board;
	
	public void launchNewGame() {
		board = new Board();
	}

	public Board getBoard() {
		return board;
	}

	public Object getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
