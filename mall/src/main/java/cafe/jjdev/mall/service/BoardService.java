package cafe.jjdev.mall.service;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.mall.commons.PathStr;
import cafe.jjdev.mall.mapper.BoardCommentMapper;
import cafe.jjdev.mall.mapper.BoardFileMapper;
import cafe.jjdev.mall.mapper.BoardMapper;
import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;
import cafe.jjdev.mall.vo.BoardFile;
import cafe.jjdev.mall.vo.BoardRequest;

@Service
@Transactional
public class BoardService {
	@Autowired private BoardMapper boardMapper;
	@Autowired private BoardCommentMapper boardCommentMapper;
	@Autowired private BoardFileMapper boardFileMapper;
	
	public Map<String, Object> getBoardAndCommentListAndFile(int boardNo) {
		//1 보드
		Board board = boardMapper.selectBoard(boardNo);
		//2 댓글
		List<BoardComment> boardCommentList = boardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
		//3. 파일
		BoardFile boardFile = boardFileMapper.selectBoardFile(boardNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardFile", boardFile);
		map.put("board", board);
		map.put("boardCommentList", boardCommentList);
		return map;
	}
	
	public Map<String, Object> getBoard(int boardNo) {
		
		Board board = boardMapper.selectBoard(boardNo);
		BoardFile boardFile = boardFileMapper.selectBoardFile(boardNo);
		System.out.println("■board■"+board);
		System.out.println("■boardFile■"+boardFile);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("boardFile", boardFile);
		return map;
	}
	
	public Map<String, Object> getBoardList(int currentPage) {
		final int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE; 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		List<Board> list = boardMapper.selectBoardList(map);
		int boardCount = boardMapper.selectBoardCount();
		
		int lastPage = boardCount/ROW_PER_PAGE;
		
		if(boardCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("boardCount", boardCount);
		return returnMap;
	}
	
	
	public int modifyBoard(Board board) {
		return boardMapper.updateBoard(board);
	}
	
	public void addBoard(BoardRequest boardRequest, String path) {
		
		// 1. BoardRequest에서 -> Board
		Board board = new Board();
		board.setBoardPw(boardRequest.getBoardPw());
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		board.setBoardUser(boardRequest.getBoardUser());
		board.setBoardDate(boardRequest.getBoardDate());
		System.out.println("[cafe.jjdev.mall.service BoardService] board "+board);
		boardMapper.insertBoard(board); // board.setBoardNo(auto값); 입력이되고나서 쿼리가실행되고나서 board넘버값을 채울수가있따 그래보 보드.겟보드넘버를 추출할수있게되었다. 밑에 파일쪽에서 써먹음
		
		// 2. BoardRequest -> MultipartFile(boardFile)
		
		//파일첨부에 값이 있을경우 파일첨부 ㄱㄱ
		MultipartFile multipartFile = boardRequest.getBoardFile();
		
		if(multipartFile.getSize() != 0) {
			
		String originFileName = multipartFile.getOriginalFilename();
		// aaa.war
		//String 과관련된 기본 API는 알자
		int i = originFileName.lastIndexOf(".");
		String originName = originFileName.substring(0, i);
		String ext = originFileName.substring(i+1).toLowerCase(); //toLowerCase(); 대소문자
		UUID uuid = UUID.randomUUID();
		String saveName = uuid.toString();//String saveName = uuid.toString().reqlace("-","");

		System.out.println("[cafe.jjdev.mall.service BoardService] multipartFile "+multipartFile);
		System.out.println(multipartFile.getContentType()); //text/plain
		System.out.println(multipartFile.getName()); //boardFile
		System.out.println(multipartFile.getOriginalFilename()); //0502test.txt
		System.out.println(multipartFile.getSize()); //4
		System.out.println(multipartFile.getClass()); //class org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile
		System.out.println(multipartFile.getResource()); //MultipartFile resource [boardFile]
		System.out.println(multipartFile.toString()); //org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@39c58ff8
		
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardFileSize(multipartFile.getSize());
		boardFile.setBoardFileType(multipartFile.getContentType());
		boardFile.setBoardFileOriginName(originName);
		boardFile.setBoardFileSaveName(saveName);
		boardFile.setBoardFileExt(ext);	
		boardFile.setBoardNo(board.getBoardNo());
		System.out.println("--------------------------------------------path : "+path);
		
		// boardFile.setBoardNo(board.getBoardNo()); 
		System.out.println("[service BoardService] boardFile " + boardFile);
		// 파일은 폴더에 저장    테이블에는 파일경로만
		//String path = "D:\\jjdev\\sts_workspace\\mall5.7\\src\\main\\resources\\static\\upload\\"; // c:/temp 이렇게해도  OS가 윈도우네? 알아서 c:\\temp이렇게바꿔서 쫒아간다 
		File file = new File(path+"/"+saveName+"."+ext);
		//서비스쪽은 무조건 예외가 나야한다
		//모든개발자들은 예외처리 불만이 많다

		 //파일업로드 메서드 호출
		try {
			multipartFile.transferTo(file); //
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
			throw new RuntimeException(); //catch에서 갇히니까 런타임입셉션 일부로 예외발생시켜서 트랜잭션발생시켜 취소시킨다 
			//이부분을 좀더 파헤쳐보고 실험해보자
			//throw 인위적으로 예외를 발생시키는것 
			//throws 예외를 밖으로 던지는것
		}//catch닫힘
		boardFileMapper.insertBoardFile(boardFile);	
		//예외는 쓰로우에서 인섭션과  ? 구분되고 인셉션에서도 일반과 런타임익셉션으로 구분된다.
		//예외는 2가지 런타임 익셉션예외 체크익셉션예외 
		//db에 저장 파일저장
		}//if닫힘
	}//addBoard메서드 닫힘

/*
 * static 저장파일
 * 
 * css img jsp
 */


//삭제처리
	public void removeBoard(Board board) {
		int commentResult = boardCommentMapper.deleteBoardCommentByBoardNo(board.getBoardNo());

			//쿼리문 결과값 담기위해	  select쿼리문 사용하기위해
			BoardFile boardFile = boardFileMapper.selectBoardFile(board.getBoardNo());

			if(boardFile != null) {
				String ext = boardFile.getBoardFileExt();
				String saveName = boardFile.getBoardFileSaveName();
				
				//파일업로드 경로를 가져옴
				String path = PathStr.UPLOAD_PATH;
				
		        File file = new File(path+"/"+saveName+"."+ext); 
		        
		        if( file.exists() ){ // true or false 리턴
		            if(file.delete()){
		                System.out.println("파일삭제 성공");
		            }else{
		                System.out.println("파일삭제 실패");
		            }
		        }else{
		            System.out.println("파일이 존재하지 않습니다.");
		        }
			}       
			
		//리턴을 받았으나 쓸떄가 없다...
		int FileResult = boardFileMapper.deleteFile(board.getBoardNo());
		int boardResult = boardMapper.deleteBoard(board);
	}

	
}
