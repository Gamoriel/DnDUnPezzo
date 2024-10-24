package org.prepuzy.controller.razza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Razza;

@WebServlet("/DettagliRazzaServlet")
public class DettagliRazzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRazzaParam = request.getParameter("idRazza");

		if (idRazzaParam != null && !idRazzaParam.isEmpty()) {
			try {
				long idRazza = Long.parseLong(idRazzaParam);

				Razza razza = BusinessLogic.razzaById(idRazza);

				if (razza != null) {
					request.setAttribute("razza", razza);
					request.getRequestDispatcher("WEB-INF/private_jsp/DettagliRazza.jsp").forward(request, response);
				} else {
					response.sendRedirect("ErrorServlet?= Razza non trovata");
				}
			} catch (NumberFormatException e) {
				response.sendRedirect("ErrorServlet?=ID non valido");
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
