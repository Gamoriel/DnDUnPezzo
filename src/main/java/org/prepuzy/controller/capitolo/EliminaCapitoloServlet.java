package org.prepuzy.controller.capitolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaCapitoloServlet")
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

					request.getRequestDispatcher("MasterPageServlet?message=Capitolo eliminato con successo").forward(request, response);
				} else {

					request.setAttribute("messaggio", "Errore nell'eliminazione del capitolo"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				}

			} catch (NumberFormatException e) {

				request.setAttribute("messaggio", "ID del capitolo non valido"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {

			request.setAttribute("messaggio", "ID del capitolo mancante"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

}
