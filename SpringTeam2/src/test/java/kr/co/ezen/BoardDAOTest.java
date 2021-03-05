package kr.co.ezen;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.repository.BoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {

	@Inject
	BoardDAO boardDao;
	
	@Test
	public void testBoardList() {
		List<BoardVO> list = boardDao.list(1);
		System.out.println(">>>>>>>>");
		System.out.println(list);
	}
	
	
}
