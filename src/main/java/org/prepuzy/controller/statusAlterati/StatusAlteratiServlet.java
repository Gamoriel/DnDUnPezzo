package org.prepuzy.controller.statusAlterati;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.StatusAlterati;

@WebServlet("/StatusAlteratiServlet")
public class StatusAlteratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<StatusAlterati> listaStatusAlterati = BusinessLogic.listaStatusAlterati();
        request.setAttribute("statusAlterati", listaStatusAlterati);
        request.getRequestDispatcher("WEB-INF/private_jsp/StatusAlterati.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
