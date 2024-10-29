package org.prepuzy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Capitolo;

@WebServlet("/MasterLogicServlet")
public class MasterLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String capitoloIdStr = request.getParameter("portaACapitolo");

		if (capitoloIdStr != null && !capitoloIdStr.isEmpty()) {
			try {
				long capitoloId = Long.parseLong(capitoloIdStr);
				Capitolo capitolo = BusinessLogic.cercaConId(capitoloId);

				if (capitolo != null) {
					request.setAttribute("capitoloSelezionato", capitolo);
					request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliCapitolo.jsp").forward(request, response);
				} else {
					request.setAttribute("messaggio","Capitolo non trovato");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio","ID non valido");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
			}
		} else {
			request.setAttribute("messaggio","Nessun capitolo selezionato");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}
}