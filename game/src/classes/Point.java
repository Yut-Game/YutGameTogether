package classes;

public class Point {
	private int num;
	private int x;
	private int y;
	private int minigame;
	
	public Point(int num,int x,int y){
		this.num = num;
		this.x = x;
		this.y = y;
		this.minigame = 0;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getMinigame() {
		return minigame;
	}
	public void setMinigame(int value) {
		this.minigame = value;
	}
	
	public void addCordinate(int x,int y) {
		this.x += x;
		this.y += y;
	}
	
	
}
