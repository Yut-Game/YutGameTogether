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

	// 플레이어 말
	static Piece[] p1P = new Piece[3];
	static Piece[] p2P = new Piece[3];

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		yutBoard = board.getYutBoard();
		MovePiece piece = new MovePiece(rightA, yutBoard);

		// 플레이어 객체
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
		// 현재 턴 누구 턴인지 가져오기 1, 2 - test상에선 그냥 1로 함

		//말 번호 알아내기  p의 마지막 - 누구 턴인지 알면 그냥 012만 넘기면 될 듯 / 못 알아내면 누구 말인지도 잘라서 사용
		int pN = Integer.parseInt(p.substring(3));
		
		// 말 상태 받아오기
		int state = p1P[pN].getState();
		// 출발 전 말이라면  state 바꾸기
		if (state == -1)
			p1P[pN].setState(0);
		
		int location = p1P[pN].getLocation();
		// 현재 로케이션에 이동할 만큼 더하기
		location += move;
		// 이동한 번호가 큰 원일 때 등 조건 처리
		int x = points[location].getX();
		int y = points[location].getY();
		return new int[] { x, y };
	}
}
