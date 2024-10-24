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
		String idString = request.getParameter("id");
		if (idString != null && !idString.isEmpty()) {
			try {
				long id = Long.parseLong(idString);
				boolean eliminato = BusinessLogic.eliminaPersonaggio(id);

				if (eliminato) {
					response.sendRedirect("PersonaggiServlet");
				} else {
					request.getRequestDispatcher("ErrorServlet?=Impossibile eliminare il personaggio.").forward(request, response);
				}
			} catch (NumberFormatException e) {
				request.getRequestDispatcher("ErrorServlet?=ID non valido.").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("ErrorServlet?=ID del personaggio non specificato.").forward(request, response);
		}
	}

}
