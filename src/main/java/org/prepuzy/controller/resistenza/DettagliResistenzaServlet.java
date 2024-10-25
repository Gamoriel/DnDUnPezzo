package org.prepuzy.controller.resistenza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Resistenza;

@WebServlet("/DettagliResistenzaServlet")
public class DettagliResistenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idResistenzaParam = request.getParameter("idResistenza");

		if (idResistenzaParam != null && !idResistenzaParam.isEmpty()) {
			try {
				long idResistenza = Long.parseLong(idResistenzaParam);
				Resistenza resistenza = BusinessLogic.resistenzaById(idResistenza);
				if (resistenza != null) {
					request.setAttribute("resistenza", resistenza);
					request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliResistenza.jsp").forward(request, response);
				} else {
					response.sendRedirect("ErrorServlet?=Resistenza non trovata");
				}
			} catch (NumberFormatException e) {
				response.sendRedirect("ErrorServlet?= errore nel trovare Resistenza" + e.getMessage());
			}
		} else {
			response.sendRedirect("ErrorServlet?=ID non valido");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
