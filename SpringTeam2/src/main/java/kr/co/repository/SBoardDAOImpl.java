package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.SearchPageTO;

@Repository
public class SBoardDAOImpl implements SBoardDAO{
	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.search";
	
	@Override
	public Integer getAmount(SearchPageTO<BoardVO> spt) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmount", spt);
	}

	@Override
	public List<BoardVO> list(SearchPageTO<BoardVO> spt) {

		RowBounds rb = new RowBounds(spt.getStartNum()-1, spt.getPerPage());
		
		
		return sqlSession.selectList(NS+".list", spt, rb);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".read", bno);
	}

	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", bno);
	}

}
