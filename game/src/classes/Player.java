package classes;

public class Player {
	// �� ���� 
	int orFirst;
	// �� ����
	int teamInfo; 
	
	// ���� ���� ��
	int ingPiece; 
	// ������ ��
	int finishPiece; 
	// ���� �� ��
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
