package NumberMatching;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import game.MovePiece;
import game.PlayGame;
import game.YutBoard;
import game.rule;

public class background extends JFrame implements ActionListener{

	//게임 창 크기
	public final int WIDTH = 900;
	public final int HEIGHT = 800;
	public final int BOARD_WIDTH = (int) (WIDTH * 0.96);
	public final int BOARD_HEIGHT = (int) (HEIGHT * 0.925);
	
	//최상위 jFrame
	public static JFrame BoardFrame;	
	
	//상단 영역 jPanel
	private JPanel upPanel;
	//중앙 영역 jPanel
	public static JPanel gamePanel;
	//하단 영역 jPanel
	private JPanel underPanel;
	
	//단계 표시
	public static JLabel comment;
	
	//문제 숫자 버튼
	public static Button[] buttons;
	//보기 숫자 버튼
	public static Button[] gamebuttons;
	static int count = 0;
	static int index = 0;
	
	public static void endGame() {
		JOptionPane.showMessageDialog(null, "점수 : "+8+"점\n게임오버!");
	}
	
	public static void start() {
		new NumberMatching.background();
		int[] rand = {1,2,3,4,5,6,7,8};
		int[] game_rand = new int[8];
		//랜덤 순서 배열 생성
		for(int i=0;i<rand.length;i++) {
			game_rand[i] = i;
		}

		Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {

           @Override
           public void run() {
              if(count<=5) {
                 System.out.println(count);
                 count++;
                 gamebuttons[game_rand[index]].setBackground(null);
                 index++;
                 gamebuttons[game_rand[index]].setBackground(Color.PINK);
                 archeryMatching.function.setTimer();
              }
              else {
                 timer.cancel();
                 endGame();
                 BoardFrame.dispose();
                 YutBoard.BoardFrame.setVisible(true);
              }
           }
        };
        timer.scheduleAtFixedRate(task, 1000, 200);

		
		
		
	}
	
	public static void main(String args[]) {
		start();
	}
	
	public background() {
		//최상위 jFrame 선언
		BoardFrame = new JFrame();
		BoardFrame.setTitle("순서맞추기");
		//게임 화면 jPanel
		gamePanel = new JPanel();
		upPanel = new JPanel();
		underPanel = new JPanel();
		//당기기 버튼
		buttons = new Button[8];
		for(int i=0;i<buttons.length;i++) {
			buttons[i] = new Button();
		}
		int height=80,width=80;
		int minus = 100;
		buttons[0].setBounds(160, 191-minus, width, height);
		buttons[0].setBackground(Color.RED);
		buttons[1].setBounds(315, 191-minus, width, height);
		buttons[1].setBackground(Color.ORANGE);
		buttons[2].setBounds(470, 191-minus, width, height);
		buttons[2].setBackground(Color.YELLOW);
		buttons[3].setBounds(625, 191-minus, width, height);
		buttons[3].setBackground(Color.GREEN);
		buttons[4].setBounds(160, 356-minus, width, height);
		buttons[4].setBackground(Color.BLUE);
		buttons[5].setBounds(315, 356-minus, width, height);
		buttons[5].setBackground(Color.PINK);
		buttons[6].setBounds(470, 356-minus, width, height);
		buttons[6].setBackground(Color.BLACK);
		buttons[7].setBounds(625, 356-minus, width, height);
		buttons[7].setBackground(Color.DARK_GRAY);
		for(int i=0;i<buttons.length;i++) {
			buttons[i].setEnabled(false);
			gamePanel.add(buttons[i]);
		}
		
		
		
		int gameHeight = 60,gameWidth=60;
		gamebuttons = new Button[8];
		for(int i=0;i<gamebuttons.length;i++) {
			gamebuttons[i] = new Button(Integer.toString(i+1));
		}
		gamebuttons[0].setBounds(95, 103, gameWidth, gameHeight);
		gamebuttons[0].setBackground(Color.RED);
		gamebuttons[1].setBounds(183, 103, gameWidth, gameHeight);
		gamebuttons[1].setBackground(Color.ORANGE);
		gamebuttons[2].setBounds(271, 103, gameWidth, gameHeight);
		gamebuttons[2].setBackground(Color.YELLOW);
		gamebuttons[3].setBounds(359, 103, gameWidth, gameHeight);
		gamebuttons[3].setBackground(Color.GREEN);
		gamebuttons[4].setBounds(447, 103, gameWidth, gameHeight);
		gamebuttons[4].setBackground(Color.BLUE);
		gamebuttons[5].setBounds(535, 103, gameWidth, gameHeight);
		gamebuttons[5].setBackground(Color.PINK);
		gamebuttons[6].setBounds(623, 103, gameWidth, gameHeight);
		gamebuttons[6].setBackground(Color.BLACK);
		gamebuttons[7].setBounds(711, 103, gameWidth, gameHeight);
		gamebuttons[7].setBackground(Color.DARK_GRAY);
		for(int i=0;i<buttons.length;i++) {
			underPanel.add(gamebuttons[i]);
			gamebuttons[i].setBackground(null);
		}
		
		
		//레벨 표시
		comment = new JLabel("1/3");
		
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
		
		comment.setBounds(410, 40, 150, 50);
		upPanel.add(comment);
		
		//최상위 jFrame 기본 설정
		BoardFrame.setLayout(null);
		BoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardFrame.setSize(WIDTH, HEIGHT);
		BoardFrame.setResizable(false);
		BoardFrame.setVisible(true);
		BoardFrame.add(gamePanel);
		BoardFrame.add(upPanel);
		BoardFrame.add(underPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}