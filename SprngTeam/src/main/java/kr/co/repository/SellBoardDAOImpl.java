package kr.co.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.SellBoardVO;

@Repository
public class SellBoardDAOImpl implements SellBoardDAO{

	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.sellboard";
	
	@Override
	public void insert(SellBoardVO vo) {
		sqlSession.insert(NS+".insert", vo);
		
	}

	@Override
	public SellBoardVO read(int bnum) {
		
		return sqlSession.selectOne(NS+".read", bnum);
	}

}
