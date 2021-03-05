package kr.co.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;
import kr.co.repository.BoardDAO;
import kr.co.repository.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO replyDao;
	
	@Inject
	private BoardDAO boardDao;

	@Transactional
	@Override
	public void insert(ReplyVO vo) {
		replyDao.insert(vo);
		boardDao.updateReplyCnt(vo.getBno());
		
	}

	@Override
	public List<ReplyVO> list(int bno, PageTO<ReplyVO> to) {
		// TODO Auto-generated method stub
		return replyDao.list(bno, to);
	}

	@Override
	public int getReplyAmount(int bno) {
		// TODO Auto-generated method stub
		return replyDao.getReplyAmount(bno);
	}

	@Transactional
	@Override
	public int delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		boardDao.updateReplyCntMinus(map);
		
		return replyDao.delete(map);
	}

	@Override
	public int update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return replyDao.update(map);
	}

}
