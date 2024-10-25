package org.prepuzy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errore = (String) request.getAttribute("messaggio");

        if (errore == null || errore.isEmpty()) {
            errore = "Si è verificato un errore inatteso. Per favore riprova più tardi.";
        }

        request.setAttribute("messaggioErrore", errore);
        request.getRequestDispatcher("public_jsp/Error.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
