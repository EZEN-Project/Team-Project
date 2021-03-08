package kr.co.repository;

import kr.co.domain.SellBoardVO;

public interface SellBoardDAO {

	public void insert(SellBoardVO vo);

	public SellBoardVO read(int bnum);

}
