package org.prepuzy.controller.abilitaProfessione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;


@WebServlet("/master/AggiungiAbilitaProfessioneServlet")
public class AggiungiAbilitaProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiAbilitaProfessione.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");

        if (nome == null || nome.isEmpty() || descrizione == null || descrizione.isEmpty()) {
            request.setAttribute("messaggio", "Nome e descrizione sono obbligatori.");
            request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
            return;
        }
        
        AbilitaProfessione abilita = new AbilitaProfessione();
        abilita.setNome(nome);
        abilita.setDescrizione(descrizione);
        
        BusinessLogic.aggiungiAbilitaProfessione(abilita);
        
       response.sendRedirect(request.getContextPath() + "/master/AbilitaProfessioneServlet");
	}
}
