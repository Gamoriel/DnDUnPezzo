package org.prepuzy.controller.tecniche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Tecniche;


@WebServlet("/master/DettagliTecnicheServlet")
public class DettagliTecnicheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idTecnica = Long.parseLong(request.getParameter("idTecnica"));
		
		Tecniche t = BusinessLogic.tecnicaById(idTecnica);
		
		if (t != null) {
			request.setAttribute("tecnica", t);
			request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliTecnica.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Tecnica non trovata");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
