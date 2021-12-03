package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MovePiece {
	static JPanel rightA;
	static JPanel yutBoard;
	static int nowTurn;
	private static JButton p1P0;
	private static JButton p1P1;
	private static JButton p1P2;
	private static JButton p2P0;
	private static JButton p2P1;
	private static JButton p2P2;
	
	static int piece = -1;
	static int hmMove = 0;
	static PlayGame obj = new PlayGame();
	
	public MovePiece(JPanel rightA, JPanel board, int turn){
		this.rightA = rightA;
		this.yutBoard = board;
		this.nowTurn = turn;
	}
	
	public MovePiece(int hm){
		hmMove = hm;
	}
	
	public MovePiece() {		
	}
	
	public static void createBtn() {
		p1P0 = new JButton();
		p1P1  = new JButton();
		p1P2 = new JButton();
		p2P0 = new JButton();
		p2P1  = new JButton();
		p2P2 = new JButton();
		
		p1P0.setBackground(Color.RED);
		p1P1.setBackground(Color.ORANGE);
		p1P2.setBackground(Color.yellow);
		p2P0.setBackground(Color.green);
		p2P1.setBackground(Color.blue);
		p2P2.setBackground(Color.black);
		
		p1P0.setBounds(80, 65, 30, 30);
		p1P1.setBounds(135, 65, 30, 30);
		p1P2.setBounds(190, 65, 30, 30);
		p2P0.setBounds(80, 155, 30, 30);
		p2P1.setBounds(135, 155, 30, 30);
		p2P2.setBounds(190, 155, 30, 30);
		
		rightA.add(p1P0);
		rightA.add(p1P1);
		rightA.add(p1P2);
		rightA.add(p2P0);
		rightA.add(p2P1);
		rightA.add(p2P2);
	}
	public static void clickBtn() {
        p1P0.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 0;
				movePiece(p1P0);
			}
		});
        p1P1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 1;
				movePiece(p1P1);
			}
		});
        p1P2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 2;
				movePiece(p1P2);
			}
		});
        p2P0.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 0;
				movePiece(p2P0);
			}
		});
        p2P1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 1;
				movePiece(p2P1);
			}
		});
        p2P2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 2;
				movePiece(p2P2);
			}
		});
	}
	public static void movePiece(JButton btn) {
		int[] xy = obj.pieceState(piece, hmMove);
		System.out.println(xy[0] + "  " + xy[1]);
		btn.setBounds(xy[0], xy[1], 30, 30);
		yutBoard.add(btn);
		hmMove = 0;
	}
	public static void disableBtn(int nowTurn) {
		if(nowTurn == 1)
		{
			p2P0.setEnabled(false);
			p2P1.setEnabled(false);
			p2P2.setEnabled(false);
			p1P0.setEnabled(true);
			p1P1.setEnabled(true);
			p1P2.setEnabled(true);
		}
		else {
			p1P0.setEnabled(false);
			p1P1.setEnabled(false);
			p1P2.setEnabled(false);
			p2P0.setEnabled(true);
			p2P1.setEnabled(true);
			p2P2.setEnabled(true);
		}
	}
}
