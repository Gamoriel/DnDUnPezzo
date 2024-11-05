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

import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebFilter(urlPatterns = {"/master/*"})
public class AccessoLimitatoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    HttpSession session = httpRequest.getSession(false);

	    if (session == null || session.getAttribute("loggedUser") == null) {
	    	httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login");
	        return;
	    }

	    Utente u = (Utente) session.getAttribute("loggedUser");

	    if (u.getRole() == Role.BASE) {
	        httpRequest.setAttribute("messaggio", "Non hai l'autorizzazione per accedere a questa pagina");
	        httpRequest.getRequestDispatcher("/ErrorServlet").forward(httpRequest, httpResponse);
	    } else {
	        chain.doFilter(request, response);
	    }
	}
    @Override
    public void destroy() {
    }
}