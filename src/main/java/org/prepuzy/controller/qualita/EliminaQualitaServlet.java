package org.prepuzy.controller.qualita;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaQualitaServlet")
public class EliminaQualitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idQualitaStr = request.getParameter("idQualita");

		if (idQualitaStr != null) {
			try {
				long idQualita = Long.parseLong(idQualitaStr);
				boolean eliminato = BusinessLogic.eliminaQualita(idQualita);

				if (eliminato) {
					request.getRequestDispatcher("/master/QualitaServlet").forward(request, response);
				} else {
					request.setAttribute("messaggio", "Impossibile eliminare la qualità.");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "ID qualità non valido.");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
			}
		} else {
			request.setAttribute("messaggio", "ID qualità non fornito.");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}
}
