package archeryMatching;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import juldarigi.background;
import juldarigi.function;

public class execute {
	
	static int answer;
	private static int point = 0;
	static int i;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new archeryMatching.background();
		
		Timer timer = new Timer(50, new ActionListener() {  
			public void actionPerformed (ActionEvent e) {
				i++;
				if(i%10==0) {
					answer = archeryMatching.function.moveGreenLight();
				}
				archeryMatching.function.setTimer();	
			}
		});
		//Ÿ�̸� ����
		timer.start();
		//���ѽð� 20��
		try{
			Thread.sleep(24500);
		} catch(Exception e){}
		timer.stop();
		archeryMatching.background.btn1.setEnabled(false);
		archeryMatching.background.btn2.setEnabled(false);
		archeryMatching.background.btn3.setEnabled(false);
		if(point>15) {
			JOptionPane.showMessageDialog(null, "���� : "+point+"��\n���ӽ¸�!");
		} else {
			JOptionPane.showMessageDialog(null, "���� : "+point+"��\n���ӿ���!");
		}
	}
	
	public static void addPoint() {
		point++;
		archeryMatching.background.timeComment.setText("POINT : "+point);
	}

}
