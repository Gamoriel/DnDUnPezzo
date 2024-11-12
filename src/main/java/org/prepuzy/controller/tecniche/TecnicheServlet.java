package org.prepuzy.controller.tecniche;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Tecniche;


@WebServlet("/master/TecnicheServlet")
public class TecnicheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tecniche> listaTecniche = BusinessLogic.listaTecniche();
		request.setAttribute("listaTecniche", listaTecniche);
        request.getRequestDispatcher("/WEB-INF/private_jsp/Tecniche.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
