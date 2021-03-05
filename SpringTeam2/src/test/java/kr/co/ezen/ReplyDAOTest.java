package kr.co.ezen;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;
import kr.co.repository.BoardDAO;
import kr.co.repository.ReplyDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOTest {


	@Inject
	private ReplyDAO replyDao;
	
	@Test
	public void testReplyList() {
		PageTO to = new PageTO(1);
		List<ReplyVO> list = replyDao.list(10, to);
		System.out.println(list);
	}
	
	
	
	
	
	@Test
	public void testReplyInsert() {
		ReplyVO vo = new ReplyVO(10, "first reply", "kim");
		
		replyDao.insert(vo);
		
		
	}
	
	
}
