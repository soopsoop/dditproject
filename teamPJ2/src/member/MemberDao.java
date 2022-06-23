package member;

import java.util.List;

import team.board.BoardVO;

public interface MemberDao {

	public int insertMember(MemberVO mv);

	public int deleteMember(String memId);

	public int updateMember(MemberVO mv);

	public List<MemberVO> checkLogin(String memPw);
	
	public boolean checkMember(String memId);
	
	
	
}
