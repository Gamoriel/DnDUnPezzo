package org.prepuzy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegisterPageServlet")
public class RegisterPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
        if ("login".equals(action)) {
        	response.sendRedirect("LoginPageServlet");
            return;
        }
		
		response.sendRedirect("public_jsp/Registrazione.jsp");
	}

}
