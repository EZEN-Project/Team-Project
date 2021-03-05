package kr.co.repository;

import java.util.List;
import java.util.Map;

import kr.co.domain.BoardVO;

public interface BoardDAO {
	
	public List<BoardVO> list(int curPage);

	public BoardVO read(int bno);

	public void insert(BoardVO vo);

	public BoardVO updateUI(int bno);

	public void update(BoardVO vo);

	public void delete(int bno);

	public int getAmount();

	public void updateViewCnt(int bno);

	public void updateReplyCnt(int bno);

	public void updateReplyCntMinus(Map<String, Object> map);
	
	
	public void addAttach(String fullName, int bno);
	public List<String> getAttaches(int bno);

	public void deleteFile(String fileName);

	public void deleteFilesByBno(int bno);
}
