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
	boolean bigOne = false;

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
	
	public int checkBigOne(int location) {
		if(location == 5) {
			bigOne = true;
			return 24;
		}
		else if(location == 10)  return 19;
		else if(location == 27) location = 22;
		return location;
	}
	public int checkRutin(int location, int move) {
		int total = location + move;
		if(total > 29) return location - 15;
		return location;
	}
	public int checkBigOneBack(int loc) {
		if(loc == 24) return 5;
		if(loc == 19) return 10;
		return loc;
	}
	public int checkFinish(int loc, int move) {
		if(bigOne) {
			bigOne = false;
			return 0;
		}
		int total = loc + move;
		if(15 <= loc && loc <= 19) {
			if(20 <= total && total <= 24) return 1;
			else return 00;
		}
		else if(19 <= loc && loc <= 24) {
			if(25 <= total && total <= 29) return 1;
			else return 0;
		}
		return 0;
	}
}