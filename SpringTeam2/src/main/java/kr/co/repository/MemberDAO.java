package kr.co.repository;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberVO;

public interface MemberDAO {
	MemberVO login(LoginDTO dto);
}
