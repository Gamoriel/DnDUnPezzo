package org.prepuzy.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class SessionExpired extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String requestURI = httpRequest.getRequestURI();
         
        if (requestURI.endsWith("/Login") || requestURI.endsWith("/RegisterPageServlet") || requestURI.endsWith("/LoginLogicServlet") || requestURI.endsWith("/RegisterLogicServlet") || requestURI.contains("public_jsp") || requestURI.contains("resources")) {
            chain.doFilter(request, response);
            return;
        }
        
        if (session == null || session.getAttribute("loggedUser") == null) {
        	httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login");
            return; 
        }
        
        chain.doFilter(request, response);
    }
}
