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
		//타이머 시작
		timer.start();
		//제한시간 20초
		try{
			Thread.sleep(24500);
		} catch(Exception e){}
		timer.stop();
		archeryMatching.background.btn1.setEnabled(false);
		archeryMatching.background.btn2.setEnabled(false);
		archeryMatching.background.btn3.setEnabled(false);
		if(point>15) {
			JOptionPane.showMessageDialog(null, "점수 : "+point+"점\n게임승리!");
		} else {
			JOptionPane.showMessageDialog(null, "점수 : "+point+"점\n게임오버!");
		}
	}
	
	public static void addPoint() {
		point++;
		archeryMatching.background.timeComment.setText("POINT : "+point);
	}

}
