package org.prepuzy.controller.abilitaProfessione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Personaggio;


@WebServlet("/master/ModificaAbilitaProfessioneServlet")
public class ModificaAbilitaProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idAbilita = Long.parseLong(request.getParameter("idAbilita"));
		AbilitaProfessione abilita = BusinessLogic.abilitaProfessioneById(idAbilita);

		if (abilita != null) {
			List<Personaggio> personaggi = BusinessLogic.listaPersonaggiUtente();
			request.setAttribute("abilita", abilita);
			request.setAttribute("listaPersonaggi", personaggi);
			request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaAbilitaProfessione.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Abilita non trovata");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idAbilita = Long.parseLong(request.getParameter("idAbilita"));
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
		String[] personaggiVisibiliIds = request.getParameterValues("personaggiVisibili");

		AbilitaProfessione abilita = BusinessLogic.abilitaProfessioneById(idAbilita);
		abilita.setNome(nome);
		abilita.setDescrizione(descrizione);

		List<Personaggio> personaggiVisibili = BusinessLogic.getEntitiesByIds(Personaggio.class, personaggiVisibiliIds);
		abilita.setVisibileAPersonaggio(personaggiVisibili);

		BusinessLogic.modificaAbilitaProfessione(abilita);

		response.sendRedirect(request.getContextPath() + "/master/AbilitaProfessioneServlet");
	}

}
