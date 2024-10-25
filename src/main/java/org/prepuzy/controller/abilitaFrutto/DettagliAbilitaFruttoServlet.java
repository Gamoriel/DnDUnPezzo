package org.prepuzy.controller.abilitaFrutto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaFrutto;

@WebServlet("/DettagliAbilitaFruttoServlet")
public class DettagliAbilitaFruttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idAbilita = Long.parseLong(request.getParameter("idAbilita"));

		AbilitaFrutto abilita = BusinessLogic.abilitaFruttoById(idAbilita);

		if (abilita != null) {
			request.setAttribute("abilita", abilita);
			request.getRequestDispatcher("WEB-INF/private_jsp/DettagliAbilitaFrutto.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Abilita non trovata");
			request.getRequestDispatcher("ErrorServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
