package classes;

public class Piece {
	// 팀 정보
	int teamInfo; 
	// 말 번호
	int pNum; 
	// 좌표
	int x; 
	int y;
	// 출발 전 / 진행 중 / 도착
	int state; 
	// 판 위치
	int location;
	
	public Piece(int i, int n){
		i = teamInfo;
		n = pNum;
	}
}
