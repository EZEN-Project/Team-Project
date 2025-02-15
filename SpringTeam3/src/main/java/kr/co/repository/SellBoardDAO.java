package kr.co.repository;

import java.util.List;

import kr.co.domain.SellBoardVO;

public interface SellBoardDAO {

	public void insert(SellBoardVO vo);

	public SellBoardVO read(int bnum);

	public List<String> getAttaches(int bnum);

	public SellBoardVO updateUI(int bnum);

	public void update(SellBoardVO vo);

	public void delete(int bnum);

	public void addAttach(String fullName, int bnum);

	public List<SellBoardVO> list();

	public void deleteFile(String fileName);

	public void deleteFilesByBnum(int bnum);




}
