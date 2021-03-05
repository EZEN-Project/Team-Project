package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> list(int curPage);

	public BoardVO read(int bno);

	public void insert(BoardVO vo);

	public BoardVO updateUI(int bno);

	public void update(BoardVO vo);

	public void delete(int bno);

	public int getAmount();
	
	public List<String> getAttaches(int bno);

	public void deleteFile(String fileName);
}
