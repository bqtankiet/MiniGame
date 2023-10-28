package game2048;

import static game2048.Game2048Constant.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game2048Panel extends JPanel {

	Game2048 game;

	public Game2048Panel(Game2048 game) {
		this.game = game;
		int panelSize = (GRID_SIZE * (game.board.length + 1)) + (SQUARE_SIZE * game.board.length);
		this.setPreferredSize(new Dimension(panelSize, panelSize));
		this.setBackground(new Color(171, 158, 145));
		this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(new Game2048Input(this));

		game.initializeBoard();
		game.printBoard();
	}

	public void moveRight() {
		game.moveRight();
		repaint();
		System.out.println("right");
		game.printBoard();
	}

	public void moveLeft() {
		game.moveLeft();
		repaint();
		System.out.println("left");
		game.printBoard();
	}

	public void moveUp() {
		game.moveUp();
		repaint();
		System.out.println("up");
		game.printBoard();
	}

	public void moveDown() {
		game.moveDown();
		repaint();
		System.out.println("down");
		game.printBoard();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int r = 0; r < game.board.length; r++) {
			int y = r * SQUARE_SIZE + GRID_SIZE * (r + 1);
			for (int c = 0; c < game.board.length; c++) {
				int x = c * SQUARE_SIZE + GRID_SIZE * (c + 1);
				// draw background
				g2d.setColor(COLOR_0);
				g2d.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
				// draw square
				int squareValue = game.board[r][c];
				if (squareValue != 0) {
					Square square = new Square(x, y, squareValue);
					square.draw(g2d);
				}
			}
		}
	}
}
