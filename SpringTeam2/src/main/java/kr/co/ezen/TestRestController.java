package kr.co.ezen;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.UserVO;


@RestController
@RequestMapping("/rest")
public class TestRestController {
	
	
	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public Map<String, Object> test4(@RequestBody Map<String, Object> map){
		
		System.out.println(map);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("strList");
		
		Map<String, Object> subMap = list.get(1);
		System.out.println(subMap);
		
		System.out.println(subMap.get("mname"));
		return map;
	}
	
	
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public Map<String, Object> test3(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		System.out.println(map.get("test1"));
		System.out.println(map.get("test3"));
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = 
				(List<Map<String, Object>>) map.get("test3");
		
		Map<String, Object> smap = list.get(1);
		System.out.println(smap.get("mpw"));
		return map;
	}
		
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public Map<String, Object> test2(@RequestBody Map<String, Object> map){
		System.out.println(map.get("test2"));
		
		return map;
	}
	
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String test1(@RequestBody Map<String, Object> map){
		
		System.out.println(map.get("test1"));
		
				
		return map.get("test1").toString();
	}

}
