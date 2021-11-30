package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class YutBoard extends JFrame{

	//게임 창 크기
	public static final int WIDTH = 900;
	public static final int HEIGHT = 800;
	//윷놀이판 크기
	public final int BOARD_WIDTH = (int) (WIDTH*0.61);
	public final int BOARD_HEIGHT = (int) (HEIGHT*0.69);
	
	
	//최상위 jFrame
	public static JFrame BoardFrame;
	//윷놀이판 영역 jPanel
	private JPanel yutBoardPanel;
	//윷 영역 jPanel
	private JPanel YutPanel;
	//우측 영역 jPanel
	private JPanel rightArea;	
	//(우측) 사용자1 상태
	private JLabel userOneProgress;
	//(우측) 사용자2 상태
	private JLabel userTwoProgress;
	//(우측) 윷던지기 버튼
	private JButton throwYut;
	//(우측) 말 이동 선택지 버튼
	private JButton[] movingMal;
	
	
	//(요소) 큰 원
	ImageIcon bigCircle = new ImageIcon("../img/bigCircle.png");
	//(요소) 작은 원
	ImageIcon smallCircle = new ImageIcon("../img/smallCircle.png");
	
			
	
	public YutBoard() {
		BoardFrame = new JFrame();
		BoardFrame.setTitle("Card Of Yut");
		//(좌측) 윷놀이판 영역
		yutBoardPanel = new JPanel() {
			Image background=new ImageIcon(YutBoard.class.getResource("../img/yutpan.png")).getImage();
			public void paint(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		//(좌측) 윷 영역
		YutPanel = new JPanel();
		//우측 영역 jPanel
		rightArea = new JPanel();		
		//(우측) 사용자1 상태
		userOneProgress = new JLabel("사용자 1 남은 말 수 표시");
		//(우측) 사용자2 상태
		userTwoProgress = new JLabel("사용자 2 남은 말 수 표시");
		//(우측) 말 이동 선택지 버튼
		movingMal = new JButton[3];
		
		//test
		JButton button = new JButton(bigCircle); 
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		yutBoardPanel.add(button); 		
		
		//(레이아웃 구성) 윷놀이판, 윷 배치
		yutBoardPanel.setBounds(10,10,BOARD_WIDTH,BOARD_HEIGHT);
		yutBoardPanel.setBackground(Color.WHITE);
		YutPanel.setBounds(10, BOARD_HEIGHT+20, BOARD_WIDTH, HEIGHT-BOARD_HEIGHT-70);
		YutPanel.setBackground(Color.WHITE);
		rightArea.setBounds(BOARD_WIDTH+20, 10, WIDTH-BOARD_WIDTH-50,  HEIGHT-60);
		rightArea.setBackground(Color.WHITE);
		//(레이아웃 구성) 사용자 상태, 윷 버튼 배치
		rightArea.add(userOneProgress);
		rightArea.add(userTwoProgress);
		
		
		//윷 던지기 버튼
		throwYut = new JButton("윷 던지기");
		throwYut = createBoardBtn(throwYut,WIDTH/20*9,WIDTH/20*10,WIDTH/20*3,WIDTH/20,true);
		throwYut.setBackground(new Color(255,255,0));
		throwYut.addActionListener(e->{
			rule r = new rule();
		});
		rightArea.add(throwYut);
		
		//말 선택 버튼
		for(int i=0;i<3;i++) {
			movingMal[i] = new JButton((i+1)+"번 말 이동");
			movingMal[i] = createBoardBtn(movingMal[i],WIDTH/20*9,WIDTH/20*10,WIDTH/20*3,WIDTH/20,true);
			movingMal[i].setBackground(new Color(255,255,0));
			rightArea.add(movingMal[i]);
		}


		//최상위 jFrame 기본 설정
		BoardFrame.setLayout(null);
		BoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardFrame.setLocationRelativeTo(null);
		BoardFrame.setSize(WIDTH, HEIGHT);
		BoardFrame.setResizable(false);
		BoardFrame.setVisible(true);
		
		BoardFrame.add(yutBoardPanel);
		BoardFrame.add(YutPanel);
		BoardFrame.add(rightArea);
		
	
	}
	
	public void paint(Graphics g,Image yut) {// 그리는 함수
		g.drawImage(yut, 0, 0, null);// background를 그려줌
		System.out.println("paint()");
	}
	
	JButton createBoardBtn(JButton btn, int x, int y, int width, int depth, boolean tf)
	{
		btn.setSize(width, depth);
		btn.setBorderPainted(tf);
		btn.setContentAreaFilled(tf);
		btn.setLocation(x,y);
		return btn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new YutBoard();
	}

}
