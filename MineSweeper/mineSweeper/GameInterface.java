package mineSweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInterface extends JPanel {

	Minesweeper game;
	Square[][] squares;

	public GameInterface(Minesweeper game) {
		this.game = game;
		this.squares = new Square[game.rowSize][game.colSize];
		this.setup();
	}

	private void setup() {
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray, 10));
		this.setBackground(Color.gray);
		this.setLayout(new GridLayout(game.rowSize, game.colSize, 2, 2));
		this.setupBoard();
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("Minesweeper");
		gameFrame.add(this);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		gameFrame.pack();
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
	}

	public void setupBoard() {
		for (int r = 0; r < game.rowSize; r++) {
			for (int c = 0; c < game.colSize; c++) {
				Square square = new Square(game.board[r][c], r, c);
				squares[r][c] = square;
				this.add(square, r, c);
			}
		}
	}

	class Square extends JLabel {
		static final int size = 35;
		int value;
		int rowIndex;
		int colIndex;
		boolean opened, marked;

		public Square(int value, int rowIndex, int colIndex) {
			this.value = value;
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
			this.setIcon(ImageManager.squareImage);
			this.setBackground(Color.lightGray);
			this.setHorizontalAlignment(CENTER);
			this.setOpaque(true);
			this.addEvent();
		}

		public void addEvent() {
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (game.gameOver) {
						return;
					} else if (e.getButton() == MouseEvent.BUTTON1) {
						open();
					} else if (e.getButton() == MouseEvent.BUTTON3 && !opened) {
						marked = !marked;
						setIcon(marked ? ImageManager.flagImage : ImageManager.squareImage);
					}
				}

			});
		}

		public void open() {
			if (opened || marked) {
				return;
			} else if (value == 0) {
				for (int r = rowIndex - 1; r <= rowIndex + 1; r++) {
					for (int c = colIndex - 1; c <= colIndex + 1; c++) {
						if (r >= 0 && r < game.rowSize && c >= 0 && c < game.colSize) {
							show();
							squares[r][c].open();
						}
					}
				}
			} else if (value == -1) {
				for (int i = 0; i < game.rowSize; i++) {
					for (int j = 0; j < game.colSize; j++) {
						Square square = squares[i][j];
						if (square.value == -1 && !square.marked) {
							square.show();
							setBackground(Color.red);
							game.gameOver = true;
						}
					}
				}
			} else {
				show();
			}
		}

		public void show() {
			setIcon(null);
			if (value == -1) {
				setIcon(ImageManager.bombImage);
				game.gameOver = true;
			} else if (value > 0) {
				setText(""+value);
				setFont(new Font("Arial Black",Font.BOLD,size -5));
				setForeground(switch(value) {
				case 1 -> Color.blue;
				case 2 -> new Color(8, 110, 13);
				case 3 -> Color.red;
				case 4 -> new Color(0, 40, 173);
				case 5 -> new Color(122, 0, 0);
				default -> Color.black;
				});
			}
			opened = true;
		}
	}
}
