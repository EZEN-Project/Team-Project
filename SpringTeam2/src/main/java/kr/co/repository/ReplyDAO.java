package kr.co.repository;

import java.util.List;
import java.util.Map;

import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;

public interface ReplyDAO {
	public abstract void insert(ReplyVO vo);
	List<ReplyVO> list(int bno, PageTO<ReplyVO> to);
	public abstract int getReplyAmount(int bno);
	public abstract int delete(Map<String, Object> map);
	public abstract int update(Map<String, Object> map);
	public abstract void deleteReplies(int bno);

}
