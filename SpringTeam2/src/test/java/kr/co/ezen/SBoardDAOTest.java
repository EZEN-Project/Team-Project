package kr.co.ezen;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.domain.SearchPageTO;
import kr.co.repository.BoardDAO;
import kr.co.repository.SBoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SBoardDAOTest {

	@Inject
	SBoardDAO sboardDao;
	
	@Test
	public void testGetAmount() {
		
		SearchPageTO spt = new SearchPageTO("title", "ma", 1);
		Integer amount = sboardDao.getAmount(spt);
		System.out.println(">>>>>>>>>>>>>>>");
		System.out.println(amount);
	}
	
	
	@Test
	public void testList() {
		SearchPageTO spt = new SearchPageTO("title", "ma", 1);
		List<BoardVO> list = sboardDao.list(spt);
		System.out.println(">>>>>>>>>>>>>>>");
		System.out.println(list);
	}
	
}
