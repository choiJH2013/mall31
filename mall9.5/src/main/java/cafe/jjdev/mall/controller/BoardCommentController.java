package cafe.jjdev.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.jjdev.mall.service.BoardCommentService;
import cafe.jjdev.mall.vo.BoardComment;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;
	
	@PostMapping(value="/board/addBoardComment")
	public String addBoardComment(BoardComment boardComment) {
		int result = boardCommentService.addBoardComment(boardComment);
		
		System.out.println("result 에 담아놓고 사용도안하는데 왜담은걸까 ...");
		
		return "redirect:/board/getBoard?boardNo="+boardComment.getBoardNo();
	}
}
