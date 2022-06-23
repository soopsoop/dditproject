package board;

import java.util.List;

import board.BoardVO;

public interface IBoardDAO {

	
	public int newBoard(BoardVO bv);

	public int editBoard(BoardVO bv);

	public int deleteBoard(int bdNo);

	public List<BoardVO> searchBoard(BoardVO bv);
	
	public List<BoardVO> listUpAll();

	public boolean checkBoard(int bdNo);
	

 
	
	
	
	
	
	
	
	
}
