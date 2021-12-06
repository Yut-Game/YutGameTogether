package game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndingGame {
	static JFrame jf;
	//게임 창 크기
	public final int WIDTH = 900;
	public final int HEIGHT = 800;
	public final int BOARD_WIDTH = (int) (WIDTH * 0.96);
	public final int BOARD_HEIGHT = (int) (HEIGHT * 0.925);
	static JLabel labels[] = new JLabel[10];
	public static void start() {
		new EndingGame();
	}
	public EndingGame() {
		//최상위 jFrame
		jf = new JFrame();
		//요소 붙일 jPanel
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(10, 10, BOARD_WIDTH, BOARD_HEIGHT);
		jp.setVisible(true);
		jp.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("역대 승패");
		label.setBounds(350, 120,150, 50);
		label.setFont(label.getFont().deriveFont(30.0f));
		jp.add(label);
		JLabel labels[] = new JLabel[10];
		for(int i = 0; i < 10; i++) {
			labels[i] = new JLabel("  승                     패");
			labels[i].setFont(label.getFont().deriveFont(20.0f));
	    }
		JLabel content = new JLabel("player1          player2");
		content.setBounds(320, 180, 500, 50);
		content.setFont(label.getFont().deriveFont(20.0f));
		jp.add(content);
		labels[0].setBounds(350, 150, 150, 50);
		int y = 250;
		for(int i = 0; i < 10; i++) {
			
			labels[i].setBounds(320, y, 300, 50);
			y += 30;
			String st = dbConn.label(i);
			labels[i].setText(st);
			jp.add(labels[i]);
			
//			System.out.println(labels[i]);
	    }
		
		//jp.add(labels[0]);
		//기본 설정
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setSize(WIDTH, HEIGHT);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.add(jp);		
		
	}
	public static void mgps() {
		jf.addMouseMotionListener(new MouseAdapter() { // 마우스 이벤트
			@Override
			public void mouseMoved(MouseEvent e) { // 마우스 움직일때.
				System.out.println(e.getX() + " " + e.getY());// x좌표,y좌표 출력
			}
		});
	}
	public static JLabel[] getLabel() {
		return labels;
	}
	public static JFrame getFrame() {
		return jf;
	}

}
