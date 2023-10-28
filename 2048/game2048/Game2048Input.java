package game2048;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game2048Input extends KeyAdapter {
	Game2048Panel gamePanel;

	public Game2048Input(Game2048Panel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_RIGHT -> {
			gamePanel.moveRight();
		}
		case KeyEvent.VK_LEFT -> {
			gamePanel.moveLeft();
		}
		case KeyEvent.VK_UP -> {
			gamePanel.moveUp();
		}
		case KeyEvent.VK_DOWN -> {
			gamePanel.moveDown();
		}
		case KeyEvent.VK_SPACE -> {
			gamePanel.restartGame();
		}
		}
	}
}
