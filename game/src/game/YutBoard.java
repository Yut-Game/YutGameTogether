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

	//���� â ũ��
	public static final int WIDTH = 900;
	public static final int HEIGHT = 800;
	//�������� ũ��
	public final int BOARD_WIDTH = (int) (WIDTH*0.61);
	public final int BOARD_HEIGHT = (int) (HEIGHT*0.69);
	
	
	//�ֻ��� jFrame
	public static JFrame BoardFrame;
	//�������� ���� jPanel
	private JPanel yutBoardPanel;
	//�� ���� jPanel
	private JPanel YutPanel;
	//���� ���� jPanel
	private JPanel rightArea;	
	//(����) �����1 ����
	private JLabel userOneProgress;
	//(����) �����2 ����
	private JLabel userTwoProgress;
	//(����) �������� ��ư
	private JButton throwYut;
	//(����) �� �̵� ������ ��ư
	private JButton[] movingMal;
	
	
	//(���) ū ��
	ImageIcon bigCircle = new ImageIcon("../img/bigCircle.png");
	//(���) ���� ��
	ImageIcon smallCircle = new ImageIcon("../img/smallCircle.png");
	
			
	
	public YutBoard() {
		BoardFrame = new JFrame();
		BoardFrame.setTitle("Card Of Yut");
		//(����) �������� ����
		yutBoardPanel = new JPanel() {
			Image background=new ImageIcon(YutBoard.class.getResource("../img/yutpan.png")).getImage();
			public void paint(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		//(����) �� ����
		YutPanel = new JPanel();
		//���� ���� jPanel
		rightArea = new JPanel();		
		//(����) �����1 ����
		userOneProgress = new JLabel("����� 1 ���� �� �� ǥ��");
		//(����) �����2 ����
		userTwoProgress = new JLabel("����� 2 ���� �� �� ǥ��");
		//(����) �� �̵� ������ ��ư
		movingMal = new JButton[3];
		
		//test
		JButton button = new JButton(bigCircle); 
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		yutBoardPanel.add(button); 		
		
		//(���̾ƿ� ����) ��������, �� ��ġ
		yutBoardPanel.setBounds(10,10,BOARD_WIDTH,BOARD_HEIGHT);
		yutBoardPanel.setBackground(Color.WHITE);
		YutPanel.setBounds(10, BOARD_HEIGHT+20, BOARD_WIDTH, HEIGHT-BOARD_HEIGHT-70);
		YutPanel.setBackground(Color.WHITE);
		rightArea.setBounds(BOARD_WIDTH+20, 10, WIDTH-BOARD_WIDTH-50,  HEIGHT-60);
		rightArea.setBackground(Color.WHITE);
		//(���̾ƿ� ����) ����� ����, �� ��ư ��ġ
		rightArea.add(userOneProgress);
		rightArea.add(userTwoProgress);
		
		
		//�� ������ ��ư
		throwYut = new JButton("�� ������");
		throwYut = createBoardBtn(throwYut,WIDTH/20*9,WIDTH/20*10,WIDTH/20*3,WIDTH/20,true);
		throwYut.setBackground(new Color(255,255,0));
		throwYut.addActionListener(e->{
			rule r = new rule();
		});
		rightArea.add(throwYut);
		
		//�� ���� ��ư
		for(int i=0;i<3;i++) {
			movingMal[i] = new JButton((i+1)+"�� �� �̵�");
			movingMal[i] = createBoardBtn(movingMal[i],WIDTH/20*9,WIDTH/20*10,WIDTH/20*3,WIDTH/20,true);
			movingMal[i].setBackground(new Color(255,255,0));
			rightArea.add(movingMal[i]);
		}


		//�ֻ��� jFrame �⺻ ����
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
	
	public void paint(Graphics g,Image yut) {// �׸��� �Լ�
		g.drawImage(yut, 0, 0, null);// background�� �׷���
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
