package org.prepuzy.controller.razza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Razza;

@WebServlet("/master/ModificaRazzaServlet")
public class ModificaRazzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRazzaParam = request.getParameter("idRazza");
		if (idRazzaParam != null && !idRazzaParam.isEmpty()) {
			long idRazza = Long.parseLong(idRazzaParam);

			Razza razza = BusinessLogic.razzaById(idRazza);
			if (razza != null) {
				request.setAttribute("razza", razza);
				request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaRazza.jsp").forward(request, response);
			} else {
				request.setAttribute("messaggio", "RazzaNonTrovata"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "IDInvalido"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRazzaParam = request.getParameter("idRazza");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");

		if (idRazzaParam != null && !idRazzaParam.isEmpty()) {
			long idRazza = Long.parseLong(idRazzaParam);
			Razza razza = BusinessLogic.razzaById(idRazza);
			if (razza != null) {
				razza.setNome(nome);
				razza.setDescrizione(descrizione);
				BusinessLogic.modificaRazza(razza);
				request.setAttribute("idRazza", idRazza);
				request.getRequestDispatcher("/DettagliRazzaServlet").forward(request, response);
			} else {
				request.setAttribute("messaggio", "RazzaNonTrovata"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "IDInvalido"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

}
