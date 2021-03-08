package kr.co.repository;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberVO;

@Repository
public class MyPageDAOImpl implements MyPageDAO{
	@Inject
	private SqlSession sqlsession;
	
	private final String NS = "kr.co.mypage";
	
	@Override
	public MemberVO updateUI(int mnum) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+".updateUI", mnum);
	}

	@Override
	public void update(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlsession.update(NS+".update", vo);
	}

}
