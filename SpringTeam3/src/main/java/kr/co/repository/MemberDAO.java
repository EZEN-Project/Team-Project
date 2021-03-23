package kr.co.repository;

import java.util.List;
import java.util.Map;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberVO;

public interface MemberDAO {
	
	MemberVO read(String id);
	
	MemberVO readM(int mnum);

	int insert(MemberVO memberVO);

	MemberVO login(LoginDTO loginDTO);

	void update(MemberVO vo);

	int updatePoint(int point, String memo, int mnum);
	
	void updateMType(MemberVO vo);
	MemberVO readMember(String id);

	int tempPw(MemberVO vo);
	List<String> findid(String email) throws Exception;

	void updatepw(Map<String, Object> map);
	
}
