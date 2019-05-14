package cafe.jjdev.mall.vo;

public class BoardFile {
	private int boardNo;
	private String boardFileOriginName;
	private String boardFileSaveName;
	private String boardFileExt;
	private long boardFileSize;
	private String boardFileType;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardFileOriginName() {
		return boardFileOriginName;
	}
	public void setBoardFileOriginName(String boardFileOriginName) {
		this.boardFileOriginName = boardFileOriginName;
	}
	public String getBoardFileSaveName() {
		return boardFileSaveName;
	}
	public void setBoardFileSaveName(String boardFileSaveName) {
		this.boardFileSaveName = boardFileSaveName;
	}
	public String getBoardFileExt() {
		return boardFileExt;
	}
	public void setBoardFileExt(String boardFileExt) {
		this.boardFileExt = boardFileExt;
	}
	public long getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(long boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
	public String getBoardFileType() {
		return boardFileType;
	}
	public void setBoardFileType(String boardFileType) {
		this.boardFileType = boardFileType;
	}
	@Override
	public String toString() {
		return "BoardFile [boardNo=" + boardNo + ", boardFileOriginName=" + boardFileOriginName + ", boardFileSaveName="
				+ boardFileSaveName + ", boardFileExt=" + boardFileExt + ", boardFileSize=" + boardFileSize
				+ ", boardFileType=" + boardFileType + "]";
	}
	

	
}
