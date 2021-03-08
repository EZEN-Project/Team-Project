package kr.co.controller;





import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberVO;

import kr.co.service.MyPageService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

		@Inject
		private MyPageService service;
	
		@RequestMapping(value = "/update/{mnum}", method = RequestMethod.GET)
		public String update(Model model,@PathVariable("mnum")int mnum) {
			MemberVO vo = service.updateUI(mnum);
			model.addAttribute("vo", vo);
			
	
			return "mypage/update";
		}
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(MemberVO vo) {
			service.update(vo);
			

			return "redirect:/mypage/mypage";
		}
		

	}

