package classes;

public class Piece {
	// �� ����
	int teamInfo; 
	// �� ��ȣ
	int pNum; 
	// �� ��ȣ ����
	int changeNum;
	// ���� �� (�⺻ 1)
	int carry = 1;
	// ��ǥ
	int x; 
	int y;
	// ��� �� : -1/ ���� �� : 0 / ���� : 1
	int state = -1; 
	// �� ��ġ
	int location;
	
	public Piece(int i, int n, int loc){
		teamInfo= i;
		pNum = n;
		changeNum = n;
		location = loc;
	}
	public int getState() {
		return state;
	}
	public void setState(int s) {
		state = s;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getChangeNum() {
		return changeNum;
	}
	public void setChangeNum(int changeNum) {
		this.changeNum = changeNum;
	}
	public int getCarry() {
		return carry;
	}
	public void setCarry(int carry) {
		this.carry = carry;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
