package classes;

public class Player {
	// 선 여부 
	int orFirst;
	// 팀 정보
	int teamInfo; 
	
	// 진행 중인 말
	int ingPiece; 
	// 도착한 말
	int finishPiece; 
	// 시작 전 말
	int readyPiece = 3;

	public int getIngPiece() {
		return ingPiece;
	}
	public void setIngPiece(int ingPiece) {
		this.ingPiece = ingPiece;
	}
	public int getFinishPiece() {
		return finishPiece;
	}
	public void setFinishPiece(int finishPiece) {
		this.finishPiece = finishPiece;
	}
	public int getReadyPiece() {
		return readyPiece;
	}
	public void setReadyPiece(int readyPiece) {
		this.readyPiece = readyPiece;
	} 
}
