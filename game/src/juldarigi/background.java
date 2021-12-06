package juldarigi;
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
	
	//�ٴٸ��� �̹��� ���� jLabel
	public static JLabel imgArea;
	//���� ��ư
	public static JButton pullBtn;
	//Ÿ�̸� ǥ��
	public static JLabel timeBar;
	public static int timer_width = 390;
	public static JLabel timeComment;
	
	public background() {
		X = 110;
		//image
		ImageIcon juldarigi = new ImageIcon(background.class.getResource("../img/minigame_juldarigi.jpg"));
		ImageIcon timerImg = new ImageIcon(background.class.getResource("../img/timer.png"));
		//�ֻ��� jFrame ����
		BoardFrame = new JFrame();
		BoardFrame.setTitle("�ٴٸ���");
		//���� ȭ�� jPanel
		gamePanel = new JPanel();
		upPanel = new JPanel();
		underPanel = new JPanel();
		//�ٴٸ��� �̹��� ����
		imgArea = new JLabel();
		//���� ��ư
		pullBtn = new JButton();
		//root
		JRootPane root = BoardFrame.getRootPane();
		root.setDefaultButton(pullBtn);
		//Ÿ�̸�
		timeBar = new JLabel();
		timeComment = new JLabel("���� �ð�");
		
		
		//�⺻ ���̾ƿ� ����
		upPanel.setLayout(null);
		upPanel.setBounds(10, 10, 865, 150);
		upPanel.setBackground(Color.decode("#DFEEFF"));
		upPanel.setBackground(Color.decode("#F5F2DF"));
		gamePanel.setLayout(null);
		gamePanel.setBounds(10, 160, 865, 400);
		gamePanel.setBackground(Color.WHITE);
		underPanel.setLayout(null);
		underPanel.setBounds(10, 560, 865, 190);
		underPanel.setBackground(Color.decode("#DFEEFF"));
		underPanel.setBackground(Color.decode("#F5F2DF"));

		//��ư
		pullBtn.setBackground(new Color(255, 255, 0));
		pullBtn.setBounds(400, 100, 100, 30);
		pullBtn.addActionListener(e -> {
			System.out.println("��ư ����");
			function.moveImage(0);
		});
		pullBtn.setFocusable(true);
		underPanel.add(pullBtn);
		imgArea.setBounds(X, 140, 670, 300);
		gamePanel.add(imgArea);
		//�̹��� ����
		imgArea.setIcon(juldarigi);


		//Ÿ�̸�
		timeComment.setBounds(410, 40,timer_width, 50);
		timeComment.setBounds(400, 40,timer_width, 50);
		upPanel.add(timeComment);
		timeBar.setIcon(timerImg);
		timeBar.setBounds(230,80,390, 50);
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