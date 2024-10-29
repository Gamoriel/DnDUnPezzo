package org.prepuzy.controller.oggetto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaOggettoServlet")
public class EliminaOggettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idOggetto");

		if (idStr != null && !idStr.isEmpty()) {
			long id = Long.parseLong(idStr);
			try {
				boolean success = BusinessLogic.deleteOggetto(id);

				if (success) {
					request.getRequestDispatcher("/OggettiServlet").forward(request, response);
					return;
				} else {
					request.setAttribute("messaggio", "Oggetto non trovato"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
					return;
				}
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore durante eliminazione oggetto"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				e.printStackTrace();
			}
		} else {
			request.setAttribute("messaggio", "ID non valido"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

}
