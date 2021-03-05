package kr.co.ezen;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.UserVO;

@Controller
@RequestMapping("/ajax")
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public List<UserVO> test4(@RequestParam Map<String, Object> map) throws Exception{
		String strList = map.get("list").toString();
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<UserVO> list = mapper.readValue(strList, 
							new TypeReference<List<UserVO>>() {
		} );
		
		for(UserVO m : list) {
			System.out.println("+++++++++++++");
			System.out.println(m.getMid());
			System.out.println(m.getMpw());
			System.out.println(m.getMname());
			System.out.println("+++++++++++++");
		}
		
		return list;
	}

	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public void test4() {

	}

	@ResponseBody
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public UserVO test3(UserVO vo) {
		System.out.println(vo);

		return vo;
	}

	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public void test3() {

	}

	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String[] test2(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("><<><><><><");

		for (String x : arr) {
			System.out.println(x);
		}

		return arr;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2() {

	}

	@ResponseBody
	@RequestMapping(value = "/test1", method = RequestMethod.POST, produces = "application/text; charset=UTF8")
	public String test1(String str) {
		System.out.println(str);
		System.out.println("해당 테이블에 str값이 있으면 사용 불가, 없으면 사용가능");
		System.out.println("MemberVO vo = service.idcheck(str);");
		System.out.println("vo==null: 사용 가능, vo != null: 사용 불가");

		return str;
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {

	}

}
