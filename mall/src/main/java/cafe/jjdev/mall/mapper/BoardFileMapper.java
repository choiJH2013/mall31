package cafe.jjdev.mall.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.BoardFile;

@Mapper
public interface BoardFileMapper {
	public int insertBoardFile(BoardFile boardFile);
	public BoardFile selectBoardFile(int boardNo);
	public int deleteFile(int boerdNo);

}
