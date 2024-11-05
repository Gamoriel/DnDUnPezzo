package org.prepuzy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Utente;

@WebServlet("/LoginLogicServlet")
public class LoginLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");

		if ("Registrati".equals(action)) {
			response.sendRedirect("RegisterPageServlet");
			return;
		}

		if (username == null || password == null || username.isBlank() || password.isBlank()) {
			request.setAttribute("errorMsg", "Devi inserire username e password");
			request.getRequestDispatcher("public_jsp/Login.jsp").forward(request, response);
			return;
		}

		Utente u = new Utente();
		u.setUsername(username);
		u.setPassword(password);
		u = BusinessLogic.login(u);

		if (u == null) {
			request.setAttribute("errorMsg", "Account non esistente");
			request.getRequestDispatcher("public_jsp/Login.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("loggedUser", u);
		response.sendRedirect("MasterPageServlet");

	}
}
