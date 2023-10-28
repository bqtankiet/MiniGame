package tictactoe;

import static tictactoe.TicTacToePanel.ROW;
import static tictactoe.TicTacToePanel.SQUARE_SIZE;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		JFrame gameFrame = new JFrame("Tic Tac Toe");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.add(game.ticTacToePanel);
		gameFrame.setMinimumSize(new Dimension(SQUARE_SIZE*(ROW*2),SQUARE_SIZE*(ROW*2)));
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
	}
}
