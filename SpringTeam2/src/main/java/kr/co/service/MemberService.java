package kr.co.service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberVO;

public interface MemberService {
	MemberVO login(LoginDTO dto);


}
