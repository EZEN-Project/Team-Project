package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.SellBoardVO;
import kr.co.repository.SellBoardDAO;

@Service
public class SellBoardServiceImpl implements SellBoardService{

	@Inject
	private SellBoardDAO sellboardDao;
	
	@Override
	public void insert(SellBoardVO vo) {

		sellboardDao.insert(vo);
		
	}

	@Override
	public SellBoardVO read(int bnum) {
		
		return sellboardDao.read(bnum);
	}

}
