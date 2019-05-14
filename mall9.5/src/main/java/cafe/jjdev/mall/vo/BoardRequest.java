package cafe.jjdev.mall.vo;

import org.springframework.web.multipart.MultipartFile;

// 하나의 테이블에 다른vo 외국서적에 Request라부름
public class BoardRequest {
    private int boardNo;
    private String boardPw;
    private String boardTitle;
    private String boardContent;
    private String boardUser;
    private String boardDate;
    private MultipartFile boardFile;
    
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public MultipartFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile boardFile) {
		this.boardFile = boardFile;
	}
	
	@Override
	public String toString() {
		return "BoardRequest [boardNo=" + boardNo + ", boardPw=" + boardPw + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardUser=" + boardUser + ", boardDate=" + boardDate
				+ ", boardFile=" + boardFile + "]";
	}
    
    
    
}
