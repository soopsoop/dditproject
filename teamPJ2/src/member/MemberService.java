package member;

import java.util.List;

public interface MemberService {

	public int insertMember(MemberVO mv);

	public int deleteMember(String memId);

	public int updateMember(MemberVO mv);

	public List<MemberVO> checkLogin(String memPw);
	
	public boolean checkMember(String memId);
	
	
	
}
