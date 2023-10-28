package game2048Console;

public class Game2048 {

	int[][] board;

	public Game2048() {
		this.board = new int[4][4];
	}

	public void initializeBoard() {
		randomTitle();
		randomTitle();
	}

	public void randomTitle() {
		int randRow = (int) (Math.random() * board.length);
		int randCol = (int) (Math.random() * board.length);
		if (board[randRow][randCol] == 0) {
			board[randRow][randCol] = Math.random() <= 0.6 ? 2 : 4;
		} else if (board[randRow][randCol] != 0) {
			randomTitle();
		}
	}

	public void moveLeft() {
		int oldBoard[][] = HelperMethods.copyBoard(board);
		for (int[] row : board) {
			HelperMethods.merge(row);
			HelperMethods.move(row);
		}
		if (!HelperMethods.compare2Board(oldBoard, board)) { 
			randomTitle();
		}
	}

	public void moveRight() {
		HelperMethods.reverseBoard(board);
		moveLeft();
		HelperMethods.reverseBoard(board);
	}

	public void moveUp() {
		HelperMethods.rotateBoard(board, 1);
		moveRight();
		HelperMethods.rotateBoard(board, 3);
	}

	public void moveDown() {
		HelperMethods.rotateBoard(board, 1);
		moveLeft();
		HelperMethods.rotateBoard(board, 3);
	}

	public boolean isGameOver() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				if (board[r][c] == 0)
					return false;
				if (r < board.length - 1 && board[r][c] == board[r + 1][c]) {
					return false;
				}
				if (c < board[0].length - 1 && board[r][c] == board[r][c + 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.printf("%4s|", board[i][j] == 0 ? "" : board[i][j]);
			}
			System.out.println();
		}
	}

	public static class HelperMethods {

		public static void merge(int[] array) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] != 0) {
					int pointer = i + 1;
					while (pointer < array.length && array[pointer] == 0) {
						++pointer;
					}
					if (pointer < array.length && array[pointer] == array[i]) {
						array[i] *= 2;
						array[pointer] = 0;
					}
				}
			}
		}

		public static void move(int[] array) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] == 0) {
					int pointer = i + 1;
					while (pointer < array.length && array[pointer] == 0) {
						++pointer;
					}
					if (pointer < array.length) {
						array[i] = array[pointer];
						array[pointer] = 0;
					}
				}
			}
		}

		public static void reverseBoard(int[][] board) {
			for (int[] rowArr : board) {
				int n = board.length - 1;
				for (int i = 0; i < board.length / 2; i++) {
					int temp = rowArr[i];
					rowArr[i] = rowArr[n - i];
					rowArr[n - i] = temp;
				}
			}
		}

		public static void rotateBoard(int[][] board, int n) {
			int[][] rotatedBoard = new int[board.length][board.length];
			for (int t = 0; t < n; t++) {
				// rotate 90 degrees clockwise
				for (int r = 0; r < board.length; r++) {
					for (int c = 0; c < board.length; c++) {
						rotatedBoard[r][c] = board[board.length - 1 - c][r];
					}
				}
				// set value of rotatedBoard to board
				for (int i = 0; i < rotatedBoard.length; i++) {
					for (int j = 0; j < rotatedBoard.length; j++) {
						board[i][j] = rotatedBoard[i][j];
					}
				}
			}
		}

		public static int[][] copyBoard(int[][] board) {
			int[][] copyBoard = new int[board.length][board[0].length];
			for (int i = 0; i < copyBoard.length; i++) {
				for (int j = 0; j < copyBoard.length; j++) {
					copyBoard[i][j] = board[i][j];
				}
			}
			return copyBoard;
		}

		public static boolean compare2Board(int[][] board1, int[][] board2) {
			for (int i = 0; i < board1.length; i++) {
				for (int j = 0; j < board1[0].length; j++) {
					if (board1[i][j] != board2[i][j]) {
						return false;
					}
				}
			}
			return true;
		}

	}

}
