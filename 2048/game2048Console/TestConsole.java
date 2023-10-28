package game2048Console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class TestConsole {

	public static void main(String[] args) {
		Game2048 game2048 = new Game2048();

		game2048.initializeBoard();
		System.out.println("init board");
		game2048.printBoard();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(game2048.isGameOver()) return;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP -> {
					game2048.moveUp();
					System.out.println("move up");
				}
				case KeyEvent.VK_DOWN -> {
					game2048.moveDown();
					System.out.println("move down");
				}
				case KeyEvent.VK_LEFT -> {
					game2048.moveLeft();
					System.out.println("move left");
				}
				case KeyEvent.VK_RIGHT -> {
					game2048.moveRight();
					System.out.println("move right");
				}
				}
				game2048.printBoard();

				if (game2048.isGameOver()) {
					System.out.println("Game is over");
				}
			}
		});
	}

}
