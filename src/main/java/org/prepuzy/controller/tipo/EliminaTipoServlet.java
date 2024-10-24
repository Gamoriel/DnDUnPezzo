package org.prepuzy.controller.tipo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/EliminaTipoServlet")
public class EliminaTipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idTipoStr = request.getParameter("idTipo");

		if (idTipoStr != null && !idTipoStr.isEmpty()) {
			try {

				long idTipo = Long.parseLong(idTipoStr);
				boolean isDeleted = BusinessLogic.eliminaTipo(idTipo);

				if (isDeleted) {
					response.sendRedirect("TipiServlet");
				} else {
					request.getRequestDispatcher("ErrorServlet?=Impossibile eliminare il tipo. Forse è associato ad altri dati").forward(request, response);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				request.getRequestDispatcher("ErrorServlet?=ID Tipo non valido").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("ErrorServlet?=Errore durante l'eliminazione del tipo").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("ErrorServlet?=Nessun ID Tipo fornito").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
