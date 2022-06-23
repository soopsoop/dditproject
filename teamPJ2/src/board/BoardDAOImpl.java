package board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.BoardVO;
import kr.or.ddit.util.JDBCUtil3;
import kr.or.ddit.util.MybatisUtil;

public class BoardDAOImpl implements IBoardDAO{
	
	private static IBoardDAO boardDao;
	private SqlSession sqlSession;
	
	public BoardDAOImpl() {
		sqlSession = MybatisUtil.getInstance();
	}
	
	public static IBoardDAO getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDAOImpl();			
		}
		
		return boardDao;
	}
	
	@Override
	public int newBoard(BoardVO bv) {

		int cnt = sqlSession.insert("board.newBoard",bv);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
	
		return cnt;
	}

	@Override
	public int editBoard(BoardVO bv) {
		
		int cnt = sqlSession.update("board.editBoard", bv);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
	
		return cnt;
	}
	

	@Override
	public int deleteBoard(int bdNo) {
		
		int cnt = sqlSession.delete("board.deleteBoard", bdNo);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
	
		return cnt;
	}

	
	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> bdList = sqlSession.selectList("board.searchBoard", bv);
		
		return bdList;
	}
	
		

	@Override
	public List<BoardVO> listUpAll() {

		List<BoardVO> bdList = sqlSession.selectList("board.listUpAll");
		
		return bdList;
	}
	

	@Override
	public boolean checkBoard(int bdNo) {

		boolean isExist = false;
		
		int cnt = (int) sqlSession.selectOne("board.checkBoard", bdNo);
		
		if(cnt > 0 ) {
			isExist = true;
	}

		return false;
}
}