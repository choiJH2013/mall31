package cafe.jjdev.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.BoardComment;

@Mapper
public interface BoardCommentMapper {
	public int insertBoardComment(BoardComment boardComment);
	public List<BoardComment> selectBoardCommentListByBoardNo(int boardNo);
	public int deleteBoardCommentByCommentNo(int boardCommentNo);
	public int deleteBoardCommentByBoardNo(int boardNo);
}
