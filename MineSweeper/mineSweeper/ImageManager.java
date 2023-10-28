package mineSweeper;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import mineSweeper.GameInterface.Square;

public class ImageManager {
	static ImageIcon squareImage;
	static ImageIcon bombImage;
	static ImageIcon flagImage;

	static {
		initializeImages();
	}

	public static ImageIcon loadImage(String path, int sizeScale) {
		Image img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon(img.getScaledInstance(sizeScale, sizeScale, Image.SCALE_SMOOTH));
	}

	public static void initializeImages() {
		String imageFolder = "mineSweeper\\mineSweeper\\image\\";

		squareImage = loadImage(imageFolder + "square.png", Square.size);
		flagImage = loadImage(imageFolder + "flag.png", Square.size);
		bombImage = loadImage(imageFolder + "bomb.png", Square.size);
	}
}
