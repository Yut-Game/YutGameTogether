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

	static Point points[] = { new Point(0, 485, 480), new Point(1, 485, 391), new Point(2, 485, 310), new Point(3, 485, 229),
			new Point(4, 485, 148), new Point(5, 485, 52), new Point(6, 390, 52), new Point(7, 309, 52),
			new Point(8, 228, 52), new Point(9, 147, 52), };

	static YutBoard board;
	static JPanel rightA;
	static JPanel yutBoard;

	// �÷��̾� ��
	static Piece[] p1P = new Piece[3];
	static Piece[] p2P = new Piece[3];

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		yutBoard = board.getYutBoard();
		MovePiece piece = new MovePiece(rightA, yutBoard);

		// �÷��̾� ��ü
		Player p1 = new Player();
		Player p2 = new Player();

		for (int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i, -1);
			p2P[i] = new Piece(2, i, -1);
		}

		piece.createBtn();
		piece.clickBtn();
	}

	public static int[] pieceState(String p, int move) {
		// ���� �� ���� ������ �������� 1, 2 - test�󿡼� �׳� 1�� ��

		//�� ��ȣ �˾Ƴ���  p�� ������ - ���� ������ �˸� �׳� 012�� �ѱ�� �� �� / �� �˾Ƴ��� ���� �������� �߶� ���
		int pN = Integer.parseInt(p.substring(3));
		
		// �� ���� �޾ƿ���
		int state = p1P[pN].getState();
		// ��� �� ���̶��  state �ٲٱ�
		if (state == -1)
			p1P[pN].setState(0);
		
		int location = p1P[pN].getLocation();
		// ���� �����̼ǿ� �̵��� ��ŭ ���ϱ�
		location += move;
		// �̵��� ��ȣ�� ū ���� �� �� ���� ó��
		int x = points[location].getX();
		int y = points[location].getY();
		return new int[] { x, y };
	}
}
