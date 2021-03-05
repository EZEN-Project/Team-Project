package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.repository.BoardDAO;

@Service
public class TestServiceImpl implements TestService{
	
	@Inject
	private BoardDAO boardDao;
	
	@Override
	public void printTime(int bno, String msg) {
		
		List<BoardVO> list = boardDao.list(1);
		
		for(BoardVO vo : list) {
			System.out.println(vo.getBno());
			System.out.println(vo.getTitle());
		}
		
		
	}

	@Override
	public void me1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void me2() {
		// TODO Auto-generated method stub
		
	}
	

}
