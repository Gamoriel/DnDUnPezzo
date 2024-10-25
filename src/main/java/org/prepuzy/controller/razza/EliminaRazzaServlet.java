package org.prepuzy.controller.razza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Razza;

@WebServlet("/master/EliminaRazzaServlet")
public class EliminaRazzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRazzaStr = request.getParameter("idRazza");
		if (idRazzaStr != null && !idRazzaStr.isEmpty()) {
			try {
				long idRazza = Long.parseLong(idRazzaStr);
				Razza razza = BusinessLogic.razzaById(idRazza);

				if (razza != null) {
					BusinessLogic.eliminaRazza(idRazza);
					response.sendRedirect("RazzaServlet?= Razza eliminata con successo.");
				} else {
					response.sendRedirect("ErrorServlet?= Razza non trovata");
					return;
				}
			} catch (NumberFormatException e) {
				response.sendRedirect("ErrorServlet?= ID non valito");
				return;
			}
		} else {
			response.sendRedirect("ErrorServlet?= ID non valido");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
