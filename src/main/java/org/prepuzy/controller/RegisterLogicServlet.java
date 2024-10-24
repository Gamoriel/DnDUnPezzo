package org.prepuzy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebServlet("/RegisterLogicServlet")
public class RegisterLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("usernameFormInput");
		String password = request.getParameter("passwordFormInput");
		String action = request.getParameter("action");
		
		if("login".equals(action)) {
			response.sendRedirect("Login");
			return;
		}
		
		Utente u = new Utente();
		u.setUsername(username);
		u.setPassword(password);
		
		if(username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
			u.setRole(Role.BASE);
			BusinessLogic.registrazione(u);
		} else {
			request.setAttribute("errorMsg", "Non hai inserito le credenziali!");
			request.getRequestDispatcher("public_jsp/Registrazione.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("Login");
	}

}
