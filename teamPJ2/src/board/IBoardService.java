package board;

import java.util.List;

public interface IBoardService {

	public int registerBoard(BoardVO bv);

	public int editBoard(BoardVO bv);

	public int deleteBoard(int bdNo);

	public List<BoardVO> searchBoard(BoardVO bv);
	
	public List<BoardVO> listUpAll();

	public boolean checkBoard(int bdNo);
	
}
