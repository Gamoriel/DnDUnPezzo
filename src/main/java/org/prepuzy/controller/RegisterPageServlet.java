package org.prepuzy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.model.Utente;


@WebServlet("/RegisterPageServlet")
public class RegisterPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente userInSession = (Utente)request.getSession().getAttribute("loggedUser");
		String action = request.getParameter("action");
		
        if ("login".equals(action)) {
            request.getRequestDispatcher("/LoginPageServlet").forward(request, response);
            return;
        }
		
		if(userInSession != null) {
			switch (userInSession.getRole()) {
			case BASE: 
				request.getRequestDispatcher("/MasterPageServlet").forward(request, response);
				return;
			case MASTER:
				request.getRequestDispatcher("/MasterPageServlet").forward(request, response);
				return;
			default:
				request.getRequestDispatcher("/ErrorPageServlet").forward(request, response);
				return;
			}
		}
		
		request.getRequestDispatcher("public_jsp/Registrazione.jsp").forward(request, response);
	}

}
