package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object login =session.getAttribute("login");
		if (login == null) {
			String uri = request.getRequestURI();
			String query =request.getQueryString();
			if (query==null || query.equalsIgnoreCase("null")) {
				query="";
			}else {
				query = "?"+query;
			}
			if (request.getMethod().equalsIgnoreCase("GET")) {
				
			}
			session.setAttribute("dest", uri+query);
			response.sendRedirect("/member/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
