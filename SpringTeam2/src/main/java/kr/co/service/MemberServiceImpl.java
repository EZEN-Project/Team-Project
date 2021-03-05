package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberVO;
import kr.co.repository.MemberDAO;
@Service
public class MemberServiceImpl implements MemberService{
	@Inject
	private MemberDAO memberDAO;
	
	@Transactional
	@Override
	public MemberVO login(LoginDTO dto) {
		// TODO Auto-generated method stub
		return memberDAO.login(dto);
	}

}
