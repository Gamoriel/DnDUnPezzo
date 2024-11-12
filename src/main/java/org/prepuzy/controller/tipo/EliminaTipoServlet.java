package org.prepuzy.controller.tipo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaTipoServlet")
public class EliminaTipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idTipoStr = request.getParameter("idTipo");

		if (idTipoStr != null && !idTipoStr.isEmpty()) {
			try {

				long idTipo = Long.parseLong(idTipoStr);
				boolean isDeleted = BusinessLogic.eliminaTipo(idTipo);

				if (isDeleted) {
					response.sendRedirect(request.getContextPath() + "/master/TipiServlet");
				} else {
					request.setAttribute("messaggio", "Impossibile eliminare il tipo. Forse è associato ad altri dati");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("messaggio", "ID Tipo non valido");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("messaggio", "Errore durante l'eliminazione del tipo");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "Nessun ID Tipo fornito");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

}
