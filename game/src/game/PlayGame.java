package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Piece;
import classes.Player;

public class PlayGame {
	static YutBoard board;
	static JPanel rightA;

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		piece p = new piece(rightA);
		
		// 플레이어 객체
		Player p1 = new Player();
		Player p2 = new Player();
		
		// 플레이어 말
		Piece[] p1P = new Piece[3];
		Piece[] p2P = new Piece[3];
		
		for(int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i, -1);
			p1P[i] = new Piece(2, i, -1);
		}
		
		p.createBtn();
		p.clickBtn();
	}
}
