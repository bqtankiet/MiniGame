package game2048;

import java.awt.Color;

public class Game2048Constant {

	// Colors
	public static final Color COLOR_0 = new Color(205, 193, 180, 255);
	public static final Color COLOR_2 = new Color(238, 228, 218);
	public static final Color COLOR_4 = new Color(237, 224, 200);
	public static final Color COLOR_8 = new Color(242, 177, 121);
	public static final Color COLOR_16 = new Color(245, 149, 99);
	public static final Color COLOR_32 = new Color(246, 124, 95);
	public static final Color COLOR_64 = new Color(246, 94, 59);
	public static final Color COLOR_128 = new Color(237, 207, 114);
	public static final Color COLOR_256 = new Color(237, 204, 97);
	public static final Color COLOR_512 = new Color(237, 200, 80);
	public static final Color COLOR_1024 = new Color(237, 197, 63);
	public static final Color COLOR_2048 = new Color(237, 194, 46);
	public static final Color COLOR_GRID = new Color(171, 158, 145);
	
	// Directions
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	
	// Sizes
	public static final int ROWS = 4;
	public static final int COLS = 4;
	public static final int SQUARE_SIZE = 100;
	public static final int GRID_SIZE = 10;
	public static final int BOARD_WIDTH = (GRID_SIZE * (ROWS + 1) + (SQUARE_SIZE * ROWS));
	

}
