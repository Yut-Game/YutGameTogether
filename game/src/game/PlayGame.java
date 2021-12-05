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
	static JButton throwBtn;
	static int nowTurn = 1;

	static YutBoardPoint point = new YutBoardPoint();
	static rule rule = new rule();
	static MovePiece piece;

	// �÷��̾� ��
	static Piece[] p1P = new Piece[3];
	static Piece[] p2P = new Piece[3];
	// �÷��̾� ��ü
	static Player p1 = new Player();
	static Player p2 = new Player();

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		yutBoard = board.getYutBoard();
		comment = board.getComment();
		throwBtn = board.getThrowBtn();
		// ��ǥ ���� ( btn size 30 - 30 )
		for (int i = 0; i < YutBoardPoint.points.length; i++) {
			YutBoardPoint.points[i].addCordinate(-11, -10);
		}
		piece = new MovePiece(rightA, yutBoard);
		for (int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i, 0);
			p2P[i] = new Piece(2, i, 0);
		}

		piece.createBtn();
		piece.clickBtn();
		turnComment();

		// �� ��Ȱ��ȭ
		piece.disableAllBtn();
	}

	public static int[] pieceState(int pN, int move) {
		int location = 0;
		int finish = 0;
		// �� ���� �޾ƿ���
		if (nowTurn == 1) {
			int state = p1P[pN].getState();
			// ��� �� ���̶�� state �ٲٱ�
			if (state == -1) {
				p1.setIngPiece((p1.getIngPiece()) + 1);
				p1.setReadyPiece(p1.getReadyPiece() - 1);
				p1P[pN].setState(0);
			}

			location = p1P[pN].getLocation();
			location = checking(location, move);
			if (location == -2) {
				System.out.println("�� ��");
				p1P[pN].setState(1);
				p1.setFinishPiece(p1.getFinishPiece() + 1);
				p1.setIngPiece((p1.getIngPiece()) - 1);

				int c = catchOp(location);
				if (c == 0) {
					turn();
					turnComment();
				} else {
					comment.setText("�� �� �� ��������");
					rightA.add(comment);
				}
				return new int[] { 268, 392 };
			}
			System.out.println("location : " + location);
			// ���� �����̼ǿ� �̵��� ��ŭ ���ϱ�
			location += move;
			p1P[pN].setLocation(location);
		} else {
			int state = p2P[pN].getState();
			if (state == -1) {
				p2.setIngPiece((p2.getIngPiece()) + 1);
				p2.setReadyPiece(p2.getReadyPiece() - 1);
				p2P[pN].setState(0);
			}

			location = p2P[pN].getLocation();
			location = checking(location, move);
			if (location == -2) {
				System.out.println("�� ��");
				p1P[pN].setState(1);
				p2.setFinishPiece(p2.getFinishPiece() + 1);
				p2.setIngPiece((p2.getIngPiece()) - 1);
				int c = catchOp(location);
				if (c == 0) {
					turn();
					turnComment();
				} else {
					comment.setText("�� �� �� ��������");
					rightA.add(comment);
				}
				return new int[] { 268, 392 };
			}
			System.out.println("location : " + location);
			location += move;
			p2P[pN].setLocation(location);
		}
		int c = catchOp(location);
		System.out.println("location + move : " + location);

		int x = point.points[location].getX();
		int y = point.points[location].getY();

		// ��, ���� �� �� �� �� ������
		if (move != 5 && move != 4 && c == 0) {
			turn();
			turnComment();
		} else {
			comment.setText("�� �� �� ��������");
			rightA.add(comment);
		}

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
		piece.disableAllBtn();
	}

	// ���� üũ
	public static int checking(int location, int move) {
		// ���� üũ 1 - ���� �缱�� �ִ� ������
		location = rule.checkRutin(location, move);
		// ���� üũ 2 - ū ���� ��ġ�� ������
		location = rule.checkBigOne(location);
		// ���� üũ 3 - ������� �����ߴ���
		int finish = rule.checkFinish(location, move);
		// ���� üũ 4 - ū ���� �鵵����
		if (move == -1) {
			location = rule.checkBigOneBack(location);
		}
		if (finish == 1)
			location = -2;

		return location;
	}

	//���� �� ��Ҵ���
	public static int catchOp(int loc) {
		if (nowTurn == 1) {
			for (int i = 0; i < 3; i++) {
				if (p2P[i].getLocation() == loc) {
					if (p2P[i].getState() == 1)
						continue;
					System.out.println(" 2 ����");
					p2P[i].setLocation(0);
					p2P[i].setState(-1);
					piece.resetPiece(i + 3);
					return 1;
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if (p1P[i].getLocation() == loc) {
					if (p1P[i].getState() == 1)
						continue;
					System.out.println(" 1 ����");
					p1P[i].setLocation(0);
					p1P[i].setState(-1);
					piece.resetPiece(i);
					return 1;
				}
			}
		}

		return 0;
	}
}