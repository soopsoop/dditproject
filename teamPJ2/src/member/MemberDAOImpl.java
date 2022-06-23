package member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import team.board.BoardVO;
import team.util.JDBCUtil3;
import team.util.MybatisUtil;

public class MemberDAOImpl implements MemberDao{
	
	private static MemberDao memberDao;
	private SqlSession sqlSession;
	
	public MemberDAOImpl() {
		sqlSession = MybatisUtil.getInstance();
	}
	
	public static MemberDao getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDAOImpl();
		}
		
		return memberDao;
	}
	
	
	@Override
	public int insertMember(MemberVO mv) {

		int cnt = sqlSession.insert("member.insertMember",mv);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		int cnt = sqlSession.delete("member.deleteMember", memId);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {

		int cnt = sqlSession.update("member.deleteMember", mv);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> checkLogin(String memPw) {
		
		List<MemberVO> memberList = sqlSession.selectList(memPw);
		
		return memberList;

		
	}

	@Override
	public boolean checkMember(String memId) {

	boolean isExist = false;
		
		int cnt = (int) sqlSession.selectOne("member.checkMember", memId);
		
		if(cnt > 0 ) {
			
			isExist = true;
	}
		
		return false;
	}
	
	
}