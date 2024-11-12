package org.prepuzy.controller.resistenza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Resistenza;

@WebServlet("/master/ModificaResistenzaServlet")
public class ModificaResistenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idResistenzaParam = request.getParameter("idResistenza");

		if (idResistenzaParam != null && !idResistenzaParam.isEmpty()) {
			try {
				long idResistenza = Long.parseLong(idResistenzaParam);
				Resistenza resistenza = BusinessLogic.resistenzaById(idResistenza);

				if (resistenza != null) {
					request.setAttribute("resistenza", resistenza);
					request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaResistenza.jsp").forward(request,
							response);
				} else {
					request.setAttribute("messaggio", "Resistenza non trovata");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "Errore durante la ricerca");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "ID non valido");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idResistenzaParam = request.getParameter("idResistenza");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");

		if (idResistenzaParam != null && !idResistenzaParam.isEmpty()) {
			try {

				long idResistenza = Long.parseLong(idResistenzaParam);
				Resistenza resistenza = BusinessLogic.resistenzaById(idResistenza);
				if (resistenza != null) {
					resistenza.setNome(nome);
					resistenza.setDescrizione(descrizione);

					BusinessLogic.modificaResistenza(resistenza);
					response.sendRedirect(request.getContextPath() + "/DettagliResistenzaServlet?idResistenza=" + idResistenza);
				} else {
					request.setAttribute("messaggio", "Resistenza non trovata");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "Errore durante la modifica");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "ID non valido");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

}
