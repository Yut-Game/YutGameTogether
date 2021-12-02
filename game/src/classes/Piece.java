package classes;

public class Piece {
	// 팀 정보
	int teamInfo; 
	// 말 번호
	int pNum; 
	// 좌표
	int x; 
	int y;
	// 출발 전 : -1/ 진행 중 : 0 / 도착 : 1
	int state = -1; 
	// 판 위치
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
