package archeryMatching;

import javax.swing.JLabel;

import juldarigi.background;

public class function {

	public static int moveGreenLight() {
		int location = (int)(Math.random()*3);
		//(179,0) (398, 0) (617,0)
		int[][] xy = {{179,0},{398,0},{618,0}};
		archeryMatching.background.imgGreenArea.setBounds(xy[location][0], xy[location][1], 100, 100);
		return location+1;
	}
	public static void setTimer() {
		archeryMatching.background.timer_width-=1;
		archeryMatching.background.timeBar.setBounds(238, 80, archeryMatching.background.timer_width, 50);
	}
}
