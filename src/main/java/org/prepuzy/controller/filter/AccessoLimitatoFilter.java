package org.prepuzy.controller.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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

import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebFilter("/*")
public class AccessoLimitatoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
    private final Set<String> excludedUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedUrls.add("/DndProject/ErrorServlet");
        excludedUrls.add("/DndProject/Login");
        excludedUrls.add("/DndProject/LoginLogicServlet");
        excludedUrls.add("/DndProject/MasterLogicServlet");
        excludedUrls.add("/DndProject/MasterPageServlet");
        excludedUrls.add("/DndProject/RegisterLogicServlet");
        excludedUrls.add("/DndProject/RegisterPageServlet");
        excludedUrls.add("/DndProject/CapitoloLogicServlet");
        excludedUrls.add("/DndProject/CapitoloPageServlet");
        excludedUrls.add("/DndProject/CiurmaServlet");
        excludedUrls.add("/DndProject/DettagliCiurma");
        excludedUrls.add("/DndProject/FruttiServlet");
        excludedUrls.add("/DndProject/DettagliFruttoServlet");
        excludedUrls.add("/DndProject/EquipaggiaOggettoServlet");
        excludedUrls.add("/DndProject/RimuoviOggettoEquipServlet");
        excludedUrls.add("/DndProject/AggiornaDenaroServlet");
        excludedUrls.add("/DndProject/AggiungiOggettoInventarioServlet");
        excludedUrls.add("/DndProject/RimuoviOggettoInventarioServlet");
        excludedUrls.add("/DndProject/SpostaOggettoDaDepositoServlet");
        excludedUrls.add("/DndProject/SpostaOggettoDepositoServlet");
        excludedUrls.add("/DndProject/MappeServlet");
        excludedUrls.add("/DndProject/DettagliMappaServlet");
        excludedUrls.add("/DndProject/DettagliNaveServlet");
        excludedUrls.add("/DndProject/NaviServlet");
        excludedUrls.add("/DndProject/DettagliOggettoServlet");
        excludedUrls.add("/DndProject/OggettiServlet");
        excludedUrls.add("/DndProject/AggiungiPersonaggioServlet");
        excludedUrls.add("/DndProject/DettagliMercanteServlet");
        excludedUrls.add("/DndProject/DettagliPersonaggioServlet");
        excludedUrls.add("/DndProject/MercantiServlet");
        excludedUrls.add("/DndProject/ModificaPersonaggioServlet");
        excludedUrls.add("/DndProject/PersonaggiServlet");
        excludedUrls.add("/DndProject/ProfessioniServlet");
        excludedUrls.add("/DndProject/DettagliProfessioneServlet");
        excludedUrls.add("/DndProject/RazzaServlet");
        excludedUrls.add("/DndProject/DettagliRazzaServlet");
        excludedUrls.add("/DndProject/DettagliResistenzaServlet");
        excludedUrls.add("/DndProject/ResistenzeServlet");
        excludedUrls.add("/DndProject/DettagliStatusAlteratiServlet");
        excludedUrls.add("/DndProject/StatusAlteratiServlet");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 System.out.println("Entering doFilter method");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    HttpSession session = httpRequest.getSession(false);
	    String requestURI = httpRequest.getRequestURI();
	    
	    System.out.println("Requested URI: " + requestURI);
	    System.out.println("Excluded URLs: " + excludedUrls);
	    
	    if (excludedUrls.contains(requestURI)) {
	    	System.out.println("Log per verificare che entri nell'if");
	        chain.doFilter(request, response);
	        return;
	    }

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