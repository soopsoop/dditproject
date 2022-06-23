package board;

import java.util.List;

class BoardServiceImpl implements IBoardService{

	private IBoardDAO boardDao;
	
	private static IBoardService boardService;
	
	
	public BoardServiceImpl() {
		
		boardDao = BoardDAOImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		
		return boardService;
	}
	

	@Override
	public int registerBoard(BoardVO bv) {

		int cnt = boardDao.newBoard(bv);
		
		return cnt;
		
	}

	@Override
	public int editBoard(BoardVO bv) {
		
		int cnt = boardDao.editBoard(bv);
		
		return cnt;
	}

	@Override
	public int deleteBoard(int bdNo) {
		
		int cnt = boardDao.deleteBoard(bdNo);
		
		return cnt;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> bdList = boardDao.searchBoard(bv);
		
		return bdList;
	}

	@Override
	public List<BoardVO> listUpAll() {
		
		List<BoardVO> bdList = boardDao.listUpAll();
		
		return bdList;
	}

	@Override
	public boolean checkBoard(int bdNo) {
		
		boolean isExist = boardDao.checkBoard(bdNo);
		
		return isExist;
	}

}
