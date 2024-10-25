package org.prepuzy.controller.abilitaProfessione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;


@WebServlet("/EliminaAbilitaProfessioneServlet")
public class EliminaAbilitaProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idAbilita = Long.parseLong(request.getParameter("idAbilita"));
        
        AbilitaProfessione abilita = BusinessLogic.abilitaProfessioneById(idAbilita);

        if (abilita != null) {
            BusinessLogic.eliminaAbilitaProfessione(abilita.getId());
        } else {
            request.setAttribute("messaggio", "Abilità non trovata.");
            request.getRequestDispatcher("ErrorServlet").forward(request, response);
            return;
        }
        request.getRequestDispatcher("AbilitaProfessioneServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
