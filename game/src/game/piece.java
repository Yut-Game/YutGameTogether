package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class piece {
	static JPanel rightA;
	private static JButton p1P0;
	private static JButton p1P1;
	private static JButton p1P2;
	private static JButton p2P0;
	private static JButton p2P1;
	private static JButton p2P2;
	
	piece(JPanel rightA){
		this.rightA = rightA;
		
	}
	public static void createBtn() {
		p1P0 = new JButton();
		p1P1  = new JButton();
		p1P2 = new JButton();
		p2P0 = new JButton();
		p2P1  = new JButton();
		p2P2 = new JButton();
		
		p1P0.setBounds(80, 65, 30, 30);
		p1P1.setBounds(135, 65, 30, 30);
		p1P2.setBounds(190, 65, 30, 30);
		p2P0.setBounds(80, 155, 30, 30);
		p2P1.setBounds(135, 155, 30, 30);
		p2P2.setBounds(190, 155, 30, 30);
		
		rightA.add(p1P0);
		rightA.add(p1P1);
		rightA.add(p1P2);
		rightA.add(p2P0);
		rightA.add(p2P1);
		rightA.add(p2P2);
	}
	public static void clickBtn() {
        p1P0.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("p1P0");
			}
		});
        p1P1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("p1P1");
			}
		});
        p1P2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("p1P2");
			}
		});
        p2P0.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("p1P0");
			}
		});
        p2P1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("p1P1");
			}
		});
        p2P2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("p1P2");
			}
		});
	}
}
