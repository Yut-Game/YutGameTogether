package juldarigi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class execute {

	public static int countdown;
	private static boolean isEnd;
	
	public static void main(String[] args) {
		isEnd = false;		
		//게임 진행 화면
		new background();
		countdown = 15000;
		
		Timer timer = new Timer(100, new ActionListener() {  
			public void actionPerformed (ActionEvent e) {
				function.moveImage(1);
				function.setTimer();
				int result = function.checkWin();
				if(result==0 || result==1) {
					background.pullBtn.setEnabled(false);
					((Timer)e.getSource()).stop();
					isEnd = true;
					endGame(result);
				}
				countdown-=100;
			}
		});
		//타이머 시작
		timer.start();
		//제한시간
		try{
			Thread.sleep(14800);
		} catch(Exception e){}
		timer.stop();
		if(!isEnd) {
			endGame(0);
			//시간초과시 비활
			background.pullBtn.setEnabled(false);
		}

	}
	
	public static void endGame(int winner) {
		String comment="";
		if(winner==1) comment="Computer의 승!\n윷놀이 화면으로 돌아갑니다.";
		else if(winner==2) comment="Player의 승!\n윷놀이 화면으로 돌아갑니다.";
		else comment="무승부입니다!\n윷놀이 화면으로 돌아갑니다.";
		JOptionPane.showMessageDialog(null, comment);
	}

}
