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
import javax.servlet.http.HttpSession;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebFilter(urlPatterns = {"/EquipaggiaOggettoServlet", "/RimuoviOggettoEquipServlet", "/AggiornaDenaroServlet", "/AggiungiOggettoInventarioServlet", "/RimuoviOggettoInventarioServlet", "/SpostaOggettoDaDepositoServlet", "/SpostaOggettoDepositoServlet", "/EliminaPersonaggioServlet"})
public class OperazioniVietateAdUtenteBase extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		Utente u = (Utente) (session != null ? session.getAttribute("loggedUser") : null);
		String idPersonaggio = httpRequest.getParameter("idPersonaggio");

		if (idPersonaggio != null && !idPersonaggio.isEmpty()) {
			Personaggio p = BusinessLogic.personaggioById(Long.parseLong(idPersonaggio));

			if (p != null && u != null) {
				if (p.getUtente().getId() == u.getId() || u.getRole().equals(Role.MASTER)) {
					chain.doFilter(request, response);
				} else {
					request.setAttribute("messaggio", "Non puoi modificare il personaggio di qualcun'altro, biricchino. Porcaccioddio! Bene, ora devi guardare con sguardo minaccioso il T-rex ed esclamare: POLDO");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				}
			} else {
				request.setAttribute("messaggio", "Accesso non autorizzato.");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}
}
