package org.prepuzy.controller.capitolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/EliminaCapitoloServlet")
public class EliminaCapitoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idCapitoloStr = request.getParameter("idCapitolo");

		if (idCapitoloStr != null) {
			try {
				long idCapitolo = Long.parseLong(idCapitoloStr);
				boolean capitoloEliminato = BusinessLogic.cancellaCapitoloById(idCapitolo);
				;

				if (capitoloEliminato) {

					response.sendRedirect("MasterPageServlet?message=Capitolo eliminato con successo");
				} else {

					response.sendRedirect("ErrorServlet?messaggio=Errore nell'eliminazione del capitolo");
				}

			} catch (NumberFormatException e) {

				response.sendRedirect("ErrorServlet?messaggio=ID del capitolo non valido");
			}
		} else {

			response.sendRedirect("ErrorServlet?messaggio=ID del capitolo mancante");
		}
	}

}
