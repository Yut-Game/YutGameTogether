package juldarigi;

public class function {
	public static void moveImage(int value) {
		//사용자(오른쪽으로 이동)
		if(value==0) {
			background.X+=3;
		}
		//로봇(왼쪽으로 이동)
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
			//타이머 초기화
			background.timer_width = 0;
			background.timeBar.setBounds(230, 40, background.timer_width, 50);
			background.timeComment.setText("Computer의 승!");
			return 1;
		}
		else if(background.X > 205) {
			//타이머 초기화
			background.timer_width = 0;
			background.timeBar.setBounds(230, 40, background.timer_width, 50);
			background.timeComment.setText("Player의 승!");
			return 0;
		}
		return -1;
	}
	
}
