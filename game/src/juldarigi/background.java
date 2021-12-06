package juldarigi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import java.util.Timer;

import game.MovePiece;
import game.PlayGame;
import game.YutBoard;
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
	public static JFrame BoardFrame;	
	//게임 설명 jPanel
	private JPanel explainPanel; 
	
	//상단 영역 jPanel
	private static JPanel upPanel;
	//중앙 영역 jPanel
	private static JPanel gamePanel;
	//하단 영역 jPanel
	private static JPanel underPanel;
	
	//줄다리기 이미지 영역 jLabel
	public static JLabel imgArea;
	//당기기 버튼
	public static JButton pullBtn;
	//타이머 표시
	public static JLabel timeBar;
	public static int timer_width = 390;
	public static JLabel timeComment;
	
	//게임 진행 요소
	public static int countdown;
	private static boolean isEnd;
	static int count = 0;

	public static void start() {
		//게임 진행 화면
		new juldarigi.background();
		
		pullBtn.setVisible(true);
		imgArea.setVisible(true);
		timeComment.setVisible(true);
		timeBar.setVisible(true);
		gamePanel.setVisible(true);
		upPanel.setVisible(true);
		underPanel.setVisible(true);
		BoardFrame.setVisible(true);
		
		
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
           @Override
           public void run() {
              if(count<=55) {
                 System.out.println(count);
                 count++;
                 if(count%3==0) 
                 juldarigi.function.setTimer();
              }
              else {
            	  	timer.cancel();
	    			//시간초과시 비활
	    			background.pullBtn.setEnabled(false);
	    			background.BoardFrame.dispose();
	      			endGame(0);
	    			BoardFrame.dispose();
	    			YutBoard.BoardFrame.setVisible(true);
              }
           }
        };
        timer.scheduleAtFixedRate(task, 1000, 330);
	}
	public static void endGame(int winner) {
		String comment="";
		if(winner==1) comment="Computer의 승!\n윷놀이 화면으로 돌아갑니다.";
		else if(winner==2) comment="Player의 승!\n윷놀이 화면으로 돌아갑니다.";
		else comment="무승부입니다!\n윷놀이 화면으로 돌아갑니다.";
		JOptionPane.showMessageDialog(null, comment);
	}
	public background() {
		X = 110;
		//image
		ImageIcon juldarigi = new ImageIcon(background.class.getResource("../img/minigame_juldarigi.jpg"));
		ImageIcon timerImg = new ImageIcon(background.class.getResource("../img/timer.png"));
		//최상위 jFrame 선언
		BoardFrame = new JFrame();
		BoardFrame.setTitle("줄다리기");
		//게임 화면 jPanel
		gamePanel = new JPanel();
		upPanel = new JPanel();
		underPanel = new JPanel();
		//줄다리기 이미지 영역
		imgArea = new JLabel();
		//당기기 버튼
		pullBtn = new JButton();
		//root
		JRootPane root = BoardFrame.getRootPane();
		root.setDefaultButton(pullBtn);
		//타이머
		timeBar = new JLabel();
		timeComment = new JLabel("남은 시간");
		
		
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
		pullBtn.setBackground(new Color(255, 255, 0));
		pullBtn.setBounds(400, 100, 100, 30);
		pullBtn.addActionListener(e -> {
			System.out.println("버튼 눌림");
			function.moveImage(0);
		});
		pullBtn.setFocusable(true);
		imgArea.setBounds(X, 140, 670, 300);


		//이미지 연결
		imgArea.setIcon(juldarigi);
		
		//타이머
		timeComment.setBounds(400, 40,timer_width, 50);

		timeBar.setIcon(timerImg);
		timeBar.setBounds(238,80,390, 50);

		
		//최상위 jFrame 기본 설정
		BoardFrame.setLayout(null);
		BoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardFrame.setLocationRelativeTo(null);
		BoardFrame.setSize(WIDTH, HEIGHT);
		BoardFrame.setResizable(false);
		BoardFrame.setVisible(true);
		setLocationRelativeTo(null);
		
		pullBtn.setVisible(false);
		imgArea.setVisible(false);
		timeComment.setVisible(false);
		timeBar.setVisible(false);
		gamePanel.setVisible(false);
		upPanel.setVisible(false);
		underPanel.setVisible(false);
		BoardFrame.setVisible(false);
		
		underPanel.add(pullBtn);
		gamePanel.add(imgArea);
		upPanel.add(timeComment);
		upPanel.add(timeBar);
		BoardFrame.add(gamePanel);
		BoardFrame.add(upPanel);
		BoardFrame.add(underPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
