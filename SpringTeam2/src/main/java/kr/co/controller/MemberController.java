package kr.co.controller;


import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberVO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void loginGet() {
		
	}
	@RequestMapping(value = "/loginPost",method = RequestMethod.POST)
	public void loginPost(LoginDTO login, Model model) {
		MemberVO vo =service.login(login);
		model.addAttribute("login",vo);
		
	}
	
	
}
