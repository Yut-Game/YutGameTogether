package classes;

public class Piece {
	// �� ����
	int teamInfo; 
	// �� ��ȣ
	int pNum; 
	// ��ǥ
	int x; 
	int y;
	// ��� �� : -1/ ���� �� : 0 / ���� : 1
	int state = -1; 
	// �� ��ġ
	int location;
	
	public Piece(int i, int n, int loc){
		i = teamInfo;
		n = pNum;
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
	
}
