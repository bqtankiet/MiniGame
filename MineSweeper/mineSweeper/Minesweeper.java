package mineSweeper;

public class Minesweeper {

	int rowSize;
	int colSize;
	int bombs;
	int[][] board;
	boolean gameOver;
	GameInterface gameInterface;

	public Minesweeper(int rowSize, int colSize, int bombs) {
		super();
		this.rowSize = rowSize;
		this.colSize = colSize;
		this.bombs = bombs;
		this.board = new int[rowSize][colSize];
		this.randomBomb();
		this.fillNumber();
		this.gameInterface = new GameInterface(this);
	}

	public void randomBomb() {
		int count = 0;
		while (count < bombs) {
			int r = (int) (Math.random() * rowSize);
			int c = (int) (Math.random() * colSize);
			if (board[r][c] != -1) {
				board[r][c] = -1;
				++count;
			}
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				result += String.format("%2s", board[i][j]);
			}
			result += "\n";
		}
		return result;
	}

	public void fillNumber() {
		for (int r = 0; r < rowSize; r++) {
			for (int c = 0; c < colSize; c++) {
				if (board[r][c] != -1) {
					board[r][c] = countBombAround(r, c);
				}
			}
		}

	}

	private int countBombAround(int row, int col) {
		int count = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r >= 0 && r < rowSize && c >= 0 && c < colSize && board[r][c] == -1) {
					++count;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Minesweeper ms = new Minesweeper(9, 9, 10);
		ms.randomBomb();
		ms.fillNumber();
		System.out.println(ms.toString());
	}

}
