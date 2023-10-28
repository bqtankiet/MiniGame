package game2048;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Game2048 game2048 = new Game2048();
		Game2048Panel panel = new Game2048Panel(game2048);
		JFrame frame = new JFrame();
		frame.setTitle("2048");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
