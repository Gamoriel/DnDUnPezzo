package org.prepuzy.controller.frutto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaFruttoServlet")
public class EliminaFruttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idFruttoStr = request.getParameter("idFrutto");

		if (idFruttoStr != null && !idFruttoStr.isEmpty()) {
			try {
				long idFrutto = Long.parseLong(idFruttoStr);
				BusinessLogic.eliminaFrutto(idFrutto);
				request.getRequestDispatcher("/FruttiServlet").forward(request, response);
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "ID Frutto non valido");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "ID Frutto non fornito");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}
}
