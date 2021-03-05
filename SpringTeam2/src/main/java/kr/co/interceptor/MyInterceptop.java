package kr.co.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class MyInterceptop extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("::::::::::::::::::prehandle");
		HandlerMethod method =(HandlerMethod)handler;
		Method m =method.getMethod();
		System.out.println(m);
		Object bean =method.getBean();
		System.out.println(bean);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(":::::::::::::::postHandle::::::::::::");
		Object result =modelAndView.getModel().get("result");
		System.out.println(result);
		if (result == null) {
			modelAndView.addObject("result","test!!");
			
		}
		result =modelAndView.getModel().get("result");
		System.out.println(result);
		
		if (result != null) {
			response.sendRedirect("/board/list");
		}
		
	}
	
}
