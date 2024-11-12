package org.prepuzy.controller.capitolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Mappa;

@WebServlet("/master/AggiungiCapitoloServlet")
public class AggiungiCapitoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiCapitolo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titolo = request.getParameter("titolo");
		String testo = request.getParameter("testo");
		String idMappaStr = request.getParameter("mappa");
		boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

		if (titolo != null && !titolo.isEmpty() && testo != null && !testo.isEmpty() && idMappaStr != null) {
			try {
				long idMappa = Long.parseLong(idMappaStr);
				Mappa mappa = BusinessLogic.cercaMappaConId(idMappa);

				if (mappa != null) {
					Capitolo nuovoCapitolo = new Capitolo();
					nuovoCapitolo.setTitolo(titolo);
					nuovoCapitolo.setTesto(testo);
					nuovoCapitolo.setMappa(mappa);
					nuovoCapitolo.setVisibleToAll(isVisibleToAll);

					BusinessLogic.inserisciCapitolo(nuovoCapitolo);

					response.sendRedirect(request.getContextPath() + "/MasterPageServlet");
				} else {
					request.setAttribute("messaggio", "Capitolo non trovato");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "Non tutti i campi sono compilati");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
			}
		} else {
			request.setAttribute("messaggio", "Dati mancanti per aggiungere il capitolo");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}
}
