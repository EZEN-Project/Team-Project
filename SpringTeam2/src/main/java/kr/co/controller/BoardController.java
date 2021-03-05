package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Inject
	private BoardService boardService;
	
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public String deleteFile(String fileName) {
		boardService.deleteFile(fileName);
		
		return fileName;
		
		
	}
						
	
	
	@ResponseBody
	@RequestMapping(value = "/getAttaches/{bno}")
	   public List<String> getAttaches(@PathVariable("bno") int bno){
	      return boardService.getAttaches(bno);
	   }
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public String delete(int bno) {
		
		boardService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
		
		boardService.update(vo);
		
		
		
		return "redirect:/board/read/"+vo.getBno();
	}
	
	
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(@PathVariable("bno") int bno, Model model) {
		BoardVO vo = boardService.updateUI(bno);
		model.addAttribute("vo", vo);
		
		return "/board/update";
	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
		
		boardService.insert(vo);
			
		return "redirect:/board/read/"+vo.getBno();
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, Model model) {
	   BoardVO vo = boardService.read(bno);
	   model.addAttribute("vo", vo);
		
		return "board/read";
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		int curPage = 1;
		PageTO<BoardVO> to = new PageTO<BoardVO>(curPage);
		
		List<BoardVO> list = boardService.list(curPage);
		model.addAttribute("list", list);
		
		
		int amount = boardService.getAmount();
		
		to.setAmount(amount);
		to.setList(list);
		
		model.addAttribute("to", to);
		
		return "board/list";
	}
	
	
	
	@RequestMapping(value = "/list/{curPage}", method = RequestMethod.GET)
	public String list(Model model, @PathVariable("curPage") String sCurPage) {
		
		int curPage = 1;
		if(sCurPage != null) {
			curPage = Integer.parseInt(sCurPage);
		}
		
		PageTO<BoardVO> to = new PageTO<BoardVO>(curPage);
		
		int amount = boardService.getAmount();
		to.setAmount(amount);
		
		
		List<BoardVO> list = boardService.list(curPage);
		model.addAttribute("list", list);
		
		
		to.setList(list);
		model.addAttribute("to", to);
		
		
		
		return "board/list";
		
	}
	
	
	
	
	
}
