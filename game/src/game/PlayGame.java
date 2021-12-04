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

	// 플레이어 말
	static Piece[] p1P = new Piece[3];
	static Piece[] p2P = new Piece[3];
	// 플레이어 객체
	Player p1 = new Player();
	Player p2 = new Player();

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		yutBoard = board.getYutBoard();
		comment = board.getComment();
		throwBtn = board.getThrowBtn();
		//좌표 조정 ( btn size 30 - 30 )
		for(int i=0;i<YutBoardPoint.points.length;i++) {
			YutBoardPoint.points[i].addCordinate(-11,-10);
		}
		piece = new MovePiece(rightA, yutBoard);
		for (int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i, 0);
			p2P[i] = new Piece(2, i, 0);
		}

		piece.createBtn();
		piece.clickBtn();
		turnComment();

		// 말 비활성화
		piece.disableAllBtn();
	}

	public static int[] pieceState(int pN, int move) {
		int location = 0;
		int finish = 0;
		// 말 상태 받아오기
		if (nowTurn == 1) {
			int state = p1P[pN].getState();
			// 출발 전 말이라면 state 바꾸기
			if (state == -1)
				p1P[pN].setState(0);

			location = p1P[pN].getLocation();
			location = checking(location, move);
			if(location == -2) {
				System.out.println("말 끝");
				return new int[] {485,480};
			}
			System.out.println("location : " + location);
			// 현재 로케이션에 이동할 만큼 더하기
			location += move;
			p1P[pN].setLocation(location);
		} else {
			int state = p2P[pN].getState();
			if (state == -1)
				p2P[pN].setState(0);

			location = p2P[pN].getLocation();
			location = checking(location, move);
			
			System.out.println("location : " + location);
			location += move;
			p2P[pN].setLocation(location);
		}

		System.out.println("location + move : " + location);
		// 이동한 번호가 큰 원일 때 등 조건 처리
		int x = point.points[location].getX();
		int y = point.points[location].getY();
		turn();
		turnComment();
		return new int[] { x, y };
	}

	// 턴 변경
	public static void turn() {
		if (nowTurn == 1)
			nowTurn = 2;
		else
			nowTurn = 1;
	}

	// 턴 코멘트
	public static void turnComment() {
		if (nowTurn == 1) {
			comment.setText("player 1의 차례입니다.");
		} else
			comment.setText("player 2의 차례입니다.");
		rightA.add(comment);
		piece.disableAllBtn();
	}
	
	// 조건 체크
	public static int checking(int location, int move) {
		//조건 체크 1 - 왼쪽 사선에 있는 말인지 
		location = rule.checkRutin(location, move);
		//조건 체크 2 - 큰 원에 위치한 말인지
		location = rule.checkBigOne(location);
		//조건 체크 3 - 결승점에 도달했는지
		int finish = rule.checkFinish(location, move);
		//조건 체크 4 - 큰 원에 백도인지
		if(move == -1) {
			location = rule.checkBigOneBack(location);
		}
		if(finish == 1) location = -2;
		
		return location;
	}
}