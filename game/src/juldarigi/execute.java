package juldarigi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class execute {

	public static int countdown;
	
	
	public static void main(String[] args) {
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
				}
				countdown-=100;
				System.out.println(countdown/10+"����");
			}
		});
		
		
		
		//Ÿ�̸� ����
		timer.start();

		 

		//���ѽð�
		try{
			Thread.sleep(15000);
		} catch(Exception e){}
		timer.stop();
		//�ð��ʰ��� ��Ȱ
		background.pullBtn.setEnabled(false);
		
	}

}
