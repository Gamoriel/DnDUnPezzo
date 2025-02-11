package org.prepuzy.controller.professione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaProfessioneServlet")
public class EliminaProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("idProfessione"));

        boolean professione = BusinessLogic.eliminaProfessione(id);

        if (professione) {
        	response.sendRedirect(request.getContextPath() + "/ProfessioniServlet");
        } else {
            request.setAttribute("messaggio", "Errore durante l'eliminazione della professione."); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
