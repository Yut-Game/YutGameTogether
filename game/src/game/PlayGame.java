package game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Piece;
import classes.Player;

public class PlayGame {
	static YutBoard board;
	private static JLabel p1P0;
	private static JLabel p1P1;
	private static JLabel p1P2;
	private JLabel p2P0;
	private JLabel p2P1;
	private JLabel p2P2;
	
	PlayGame(){
		
	}

	public static void main(String[] args) {
		board = new YutBoard();
		Player p1 = new Player();
		Player p2 = new Player();
		
		Piece[] p1P = new Piece[3];
		Piece[] p2P = new Piece[3];
		
		for(int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i);
			p1P[i] = new Piece(2, i);
		}
		p1P0 = new JLabel("ahkak");
		p1P1  = new JLabel();
		p1P2 = new JLabel();
		
		p1P0.setBackground(Color.pink);
		p1P0.setOpaque(true);
		p1P0.setBounds(80, 65, 30, 30);
		p1P1.setBounds(135, 65, 30, 30);
		p1P2.setBounds(190, 65, 30, 30);
		JPanel rightA = board.getRightArea();
		System.out.println(rightA);
		rightA.add(p1P0);
	}
}
