package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.SearchPageTO;
import kr.co.service.BoardService;
import kr.co.service.SBoardService;

@Controller
@RequestMapping("/sboard")
public class SBoardController {
	
	@Inject
	private SBoardService sBoardService;
	
	@Inject
	private BoardService boardService;
	
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(int bno, SearchPageTO<BoardVO> spt) throws Exception {
		boardService.delete(bno);
		
		String keyword = new String(spt.getKeyword().getBytes("UTF-8"),
									"8859_1");
		String path = null;
		StringBuffer sb = new StringBuffer();
		sb.append("redirect:/sboard/list/");
		sb.append(spt.getSearchType());
		sb.append("/");
		sb.append(keyword);
		sb.append("/");
		sb.append(spt.getCurPage());
		path = sb.toString();
		
		return path;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo, SearchPageTO<BoardVO> spt, Model model){
		boardService.update(vo);
		//new String(spt.getKeyword().getBytes("UTF-8"), "8859_1");
		//한글 나오게 하려고, 이렇게 안 하면 한글이 안 나옴
		model.addAttribute("searchType", spt.getSearchType());
		model.addAttribute("keyword", spt.getKeyword());
		model.addAttribute("curPage", spt.getCurPage());
		
		return "redirect:/sboard/read/"+vo.getBno();
	}
	
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(@PathVariable("bno") int bno, Model model) {
		BoardVO vo = sBoardService.updateUI(bno);
		model.addAttribute("vo", vo);
		
		return "sboard/update";
	}
	
	
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, SearchPageTO<BoardVO> spt, Model model) {
		
		BoardVO vo = sBoardService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("spt", spt);
		return "sboard/read";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/list/{searchType}/{keyword}/{curPage}", method=RequestMethod.GET)
	public String list(@PathVariable("searchType") String searchType,
			@PathVariable("keyword") String keyword,
			@PathVariable("curPage") int curPage,
			Model model) {
		
		SearchPageTO<BoardVO> spt = new SearchPageTO<BoardVO>(searchType, keyword, curPage);
		Integer amount = sBoardService.getAmount(spt);
		if(amount == null) {
			amount = 0;
		}
		spt.setAmount(amount);
		
		List<BoardVO> list = sBoardService.list(spt);
		spt.setList(list);
		
		model.addAttribute("spt", spt);
		
		
		return "sboard/list";
	}



}
