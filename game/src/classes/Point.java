package classes;

public class Point {
	private int num;
	private int x;
	private int y;
	
	public Point(int num,int x,int y){
		this.num = num;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void addCordinate(int x,int y) {
		this.x += x;
		this.y += y;
	}
	
	
}
