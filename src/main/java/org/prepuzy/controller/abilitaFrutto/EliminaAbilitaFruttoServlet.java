package org.prepuzy.controller.abilitaFrutto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaFrutto;


@WebServlet("/master/EliminaAbilitaFruttoServlet")
public class EliminaAbilitaFruttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idAbilita = Long.parseLong(request.getParameter("idAbilita"));
        
        AbilitaFrutto abilita = BusinessLogic.abilitaFruttoById(idAbilita);

        if (abilita != null) {
            BusinessLogic.eliminaAbilitaFrutto(abilita.getId());
        } else {
            request.setAttribute("messaggio", "Abilità non trovata.");
            request.getRequestDispatcher("ErrorServlet").forward(request, response);
            return;
        }
        request.getRequestDispatcher("AbilitaFruttoServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
