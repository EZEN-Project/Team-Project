package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.domain.SearchPageTO;
import kr.co.repository.BoardDAO;
import kr.co.repository.SBoardDAO;

@Service
public class SBoardServiceImpl implements SBoardService {

	@Inject
	private SBoardDAO sBoardDAO;
	
		
	@Override
	public Integer getAmount(SearchPageTO<BoardVO> spt) {
		// TODO Auto-generated method stub
		return sBoardDAO.getAmount(spt);
	}

	@Override
	public List<BoardVO> list(SearchPageTO<BoardVO> spt) {
		// TODO Auto-generated method stub
		return sBoardDAO.list(spt);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return sBoardDAO.read(bno);
	}

	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return sBoardDAO.updateUI(bno);
	}

}
