package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.repository.BoardDAO;
import kr.co.repository.ReplyDAO;


@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDao;
	
	@Inject
	private ReplyDAO replyDao;

	@Override
	public List<BoardVO> list(int curPage) {
		// TODO Auto-generated method stub
		return boardDao.list(curPage);
	}
	
	
	@Override
	public BoardVO read(int bno) {
		boardDao.updateViewCnt(bno);
		return boardDao.read(bno);
	}

	
	@Override
	public void insert(BoardVO vo) {
		boardDao.insert(vo);
		
		String[] files = vo.getFiles();
		if(files == null) {
			return;
		}
		
		for(String fullName : files) {
			boardDao.addAttach(fullName, vo.getBno());
		}
		
	}

	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return boardDao.updateUI(bno);
	}

	@Override
	public void update(BoardVO vo) {
		boardDao.update(vo);
		String[] arr =vo.getFiles();
		if (arr == null) {
			return;
		}
		boardDao.deleteFilesByBno(vo.getBno());
		for(String fileName: arr) {
			boardDao.addAttach(fileName, vo.getBno());
		}
		
		
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		replyDao.deleteReplies(bno);
		
		
		boardDao.delete(bno);
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return boardDao.getAmount();
	}


	@Override
	public List<String> getAttaches(int bno) {
		// TODO Auto-generated method stub
		return boardDao.getAttaches(bno);
	}


	@Override
	public void deleteFile(String fileName) {
		// TODO Auto-generated method stub
		boardDao.deleteFile(fileName);
	}

}
