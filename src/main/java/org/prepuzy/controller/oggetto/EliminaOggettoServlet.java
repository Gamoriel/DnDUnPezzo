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
					response.sendRedirect("OggettiServlet?= Oggetto eliminato con successo");
					return;
				} else {
					response.sendRedirect("ErrorServlet?=Oggetto non trovato");
					return;
				}
			} catch (Exception e) {
				response.sendRedirect("ErrorServlet?=Errore durante eliminazione oggetto" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("ErrorServlet?=ID non valido");
		}
	}

}
