package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.Piece;
import classes.Player;
import classes.Point;

public class PlayGame {

	static YutBoard board;
	static JPanel rightA;
	static JFrame boardFrame;
	static JPanel yutBoard;
	static JLabel comment;
	static JLabel player1;
	static JLabel player2;
	static JButton throwBtn;
	static int nowTurn = 1;

	static YutBoardPoint point = new YutBoardPoint();
	static rule rule = new rule();
	static MovePiece piece;

	// 플레이어 말
	static Piece[] p1P = new Piece[3];
	static Piece[] p2P = new Piece[3];
	// 플레이어 객체
	static Player p1 = new Player();
	static Player p2 = new Player();

	public static void main(String[] args) {
		board = new YutBoard();
		rightA = board.getRightArea();
		yutBoard = board.getYutBoard();
		boardFrame = board.getBoard();
		comment = board.getComment();
		throwBtn = board.getThrowBtn();
		player1 = board.getOnePiece();
		player2 = board.getTwoPiece();
		// 좌표 조정 ( btn size 30 - 30 )
		for (int i = 0; i < YutBoardPoint.points.length; i++) {
			YutBoardPoint.points[i].addCordinate(-11, -10);
		}
		// 랜덤 미니게임 좌표 지정
		int gamePoint;
		
		
		piece = new MovePiece(rightA, yutBoard);
		for (int i = 0; i < 3; i++) {
			p1P[i] = new Piece(1, i, 0);
			p2P[i] = new Piece(2, i, 0);
			p1P[i].setY(75);
			p2P[i].setY(165);
		}
		p1P[0].setX(650);
		p1P[1].setX(705);
		p1P[2].setX(760);
		p2P[0].setX(650);
		p2P[1].setX(705);
		p2P[2].setX(760);

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
			if (state == -1) {
				p1.setIngPiece((p1.getIngPiece()) + 1);
				p1.setReadyPiece(p1.getReadyPiece() - 1);
				p1P[pN].setState(0);
			}

			location = p1P[pN].getLocation();
			location = checking(location, move);
			if (location == -2) {
				System.out.println("말 끝");
				for (int i = 0; i < 3; i++) {
					if (p1P[i].getChangeNum() == pN) {
						p1P[i].setState(1);
					}
				}
				p1.setFinishPiece(p1.getFinishPiece() + p1P[pN].getCarry());
				p1.setIngPiece((p1.getIngPiece()) - p1P[pN].getCarry());

				int c = catchOp(location);
				if (c == 0) {
					turn();
					turnComment();
				} else {
					comment.setText("한 번 더 던지세요");
					rightA.add(comment);
				}
				playerState();
				return new int[] { 268, 392 };
			}
			System.out.println("location : " + location);
			// 현재 로케이션에 이동할 만큼 더하기
			location += move;
			int carry = carryP(location, p1P[pN].getpNum());
			if (carry == 1)
				p1P[pN].setCarry(p1P[pN].getCarry() + 1);
			p1P[pN].setLocation(location);
			int x = point.points[location].getX();
			int y = point.points[location].getY();
			p1P[pN].setX(x);
			p1P[pN].setY(y);
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

				System.out.println("말 끝");
				for (int i = 0; i < 3; i++) {
					if (p2P[i].getChangeNum() == pN) {
						p2P[i].setState(1);
					}
				}
				p2.setFinishPiece(p2.getFinishPiece() + p2P[pN].getCarry());
				p2.setIngPiece((p2.getIngPiece()) - p2P[pN].getCarry());

				int c = catchOp(location);
				if (c == 0) {
					turn();
					turnComment();
				} else {
					comment.setText("한 번 더 던지세요");
					rightA.add(comment);
				}
				playerState();
				return new int[] { 268, 392 };
			}
			System.out.println("location : " + location);
			location += move;
			int carry = carryP(location, p2P[pN].getpNum());
			if (carry == 1)
				p2P[pN].setCarry(p2P[pN].getCarry() + 1);
			p2P[pN].setLocation(location);
			int x = point.points[location].getX();
			int y = point.points[location].getY();
			p2P[pN].setX(x);
			p2P[pN].setY(y);
		}
		int c = catchOp(location);

		System.out.println("location + move : " + location);

		int x = point.points[location].getX();
		int y = point.points[location].getY();

		// 윷, 모일 때 한 번 더 던지기
		if (move != 5 && move != 4 && c == 0) {
			turn();
			turnComment();
		} else {
			comment.setText("한 번 더 던지세요");
			rightA.add(comment);
		}
		repaintPiece();
		playerState();
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

	// 턴 코멘트
	public static void playerState() {
		int ing = p1.getIngPiece();
		int ready = p1.getReadyPiece();
		int finish = p1.getFinishPiece();
		// player1.setText("[player 1 말 상태]\n 시작 전 말 : " + ready + " 진행중인 말 : " + ing +
		// " 도착한 말 : " + finish);
		player1.setText("시작 전 말 : " + ready + " 진행중인 말 : " + ing + " 도착한 말 : " + finish);

		rightA.add(player1);
		ing = p2.getIngPiece();
		ready = p2.getReadyPiece();
		finish = p2.getFinishPiece();
		// player2.setText("[player 2 말 상태]\n 시작 전 말 : " + ready + " 진행중인 말 : " + ing +
		// " 도착한 말 : " + finish);
		player2.setText("시작 전 말 : " + ready + " 진행중인 말 : " + ing + " 도착한 말 : " + finish);

		rightA.add(player2);
	}

	// 조건 체크
	public static int checking(int location, int move) {
		// 조건 체크 1 - 왼쪽 사선에 있는 말인지
		location = rule.checkRutin(location, move);
		// 조건 체크 2 - 큰 원에 위치한 말인지
		location = rule.checkBigOne(location);
		// 조건 체크 3 - 결승점에 도달했는지
		int finish = rule.checkFinish(location, move);
		// 조건 체크 4 - 큰 원에 백도인지
		if (move == -1) {
			location = rule.checkBigOneBack(location);
		}
		if (finish == 1)
			location = -2;

		return location;
	}

	// 상대방 말 잡았는지
	public static int catchOp(int loc) {
		int carryNum = -1;
		if (nowTurn == 1) {
			for (int i = 0; i < 3; i++) {
				if (p2P[i].getLocation() == loc) {
					if (p2P[i].getState() == 1)
						continue;
					if(p1P[i].getChangeNum() != p1P[i].getpNum()) continue;
					p2.setIngPiece(p2.getIngPiece() - p2P[i].getCarry());
					p2.setReadyPiece(p2.getReadyPiece() + p2P[i].getCarry());
					System.out.println(" 2 잡힘");
					if (p2P[i].getCarry() == 1) {
						p2P[i].setLocation(0);
						p2P[i].setState(-1);
						piece.resetPiece(i + 3);
						return 1;
					} else if (p2P[i].getCarry() > 1) {
						System.out.println("업은 말이래!!!@");
						carryNum = p2P[i].getpNum();
						for (int j = 0; j < 3; j++) {
							if (p2P[j].getChangeNum() == carryNum) {
								System.out.println("p2P[i] : " + p2P[i].getChangeNum() + " " + j);
								System.out.println("p2P[j] : " + p2P[j].getChangeNum() + " " + j);
								p2P[j].setLocation(0);
								p2P[j].setState(-1);
								piece.visiblePiece(j + 3);
								piece.resetPiece(j + 3);
							}
						}
						return 1;
					}
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if (p1P[i].getLocation() == loc) {
					if (p1P[i].getState() == 1)
						continue;
					if(p1P[i].getChangeNum() != p1P[i].getpNum()) continue;
					p1.setIngPiece(p1.getIngPiece() - p1P[i].getCarry());
					p1.setReadyPiece(p1.getReadyPiece() + p1P[i].getCarry());
					System.out.println(" 1 잡힘");
					if (p1P[i].getCarry() == 1) {
						p1P[i].setLocation(0);
						p1P[i].setState(-1);
						piece.resetPiece(i);
						return 1;
						// 업은 말인 경우
					} else if (p1P[i].getCarry() > 1) {
						System.out.println("업은 말이래!!!@");
						// p1P[i]가 업은 말임. 업은 말의 넘버를 carryNum으로 지정
						carryNum = p1P[i].getpNum();
						System.out.println("carryNum : " + carryNum);
						// 말 수 만큼 for문 돌림
						for (int j = 0; j < 3; j++) {
							// p1P[j]의 변경됨 넘버가 carryNum과 같을 경우 (업힌 말인 경우 changeNum은 업은 말로 바뀜)
							System.out.println("p1P[j].changeNum : " + p1P[j].getChangeNum());
							System.out.println("p1P[i] : " + p1P[i].getChangeNum() + " " + j);
							System.out.println("p1P[j] : " + p1P[j].getChangeNum() + " " + j);
							if (p1P[j].getChangeNum() == carryNum) {
								p1P[j].setLocation(0);
								p1P[j].setState(-1);
								piece.visiblePiece(j);
								piece.resetPiece(j);
							}
						}
						return 1;
					}
				}
			}
		}

		return 0;
	}

	// 말 업기
	public static int carryP(int loc, int pNum) {
		if (nowTurn == 1) {
			for (int i = 0; i < 3; i++) {
				System.out.println(pNum + "  " + p1P[i].getpNum());
				if (pNum == p1P[i].getpNum())
					continue;
				if (p1P[i].getLocation() == loc) {
					if (p1P[i].getState() == 1)
						continue;
					System.out.println(" 말 업힐지 물어보기" + loc + "  " + p1P[i].getLocation());
					int answer = JOptionPane.showConfirmDialog(null, "말을 업으실건가요?", "confirm",
							JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) { // 사용자가 yes를 눌렀을 경우
						System.out.println("말 업겟단다.");
						p1P[i].setChangeNum(pNum);
						System.out.println("업은 말의 번호 : " + pNum);
						System.out.println("업힌 말의 번호 : " + p1P[i].getChangeNum());
						piece.hiddenPiece(i);
						return 1;
					} else { // 사용자가 Yes 이외의 값을 눌렀을 경우
						return 0;
					}
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				System.out.println(pNum + "  " + p2P[i].getpNum());
				if (pNum == p2P[i].getpNum())
					continue;
				if (p2P[i].getLocation() == loc) {
					if (p2P[i].getState() == 1)
						continue;
					System.out.println(" 말 업힐지 물어보기");
					int answer = JOptionPane.showConfirmDialog(null, "말을 업으실건가요?", "confirm",
							JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) { // 사용자가 yes를 눌렀을 경우
						System.out.println("말 업겟단다.");

						p2P[i].setChangeNum(pNum);
						System.out.println("업은 말의 번호 : " + pNum);
						System.out.println("업힌 말의 번호 : " + p2P[i].getChangeNum());
						piece.hiddenPiece(i + 3);
						return 1;
					} else { // 사용자가 Yes 이외의 값을 눌렀을 경우
						return 0;
					}
				}
			}
		}

		return 0;
	}

	public static void repaintPiece() {
		int[][] p = new int[6][6];
		for (int i = 0; i < 3; i++) {
			p[i][0] = p1P[i].getX();
			p[i][1] = p1P[i].getY();
			System.out.println("X : " + p[i][0] + " Y : " + p[i][1]);
		}
		for (int i = 0; i < 3; i++) {
			p[i+3][0] = p2P[i].getX();
			p[i+3][1] = p2P[i].getY();
			System.out.println("X : " + p[i+3][0] + " Y : " + p[i+3][1]);
			
		}
		
	}

}