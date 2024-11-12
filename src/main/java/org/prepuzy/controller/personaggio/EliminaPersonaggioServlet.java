package org.prepuzy.controller.personaggio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/EliminaPersonaggioServlet")
public class EliminaPersonaggioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idPersonaggio");
		if (idString != null && !idString.isEmpty()) {
			try {
				long id = Long.parseLong(idString);
				boolean eliminato = BusinessLogic.eliminaPersonaggio(id);

				if (eliminato) {
					response.sendRedirect(request.getContextPath() + "/PersonaggiServlet");
				} else {
					request.setAttribute("messaggio", "Impossibile eliminare il personaggio."); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "ID non valido."); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "ID del personaggio non specificato."); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

}
