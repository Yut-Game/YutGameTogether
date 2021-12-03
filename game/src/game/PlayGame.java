package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Piece;
import classes.Player;
import classes.Point;

public class PlayGame {

	static YutBoard board;
	static JPanel rightA;
	static JPanel yutBoard;
	static JLabel comment;
	static int nowTurn = 1;

	static YutBoardPoint point = new YutBoardPoint();
	static rule rule = new rule();
	static MovePiece piece;

	// �÷��̾� ��
	static Piece[] p1P = new Piece[3];
	static Piece[] p2P = new Piece[3];
	// �÷��̾� ��ü
	Player p1 = new Player();
	Player p2 = new Player();

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		yutBoard = board.getYutBoard();
		comment = board.getComment();
		piece = new MovePiece(rightA, yutBoard);
		for (int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i, 0);
			p2P[i] = new Piece(2, i, 0);
		}

		piece.createBtn();
		piece.clickBtn();
		turnComment();
	}

	public static int[] pieceState(int pN, int move) {
		int location = 0;
		int finish = 0;
		// �� ���� �޾ƿ���
		if (nowTurn == 1) {
			int state = p1P[pN].getState();
			// ��� �� ���̶�� state �ٲٱ�
			if (state == -1)
				p1P[pN].setState(0);

			location = p1P[pN].getLocation();
			location = checking(location, move);
			if(location == -2) {
				System.out.println("�� ��");
				return new int[] {485,480};
			}
			System.out.println("location : " + location);
			// ���� �����̼ǿ� �̵��� ��ŭ ���ϱ�
			location += move;
			p1P[pN].setLocation(location);
		} else {
			int state = p2P[pN].getState();
			if (state == -1)
				p2P[pN].setState(0);

			location = p2P[pN].getLocation();
			location = rule.checkBigOne(location);
			
			System.out.println("location : " + location);
			location += move;
			p2P[pN].setLocation(location);
		}

		System.out.println("location + move : " + location);
		// �̵��� ��ȣ�� ū ���� �� �� ���� ó��
		int x = point.points[location].getX();
		int y = point.points[location].getY();
//		turn();
		turnComment();
		return new int[] { x, y };
	}

	// �� ����
	public static void turn() {
		if (nowTurn == 1)
			nowTurn = 2;
		else
			nowTurn = 1;
	}

	// �� �ڸ�Ʈ
	public static void turnComment() {
		if (nowTurn == 1) {
			comment.setText("player 1�� �����Դϴ�.");
		} else
			comment.setText("player 2�� �����Դϴ�.");
		rightA.add(comment);
		piece.disableBtn(nowTurn);
	}
	
	// ���� üũ
	public static int checking(int location, int move) {
		//���� üũ 1 - ���� �缱�� �ִ� ������ 
		location = rule.checkRutin(location, move);
		//���� üũ 2 - ū ���� ��ġ�� ������
		location = rule.checkBigOne(location);
		//���� üũ 3 - ������� �����ߴ���
		int finish = rule.checkFinish(location, move);
		//���� üũ 4 - ū ���� �鵵����
		if(move == -1) {
			location = rule.checkBigOneBack(location);
		}
		if(finish == 1) location = -2;
		
		return location;
	}
}
