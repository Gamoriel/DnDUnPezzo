package org.prepuzy.controller.mappa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaMappaServlet")
public class EliminaMappaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long idMappa = Long.parseLong(request.getParameter("idMappa"));
			BusinessLogic.eliminaMappa(idMappa);
			response.sendRedirect("MappeServlet?message=Mappa eliminata con successo.");
		} catch (NumberFormatException e) {

			response.sendRedirect("ErrorServlet?messaggio=ID della mappa non valido.");
		} catch (Exception e) {

			response.sendRedirect("ErrorServlet?messaggio=Errore durante l'eliminazione della mappa.");
		}
	}

}
