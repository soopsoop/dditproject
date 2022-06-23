package member;

import java.util.List;

class MemberServiceImpl implements MemberService{

	private MemberDao memberDao;
	
	private static MemberService memberService;
	
	
	public MemberServiceImpl() {
		
		memberDao = MemberDAOImpl.getInstance();
	}
	
	public static MemberService getInstance() {
		if(memberService == null) {
			memberService = new MemberServiceImpl();
		}
		
		return memberService;
	}

	@Override
	public int insertMember(MemberVO mv) {

		int cnt = memberDao.insertMember(mv);
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		int cnt = memberDao.deleteMember(memId);
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {

		int cnt = memberDao.updateMember(mv);
		
		return 0;
	}


	@Override
	public List<MemberVO> checkLogin(String memPw) {

		List<MemberVO> memberList = memberDao.checkLogin(memPw);
		
		return memberList;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean isExist = memberDao.checkMember(memId);
		
		return false;
	}
	

	

}
