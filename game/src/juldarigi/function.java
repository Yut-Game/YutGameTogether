package juldarigi;

public class function {
	public static void moveImage(int value) {
		//�����(���������� �̵�)
		if(value==0) {
			background.X+=3;
		}
		//�κ�(�������� �̵�)
		else if(value == 1) {
			background.X--;
		}
		background.imgArea.setBounds(background.X, 140, 670, 300);
	}
	
	public static void setTimer() {
		background.timer_width-=2.01;
		background.timeBar.setBounds(230, 40, background.timer_width, 50);
	}
	
	public static int checkWin() {
		System.out.println("X ----> "+background.X);
		if(background.X < 35) {
			//Ÿ�̸� �ʱ�ȭ
			background.timer_width = 0;
			background.timeBar.setBounds(230, 40, background.timer_width, 50);
			background.timeComment.setText("Computer�� ��!");
			return 1;
		}
		else if(background.X > 205) {
			//Ÿ�̸� �ʱ�ȭ
			background.timer_width = 0;
			background.timeBar.setBounds(230, 40, background.timer_width, 50);
			background.timeComment.setText("Player�� ��!");
			return 0;
		}
		return -1;
	}
	
}
