package archeryMatching;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
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
	//ùȭ���� ���� ����
	//7�� �� ���� ���� vs Ű�Է½� ���� ����

	//���� â ũ��
	public final int WIDTH = 900;
	public final int HEIGHT = 800;
	public final int BOARD_WIDTH = (int) (WIDTH * 0.96);
	public final int BOARD_HEIGHT = (int) (HEIGHT * 0.925);
	
	//�̹��� x��ǥ
	public static int X;
	
	//�ֻ��� jFrame
	public static JFrame BoardFrame;	
	//���� ���� jPanel
	private JPanel explainPanel; 
	
	//��� ���� jPanel
	private static JPanel upPanel;
	//�߾� ���� jPanel
	private static JPanel gamePanel;
	//�ϴ� ���� jPanel
	private static JPanel underPanel;
	
	//�̹��� ���� jLabel
	public static JLabel imgArea;
	public static JLabel imgGreenArea;
	//Ÿ�̸� ǥ��
	public static JLabel timeBar;
	public static int timer_width = 390;
	public static JLabel timeComment;

	
	
	public static Button btn1;
	public static Button btn2;
	public static Button btn3;
	
	//���� ���� ���
	static int answer;
	private static int point = 0;
	static int count = 0;
	
	
	public static void endGame() {
		if(point>15) {
			JOptionPane.showMessageDialog(null, "���� : "+point+"��\n���ӽ¸�!");
		} else {
			JOptionPane.showMessageDialog(null, "���� : "+point+"��\n���ӿ���!");
		}
	}
	
	public static void start() {
		// TODO Auto-generated method stub
		new archeryMatching.background();
		
		btn1.setVisible(true);
		btn2.setVisible(true);
		btn3.setVisible(true);
		upPanel.setVisible(true);
		gamePanel.setVisible(true);
		underPanel.setVisible(true);
		BoardFrame.setVisible(true);
		
	
		
		Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {

           @Override
           public void run() {
              if(count<=55) {
                 System.out.println(count);
                 count++;
                 if(count%3==0) answer = archeryMatching.function.moveGreenLight();
                 archeryMatching.function.setTimer();
              }
              else {
                 timer.cancel();
                 btn1.setEnabled(false);
                 btn2.setEnabled(false);
                 btn3.setEnabled(false);
                 endGame();
                 BoardFrame.dispose();
                 YutBoard.BoardFrame.setVisible(true);
              }
           }
        };
        timer.scheduleAtFixedRate(task, 1000, 330);
		
	}
	
	public static void addPoint() {
		point++;
		archeryMatching.background.timeComment.setText("POINT : "+point);
	}
	
	
	public background() {
		X = 110;
		//image
		ImageIcon backImg = new ImageIcon(background.class.getResource("../img/archeryBackground.png"));
		ImageIcon timerImg = new ImageIcon(background.class.getResource("../img/timer.png"));
		ImageIcon greenLight = new ImageIcon(background.class.getResource("../img/greenLight.png"));
		//�ֻ��� jFrame ����
		BoardFrame = new JFrame();
		Container c1 = BoardFrame.getContentPane();
		BoardFrame.setTitle("������߱�");
		//���� ȭ�� jPanel
		gamePanel = new JPanel();
		upPanel = new JPanel();
		underPanel = new JPanel();
		//�̹��� ����
		imgArea = new JLabel();
		imgGreenArea = new JLabel();
		//Ÿ�̸�
		timeBar = new JLabel();
		timeComment = new JLabel("POINT : 0");
		//ȭ�쳯���� ��ư
		btn1 = new Button();
		btn2 = new Button();
		btn3 = new Button();
		
		//�⺻ ���̾ƿ� ����
		upPanel.setVisible(false);
		upPanel.setLayout(null);
		upPanel.setBounds(10, 10, 865, 150);
		upPanel.setBackground(Color.decode("#F5F2DF"));
		gamePanel.setVisible(false);
		gamePanel.setLayout(null);
		gamePanel.setBounds(10, 160, 865, 400);
		gamePanel.setBackground(Color.WHITE);
		underPanel.setVisible(false);
		underPanel.setLayout(null);
		underPanel.setBounds(10, 560, 865, 190);
		underPanel.setBackground(Color.decode("#F5F2DF"));
		
		//��ư
		btn1.setVisible(false);
		btn1.setBounds(162, 50, 100, 100);
		btn1.addActionListener(e -> {
			if(answer==1) addPoint();
		});
		btn1.setFocusable(true);
		underPanel.add(btn1);
		
		//��ư
		btn2.setVisible(false);
		btn2.setBounds(383, 50, 100, 100);
		btn2.addActionListener(e -> {
			if(answer==2) addPoint();
		});
		btn2.setFocusable(true);
		underPanel.add(btn2);
		
		//��ư
		btn3.setVisible(false);
		btn3.setBounds(604, 50, 100, 100);
		btn3.addActionListener(e -> {
			if(answer==3) addPoint();
		});
		btn3.setFocusable(true);

		
		//�̹���
		imgArea.setBounds(0, 0, 865, 400);
		imgArea.setIcon(backImg);
		//(179,0) (398, 0) (617,0)
		imgGreenArea.setBounds(617, 0,100,100);
		imgGreenArea.setIcon(greenLight);


		
		//Ÿ�̸�
		timeComment.setBounds(400, 40,timer_width, 50);

		timeBar.setIcon(timerImg);
		timeBar.setBounds(238,80,390, 50);
		

		
		//�ֻ��� jFrame �⺻ ����
		BoardFrame.setLayout(null);
		BoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardFrame.setLocationRelativeTo(null);
		BoardFrame.setSize(WIDTH, HEIGHT);
		BoardFrame.setResizable(false);
		BoardFrame.setVisible(false);
		setLocationRelativeTo(null);
		underPanel.add(btn3);
		gamePanel.add(imgGreenArea);
		gamePanel.add(imgArea);
		upPanel.add(timeComment);
		upPanel.add(timeBar);
		
		c1.add(underPanel);
		c1.add(gamePanel);
		c1.add(upPanel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}