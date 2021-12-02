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
	public void homeframe() {
		setTitle("1");// 창의 타이틀
		setTitle("1");
		setSize(600, 300);// 프레임의 크기
		setResizable(false);// 창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);// 창이 가운데 나오게
		setLayout(null);
		setVisible(true);// 창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame이 정상적으로 종료되게
	}	
	public ImageIcon randomYut() {
		ImageIcon background;
		String imgUrl = "../img/";
		int isYut = (int) (Math.random() * 6);
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

	public static void main(String[] args) {
		new rule();
		// 빽도 -1
		// 도 - 0
		// 개 - 1
		// 걸 - 2
		// 윳 - 3
		// 모 - 4
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("호출됨");
		
		
	}
	
}