package org.prepuzy.controller.ciurma;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;


@WebServlet("/EliminaCiurmaServlet")
public class EliminaCiurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idCiurma = Long.parseLong(request.getParameter("idCiurma"));
        BusinessLogic.eliminaCiurma(idCiurma);  
        response.sendRedirect("CiurmaServlet");
	}
}
