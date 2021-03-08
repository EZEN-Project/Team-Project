package kr.co.service;

import kr.co.domain.SellBoardVO;

public interface SellBoardService {

	public void insert(SellBoardVO vo);

	public SellBoardVO read(int bnum);

}
