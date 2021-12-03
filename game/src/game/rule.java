package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class rule extends JFrame {
	int isYut;

	public ImageIcon randomYut() {
		ImageIcon background;
		String imgUrl = "../img/";
		isYut = (int) (Math.random() * 6);
		switch (isYut) {
		case 1:
			imgUrl += "do.png";
			break;
		case 2:
			imgUrl += "gae.png";
			break;
		case 3:
			imgUrl += "girl.png";
			break;
		case 4:
			imgUrl += "yut.png";
			break;
		case 5:
			imgUrl += "mo.png";
			break;
		}
		background = new ImageIcon(rule.class.getResource(imgUrl));

		return background;
	}

	public int getIsYut() {
		switch (isYut) {
		case 0:
			return -1;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		case 5:
			return 5;
		}
		return 0;
	}
	
}