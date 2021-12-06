package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class YutBoard extends JFrame {

	// 게임 창 크기
	public static final int WIDTH = 900;
	public static final int HEIGHT = 800;
	// 윷놀이판 크기
	public final int BOARD_WIDTH = (int) (WIDTH * 0.61);
	public final int BOARD_HEIGHT = (int) (HEIGHT * 0.69);

	// 최상위 jFrame
	public static JFrame BoardFrame;
	// 윷놀이판 영역 jPanel
	private JPanel yutBoardPanel;
	// 윷 영역 jPanel
	private JPanel YutPanel;
	// 윷 jLabel
	private JLabel yutArea;
	// 이전 윷 jLabel
	private JLabel preYutArea;

	// 우측 영역 jPanel
	private JPanel rightArea;
	// (우측) 사용자1 상태
	private JLabel userOneProgress;
	// (우측) 사용자2 상태
	private JLabel userTwoProgress;
	// (우측) 코멘트 ** 추가
	private JLabel comment;
	// (우측) 사용자1 상태 ** 추가
	private JLabel userOnePiece;
	// (우측) 사용자2 상태 ** 추가
	private JLabel userTwoPiece;
	// (우측) 윷던지기 버튼
	private JButton throwYut;
	// (우측) 미니게임 버튼
	public static JButton moveMiniGame;

	// (윷 영역) 현재 윷 
	private ImageIcon yut;
	// (윷 영역) 이전 윷 
	private ImageIcon preYut;
	
	public static int gameType;
	

	public YutBoard() {
		//미니게임
		final JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout(10, 10));
		final JPanel archeryPanel = new JPanel();
		final JPanel juldarigiPanel = new JPanel();
		
		
		BoardFrame = new JFrame();
		Container c1 = BoardFrame.getContentPane();
		BoardFrame.setTitle("Card Of Yut");
		// (좌측) 윷놀이판 영역
		yutBoardPanel = new JPanel() {
			Image background = new ImageIcon(YutBoard.class.getResource("../img/yutpan.png")).getImage();

			public void paint(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};

		// (좌측) 윷 영역
		YutPanel = new JPanel();
		yutArea = new JLabel();
		preYutArea = new JLabel();
		// 우측 영역 jPanel
		rightArea = new JPanel();
		// (우측) 사용자1 상태
		userOneProgress = new JLabel("사용자 1 남은 말 수 표시");
		// (우측) 사용자2 상태
		userTwoProgress = new JLabel("사용자 2 남은 말 수 표시");
		// (우측) 말 이동 선택지 버튼
		comment = new JLabel("코멘트");
		// (우측) 사용자1 상태
		userOnePiece = new JLabel("사용자1 말 상태");
		// (우측) 사용자2 상태
		userTwoPiece = new JLabel("사용자2 말 상태");
		
		// (레이아웃 구성) 윷놀이판, 윷 배치
		yutBoardPanel.setLayout(null);
		yutBoardPanel.setBounds(10, 10, BOARD_WIDTH, BOARD_HEIGHT);
		yutBoardPanel.setBackground(Color.WHITE);
		YutPanel.setBounds(10, BOARD_HEIGHT + 20, BOARD_WIDTH, HEIGHT - BOARD_HEIGHT - 70);
		YutPanel.setBackground(Color.WHITE);
		rightArea.setLayout(null);
		rightArea.setBounds(BOARD_WIDTH + 20, 10, WIDTH - BOARD_WIDTH - 50, HEIGHT - 60);
		rightArea.setBackground(Color.WHITE);
		// (레이아웃 구성) 사용자 상태, 윷 버튼 배치
		userOneProgress.setBounds(80, 10, 150, 50);
		userTwoProgress.setBounds(80, 110, 150, 50);
		comment.setBounds(80, 200, 150, 50);
		userOnePiece.setBounds(2, 550, 300, 50);
		userTwoPiece.setBounds(2, 600, 300, 50);
		preYutArea.setBounds(95, 500, 200, 90);
		rightArea.add(userOneProgress);
		rightArea.add(userTwoProgress);
		rightArea.add(comment);
		rightArea.add(userOnePiece);
		rightArea.add(userTwoPiece);
		rightArea.add(preYutArea);
		YutPanel.add(yutArea);

		// 윷 던지기 버튼
		throwYut = new JButton("윷 던지기");
		throwYut.setBackground(new Color(255, 255, 0));
		throwYut.addActionListener(e -> {
			System.out.println("버튼 눌림");
			// 현재 윷 지정
			rule r = new rule();
			yut = r.randomYut();
			System.out.println("현재 윷 : "+yut);
			yutArea.setIcon(yut);
			int hm = r.getIsYut();
			MovePiece mp = new MovePiece(hm);
			// 윷 던진 이후 버튼 활성화 & 던지기 비활성화
			mp.disableBtn(PlayGame.nowTurn);
			throwYut.setEnabled(false);
		});
		throwYut.setBounds(100, 450, 100, 30);
		rightArea.add(throwYut);
		// 미니게임 버튼
		moveMiniGame = new JButton("미니게임");
		moveMiniGame.setEnabled(false);
		moveMiniGame.setBackground(new Color(255, 255, 0));
		moveMiniGame.addActionListener(e -> {
			System.out.println("버튼 눌림");
			if(gameType==1) {
				BoardFrame.setVisible(false);
				try{
					Thread.sleep(2000);
				} catch(Exception e1){}
				new juldarigi.background().start();
				YutBoard.moveMiniGame.setEnabled(true);
			} else if(gameType==2) {
				BoardFrame.setVisible(false);
				try{
					Thread.sleep(2000);
				} catch(Exception e1){}
				new archeryMatching.background().start();
				YutBoard.moveMiniGame.setEnabled(true);
			}

		});
		moveMiniGame.setBounds(100, 500, 100, 30);
		rightArea.add(moveMiniGame);

		// 최상위 jFrame 기본 설정
		BoardFrame.setLayout(null);
		BoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardFrame.setLocationRelativeTo(null);
		BoardFrame.setSize(WIDTH, HEIGHT);
		BoardFrame.setResizable(false);
		BoardFrame.setVisible(true);
		c1.add(yutBoardPanel);
		c1.add(YutPanel);
		c1.add(rightArea);
	}

	public void mgps() {
		BoardFrame.addMouseMotionListener(new MouseAdapter() { // 마우스 이벤트
			@Override
			public void mouseMoved(MouseEvent e) { // 마우스 움직일때.
				System.out.println(e.getX() + " " + e.getY());// x좌표,y좌표 출력
			}
		});
	}

	public JPanel getRightArea() {
		return rightArea;
	}

	public JPanel getYutBoard() {
		return yutBoardPanel;
	}
	public JLabel getComment() {
		return comment;
	}
	public JLabel getOnePiece() {
		return userOnePiece;
	}
	public JLabel getTwoPiece() {
		return userTwoPiece;
	}
	public JButton getThrowBtn() {
		return throwYut;
	}
}
