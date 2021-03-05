package kr.co.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.board";
	
	
	@Override
	public List<BoardVO> list(int curPage) {
		// TODO Auto-generated method stub
		PageTO<BoardVO> to = new PageTO<BoardVO>(curPage);
				
		RowBounds rb = new RowBounds(to.getStartNum()-1, to.getPerPage());
		
		
		
		
		return sqlSession.selectList(NS+".list",null, rb);
	}


	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".read", bno);
	}


	@Override
	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NS+".insert", vo);
	}


	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", bno);
	}


	@Override
	public void update(BoardVO vo) {
		sqlSession.update(NS+".update", vo);
		
	}


	@Override
	public void delete(int bno) {
		sqlSession.delete(NS+".delete", bno);
		
	}


	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmount");
	}


	@Override
	public void updateViewCnt(int bno) {
		sqlSession.update(NS+".updateViewCnt", bno);
		
	}


	@Override
	public void updateReplyCnt(int bno) {
		sqlSession.update(NS+".updateReplyCnt", bno);
		
	}


	@Override
	public void updateReplyCntMinus(Map<String, Object> map) {
		sqlSession.update(NS+".updateReplyCntMinus", map);
		
	}


	@Override
	public void addAttach(String fullName, int bno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fullName", fullName);
		map.put("bno", bno);
		
		sqlSession.insert(NS+".addAttach", map);
		
	}


	@Override
	public List<String> getAttaches(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".getAttaches",bno);
	}


	@Override
	public void deleteFile(String fileName) {
		// TODO Auto-generated method stub
		sqlSession.delete(NS+".deleteFile",fileName);
	}


	@Override
	public void deleteFilesByBno(int bno) {
		// TODO Auto-generated method stub
		sqlSession.delete(NS+".deleteFilesByBno",bno);
	}

}
