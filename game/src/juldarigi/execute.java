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
		//���� ���� ȭ��
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
		//Ÿ�̸� ����
		timer.start();
		//���ѽð�
		try{
			Thread.sleep(14800);
		} catch(Exception e){}
		timer.stop();
		if(!isEnd) {
			endGame(0);
			//�ð��ʰ��� ��Ȱ
			background.pullBtn.setEnabled(false);
		}

	}
	
	public static void endGame(int winner) {
		String comment="";
		if(winner==1) comment="Computer�� ��!\n������ ȭ������ ���ư��ϴ�.";
		else if(winner==2) comment="Player�� ��!\n������ ȭ������ ���ư��ϴ�.";
		else comment="���º��Դϴ�!\n������ ȭ������ ���ư��ϴ�.";
		JOptionPane.showMessageDialog(null, comment);
	}

}
