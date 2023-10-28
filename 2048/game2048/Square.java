package game2048;

import static game2048.Game2048Constant.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Square {
	int x, y;
	int value;
	Color backgroundColor;
	Color foregroundColor;

	public Square(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		this.backgroundColor = switch (value) {
		case 2 -> COLOR_2;
		case 4 -> COLOR_4;
		case 8 -> COLOR_8;
		case 16 -> COLOR_16;
		case 32 -> COLOR_32;
		case 64 -> COLOR_64;
		case 128 -> COLOR_128;
		case 256 -> COLOR_256;
		case 512 -> COLOR_512;
		case 1024 -> COLOR_1024;
		case 2048 -> COLOR_2048;
		default -> Color.DARK_GRAY;
		};
		this.foregroundColor = value <= 4 ? Color.DARK_GRAY : Color.WHITE;
	}

	public void draw(Graphics2D g2d) {
		// background
		g2d.setColor(backgroundColor);
		g2d.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
		// foreground
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(value > 4 ? Color.white : Color.darkGray);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD,80-(value+"").length()*10);
		g2d.setFont(font);
		FontMetrics fm = g2d.getFontMetrics(font);
		int textWidth = fm.stringWidth(value + "");
		int texHeight = fm.getHeight();
		int textX = x + (SQUARE_SIZE - textWidth) / 2;
		int textY = y + (SQUARE_SIZE + texHeight / 2) / 2;
		g2d.drawString(value + "", textX, textY);
	}

}
