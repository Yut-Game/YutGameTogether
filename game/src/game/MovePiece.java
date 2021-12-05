package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import classes.Point;

public class MovePiece {
	static JPanel rightA;
	static JPanel yutBoard;
	static JFrame board;
	private static JButton p1P0;
	private static JButton p1P1;
	private static JButton p1P2;
	private static JButton p2P0;
	private static JButton p2P1;
	private static JButton p2P2;

	static int piece = -1;
	static int hmMove = 0;
	static PlayGame obj = new PlayGame();

	public MovePiece(JPanel rightA, JPanel board, JFrame mainBoard) {
		this.rightA = rightA;
		this.yutBoard = board;
		this.board = mainBoard;
	}

	public MovePiece(int hm) {
		hmMove = hm;
	}

	public MovePiece() {
	}

	static Point points[] = { 
			new Point(0, 650, 75), 
			new Point(1, 705, 75), 
			new Point(2, 760, 75), 
			new Point(3, 650, 165),
			new Point(4, 705, 165), 
			new Point(5, 760, 165) };

	public static void createBtn() {
		p1P0 = new JButton();
		p1P1 = new JButton();
		p1P2 = new JButton();
		p2P0 = new JButton();
		p2P1 = new JButton();
		p2P2 = new JButton();

		p1P0.setBackground(Color.RED);
		p1P1.setBackground(Color.ORANGE);
		p1P2.setBackground(Color.yellow);
		p2P0.setBackground(Color.green);
		p2P1.setBackground(Color.blue);
		p2P2.setBackground(Color.black);

		p1P0.setBounds(650, 75, 30, 30);
		p1P1.setBounds(705, 75, 30, 30);
		p1P2.setBounds(760, 75, 30, 30);
		p2P0.setBounds(650, 165, 30, 30);
		p2P1.setBounds(705, 165, 30, 30);
		p2P2.setBounds(760, 165, 30, 30);

		board.add(p1P0);
		board.add(p1P1);
		board.add(p1P2);
		board.add(p2P0);
		board.add(p2P1);
		board.add(p2P2);
	}

	public static void clickBtn() {
		p1P0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 0;
				movePiece(p1P0);
			}
		});
		p1P1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 1;
				movePiece(p1P1);
			}
		});
		p1P2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 2;
				movePiece(p1P2);
			}
		});
		p2P0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 0;
				movePiece(p2P0);
			}
		});
		p2P1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 1;
				movePiece(p2P1);
			}
		});
		p2P2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				piece = 2;
				movePiece(p2P2);
			}
		});
	}

	public static void movePiece(JButton btn) {
		int[] xy = obj.pieceState(piece, hmMove);
		// System.out.println(xy[0] + " " + xy[1] + " " + xy[2]);
		
		yutBoard.add(btn);
		hmMove = 0;
		PlayGame.throwBtn.setEnabled(true);
	}

	public static void resetPiece(int i) {

		System.out.println("좌표 이동 : " + i);
		switch (i) {
		case 0:
			p1P0.setBounds(points[i].getX(), points[i].getY(), 30, 30);
			rightA.add(p1P0);
			break;
		case 1:
			p1P1.setBounds(points[i].getX(), points[i].getY(), 30, 30);
			rightA.add(p1P1);
			break;
		case 2:
			p1P2.setBounds(points[i].getX(), points[i].getY(), 30, 30);
			rightA.add(p1P2);
			break;
		case 3:
			p2P0.setBounds(points[i].getX(), points[i].getY(), 30, 30);
			rightA.add(p2P0);
			break;
		case 4:
			p2P1.setBounds(points[i].getX(), points[i].getY(), 30, 30);
			rightA.add(p2P1);
			break;
		case 5:
			p2P2.setBounds(points[i].getX(), points[i].getY(), 30, 30);
			rightA.add(p2P2);
			break;
		}
	}

	public static void hiddenPiece(int i) {
		switch (i) {
		case 0:
			p1P0.setVisible(false);
			rightA.add(p1P0);
			break;
		case 1:
			p1P1.setVisible(false);
			rightA.add(p1P1);
			break;
		case 2:
			p1P2.setVisible(false);
			rightA.add(p1P2);
			break;
		case 3:
			p2P0.setVisible(false);
			rightA.add(p2P0);
			break;
		case 4:
			p2P1.setVisible(false);
			rightA.add(p2P1);
			break;
		case 5:
			p2P2.setVisible(false);
			rightA.add(p2P2);
			break;
		}
	}
	public static void visiblePiece(int i) {
		switch (i) {
		case 0:
			p1P0.setVisible(true);
			rightA.add(p1P0);
			break;
		case 1:
			p1P1.setVisible(true);
			rightA.add(p1P1);
			break;
		case 2:
			p1P2.setVisible(true);
			rightA.add(p1P2);
			break;
		case 3:
			p2P0.setVisible(true);
			rightA.add(p2P0);
			break;
		case 4:
			p2P1.setVisible(true);
			rightA.add(p2P1);
			break;
		case 5:
			p2P2.setVisible(true);
			rightA.add(p2P2);
			break;
		}
	}

	// 버튼 비활성화
	public static void disableBtn(int nowTurn) {
		if (nowTurn == 1) {
			p2P0.setEnabled(false);
			p2P1.setEnabled(false);
			p2P2.setEnabled(false);
			p1P0.setEnabled(true);
			p1P1.setEnabled(true);
			p1P2.setEnabled(true);
		} else {
			p1P0.setEnabled(false);
			p1P1.setEnabled(false);
			p1P2.setEnabled(false);
			p2P0.setEnabled(true);
			p2P1.setEnabled(true);
			p2P2.setEnabled(true);
		}
	}

	// 전체 버튼 비활성화
	public static void disableAllBtn() {
		p1P0.setEnabled(false);
		p1P1.setEnabled(false);
		p1P2.setEnabled(false);
		p2P0.setEnabled(false);
		p2P1.setEnabled(false);
		p2P2.setEnabled(false);
		
	}

	public static void rePaint(int[][] p) {
		p1P0.setBounds(p[0][0], p[0][1], 30, 30);
		p1P1.setBounds(p[1][0], p[1][1], 30, 30);
		p1P2.setBounds(p[2][0], p[2][1], 30, 30);
		p2P0.setBounds(p[3][0], p[3][1], 30, 30);
		p2P1.setBounds(p[4][0], p[4][1], 30, 30);
		p2P2.setBounds(p[5][0], p[5][1], 30, 30);
		
		board.add(p1P0);
		board.add(p1P1);
		board.add(p1P2);
		board.add(p2P0);
		board.add(p2P1);
		board.add(p2P2);
		board.revalidate();
		board.repaint();
	}
}
