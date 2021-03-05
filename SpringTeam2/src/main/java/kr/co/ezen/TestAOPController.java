package kr.co.ezen;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.TestService;

@Controller
@RequestMapping("/aop")
public class TestAOPController {
	
	@Inject
	private TestService testService;
	
	@RequestMapping(value = "/printTime", method=RequestMethod.GET)
	public void printTime() {
		testService.printTime(3, "hello");
	}
	
	@RequestMapping(value = "/me1", method=RequestMethod.GET)
	public void me1() {
		testService.me1();
	}


}
