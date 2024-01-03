package com.sist.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("로그인필터 동작");
		// pass the request along the filter chain
		// doFilter메소드의 매개변수인 ServletRequest request를
		// HttpServletRequest로 형 변환하여 Session객체를 얻어온다
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		// 세션에 로그인과 관련된 값이 있는지 파악
		if (session.getAttribute("loginID") != null) {
			// 세션변수가 있을경우(로그인한경우) 요청한 url로 보낸다
			chain.doFilter(request, response);
		} else {
			// 세션변수가 없다면(로그인하지 않았을 경우) 로그인페이지로
			// doFilter메소드의 매개변수인
			// ServletResponse를 HttpServletResponse로 형변환해야
			// sendRedirect메소드를 사용할 수 있다
			((HttpServletResponse)response).sendRedirect("/day0103/login.do");
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
