package archeryMatching;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import game.MovePiece;
import game.PlayGame;
import game.rule;

public class background extends JFrame implements ActionListener{
	//첫화면은 게임 설명
	//7초 후 게임 시작 vs 키입력시 게임 시작

	//게임 창 크기
	public final int WIDTH = 900;
	public final int HEIGHT = 800;
	public final int BOARD_WIDTH = (int) (WIDTH * 0.96);
	public final int BOARD_HEIGHT = (int) (HEIGHT * 0.925);
	
	//이미지 x좌표
	public static int X;
	
	//최상위 jFrame
	private JFrame BoardFrame;	
	//게임 설명 jPanel
	private JPanel explainPanel; 
	
	//상단 영역 jPanel
	private JPanel upPanel;
	//중앙 영역 jPanel
	private JPanel gamePanel;
	//하단 영역 jPanel
	private JPanel underPanel;
	
	//이미지 영역 jLabel
	public static JLabel imgArea;
	public static JLabel imgGreenArea;
	//타이머 표시
	public static JLabel timeBar;
	public static int timer_width = 390;
	public static JLabel timeComment;

	
	
	public static Button btn1;
	public static Button btn2;
	public static Button btn3;
	
	public background() {
		X = 110;
		//image
		ImageIcon backImg = new ImageIcon(background.class.getResource("../img/archeryBackground.png"));
		ImageIcon timerImg = new ImageIcon(background.class.getResource("../img/timer.png"));
		ImageIcon greenLight = new ImageIcon(background.class.getResource("../img/greenLight.png"));
		//최상위 jFrame 선언
		BoardFrame = new JFrame();
		BoardFrame.setTitle("과녘맞추기");
		//게임 화면 jPanel
		gamePanel = new JPanel();
		upPanel = new JPanel();
		underPanel = new JPanel();
		//이미지 영역
		imgArea = new JLabel();
		imgGreenArea = new JLabel();
		//타이머
		timeBar = new JLabel();
		timeComment = new JLabel("POINT : 0");
		//화살날리기 버튼
		btn1 = new Button();
		btn2 = new Button();
		btn3 = new Button();
		
		//기본 레이아웃 구성
		upPanel.setLayout(null);
		upPanel.setBounds(10, 10, 865, 150);
		upPanel.setBackground(Color.decode("#F5F2DF"));
		gamePanel.setLayout(null);
		gamePanel.setBounds(10, 160, 865, 400);
		gamePanel.setBackground(Color.WHITE);
		underPanel.setLayout(null);
		underPanel.setBounds(10, 560, 865, 190);
		underPanel.setBackground(Color.decode("#F5F2DF"));
		
		//버튼
		btn1.setBounds(162, 50, 100, 100);
		btn1.addActionListener(e -> {
			if(execute.answer==1) execute.addPoint();
		});
		btn1.setFocusable(true);
		underPanel.add(btn1);
		
		//버튼
		btn2.setBounds(383, 50, 100, 100);
		btn2.addActionListener(e -> {
			if(execute.answer==2) execute.addPoint();
		});
		btn2.setFocusable(true);
		underPanel.add(btn2);
		
		//버튼
		btn3.setBounds(604, 50, 100, 100);
		btn3.addActionListener(e -> {
			if(execute.answer==3) execute.addPoint();
		});
		btn3.setFocusable(true);
		underPanel.add(btn3);
		
		//이미지
		imgArea.setBounds(0, 0, 865, 400);
		imgArea.setIcon(backImg);
		//(179,0) (398, 0) (617,0)
		imgGreenArea.setBounds(617, 0,100,100);
		imgGreenArea.setIcon(greenLight);
		gamePanel.add(imgGreenArea);
		gamePanel.add(imgArea);

		
		//타이머
		timeComment.setBounds(400, 40,timer_width, 50);
		upPanel.add(timeComment);
		timeBar.setIcon(timerImg);
		timeBar.setBounds(238,80,390, 50);
		upPanel.add(timeBar);

		
		//최상위 jFrame 기본 설정
		BoardFrame.setLayout(null);
		BoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardFrame.setLocationRelativeTo(null);
		BoardFrame.setSize(WIDTH, HEIGHT);
		BoardFrame.setResizable(false);
		BoardFrame.setVisible(true);
		setLocationRelativeTo(null);
		BoardFrame.add(gamePanel);
		BoardFrame.add(upPanel);
		BoardFrame.add(underPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}