package org.prepuzy.controller.nave;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Nave;

@WebServlet("/DettagliNaveServlet")
public class DettagliNaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idNave = Long.parseLong(request.getParameter("idNave"));

		Nave nave = BusinessLogic.naveById(idNave);

		if (nave != null) {
			request.setAttribute("nave", nave);
			request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliNave.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("ErrorServlet?=Nave non trovata.").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
