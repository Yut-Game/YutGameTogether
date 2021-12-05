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
		boardFrame = board.getBoard();
		comment = board.getComment();
		throwBtn = board.getThrowBtn();
		player1 = board.getOnePiece();
		player2 = board.getTwoPiece();
		// ��ǥ ���� ( btn size 30 - 30 )
		for (int i = 0; i < YutBoardPoint.points.length; i++) {
			YutBoardPoint.points[i].addCordinate(-11, -10);
		}
		// ���� �̴ϰ��� ��ǥ ����
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
					comment.setText("�� �� �� ��������");
					rightA.add(comment);
				}
				playerState();
				return new int[] { 268, 392 };
			}
			System.out.println("location : " + location);
			// ���� �����̼ǿ� �̵��� ��ŭ ���ϱ�
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

				System.out.println("�� ��");
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
					comment.setText("�� �� �� ��������");
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

		// ��, ���� �� �� �� �� ������
		if (move != 5 && move != 4 && c == 0) {
			turn();
			turnComment();
		} else {
			comment.setText("�� �� �� ��������");
			rightA.add(comment);
		}
		repaintPiece();
		playerState();
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

	// �� �ڸ�Ʈ
	public static void playerState() {
		int ing = p1.getIngPiece();
		int ready = p1.getReadyPiece();
		int finish = p1.getFinishPiece();
		// player1.setText("[player 1 �� ����]\n ���� �� �� : " + ready + " �������� �� : " + ing +
		// " ������ �� : " + finish);
		player1.setText("���� �� �� : " + ready + " �������� �� : " + ing + " ������ �� : " + finish);

		rightA.add(player1);
		ing = p2.getIngPiece();
		ready = p2.getReadyPiece();
		finish = p2.getFinishPiece();
		// player2.setText("[player 2 �� ����]\n ���� �� �� : " + ready + " �������� �� : " + ing +
		// " ������ �� : " + finish);
		player2.setText("���� �� �� : " + ready + " �������� �� : " + ing + " ������ �� : " + finish);

		rightA.add(player2);
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

	// ���� �� ��Ҵ���
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
					System.out.println(" 2 ����");
					if (p2P[i].getCarry() == 1) {
						p2P[i].setLocation(0);
						p2P[i].setState(-1);
						piece.resetPiece(i + 3);
						return 1;
					} else if (p2P[i].getCarry() > 1) {
						System.out.println("���� ���̷�!!!@");
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
					System.out.println(" 1 ����");
					if (p1P[i].getCarry() == 1) {
						p1P[i].setLocation(0);
						p1P[i].setState(-1);
						piece.resetPiece(i);
						return 1;
						// ���� ���� ���
					} else if (p1P[i].getCarry() > 1) {
						System.out.println("���� ���̷�!!!@");
						// p1P[i]�� ���� ����. ���� ���� �ѹ��� carryNum���� ����
						carryNum = p1P[i].getpNum();
						System.out.println("carryNum : " + carryNum);
						// �� �� ��ŭ for�� ����
						for (int j = 0; j < 3; j++) {
							// p1P[j]�� ����� �ѹ��� carryNum�� ���� ��� (���� ���� ��� changeNum�� ���� ���� �ٲ�)
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

	// �� ����
	public static int carryP(int loc, int pNum) {
		if (nowTurn == 1) {
			for (int i = 0; i < 3; i++) {
				System.out.println(pNum + "  " + p1P[i].getpNum());
				if (pNum == p1P[i].getpNum())
					continue;
				if (p1P[i].getLocation() == loc) {
					if (p1P[i].getState() == 1)
						continue;
					System.out.println(" �� ������ �����" + loc + "  " + p1P[i].getLocation());
					int answer = JOptionPane.showConfirmDialog(null, "���� �����ǰǰ���?", "confirm",
							JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) { // ����ڰ� yes�� ������ ���
						System.out.println("�� ���ٴܴ�.");
						p1P[i].setChangeNum(pNum);
						System.out.println("���� ���� ��ȣ : " + pNum);
						System.out.println("���� ���� ��ȣ : " + p1P[i].getChangeNum());
						piece.hiddenPiece(i);
						return 1;
					} else { // ����ڰ� Yes �̿��� ���� ������ ���
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
					System.out.println(" �� ������ �����");
					int answer = JOptionPane.showConfirmDialog(null, "���� �����ǰǰ���?", "confirm",
							JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) { // ����ڰ� yes�� ������ ���
						System.out.println("�� ���ٴܴ�.");

						p2P[i].setChangeNum(pNum);
						System.out.println("���� ���� ��ȣ : " + pNum);
						System.out.println("���� ���� ��ȣ : " + p2P[i].getChangeNum());
						piece.hiddenPiece(i + 3);
						return 1;
					} else { // ����ڰ� Yes �̿��� ���� ������ ���
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