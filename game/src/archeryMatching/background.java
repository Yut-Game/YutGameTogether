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
	private JFrame BoardFrame;	
	//���� ���� jPanel
	private JPanel explainPanel; 
	
	//��� ���� jPanel
	private JPanel upPanel;
	//�߾� ���� jPanel
	private JPanel gamePanel;
	//�ϴ� ���� jPanel
	private JPanel underPanel;
	
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
	
	public background() {
		X = 110;
		//image
		ImageIcon backImg = new ImageIcon(background.class.getResource("../img/archeryBackground.png"));
		ImageIcon timerImg = new ImageIcon(background.class.getResource("../img/timer.png"));
		ImageIcon greenLight = new ImageIcon(background.class.getResource("../img/greenLight.png"));
		//�ֻ��� jFrame ����
		BoardFrame = new JFrame();
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
		upPanel.setLayout(null);
		upPanel.setBounds(10, 10, 865, 150);
		upPanel.setBackground(Color.decode("#F5F2DF"));
		gamePanel.setLayout(null);
		gamePanel.setBounds(10, 160, 865, 400);
		gamePanel.setBackground(Color.WHITE);
		underPanel.setLayout(null);
		underPanel.setBounds(10, 560, 865, 190);
		underPanel.setBackground(Color.decode("#F5F2DF"));
		
		//��ư
		btn1.setBounds(162, 50, 100, 100);
		btn1.addActionListener(e -> {
			if(execute.answer==1) execute.addPoint();
		});
		btn1.setFocusable(true);
		underPanel.add(btn1);
		
		//��ư
		btn2.setBounds(383, 50, 100, 100);
		btn2.addActionListener(e -> {
			if(execute.answer==2) execute.addPoint();
		});
		btn2.setFocusable(true);
		underPanel.add(btn2);
		
		//��ư
		btn3.setBounds(604, 50, 100, 100);
		btn3.addActionListener(e -> {
			if(execute.answer==3) execute.addPoint();
		});
		btn3.setFocusable(true);
		underPanel.add(btn3);
		
		//�̹���
		imgArea.setBounds(0, 0, 865, 400);
		imgArea.setIcon(backImg);
		//(179,0) (398, 0) (617,0)
		imgGreenArea.setBounds(617, 0,100,100);
		imgGreenArea.setIcon(greenLight);
		gamePanel.add(imgGreenArea);
		gamePanel.add(imgArea);

		
		//Ÿ�̸�
		timeComment.setBounds(400, 40,timer_width, 50);
		upPanel.add(timeComment);
		timeBar.setIcon(timerImg);
		timeBar.setBounds(238,80,390, 50);
		upPanel.add(timeBar);

		
		//�ֻ��� jFrame �⺻ ����
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