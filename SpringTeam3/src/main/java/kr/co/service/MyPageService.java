package kr.co.service;


import java.util.List;
import java.util.Map;

import kr.co.domain.SellVO;
import kr.co.domain.TotalVO;

public interface MyPageService {

	List<SellVO> list(int sellnum);
	void delete(Map<String, Object> map);
	List<SellVO> adminlist(int curPage);
	int getAmount();
	List<TotalVO> chart_day();
	List<TotalVO> chart_month();
	List<TotalVO> chart_year();
	void allDelte(int mnum);
	

	
	

	

}
