package org.prepuzy.controller.professione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Professione;


@WebServlet("/ModificaProfessioneServlet")
public class ModificaProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 long idProfessione = Long.parseLong(request.getParameter("idProfessione"));
		 Professione professione = BusinessLogic.professioneById(idProfessione);
		
        if (professione != null) {
        	List<AbilitaProfessione> abilita = BusinessLogic.listaAbilitaProfessione();
        	request.setAttribute("listaAbilita", abilita);
            request.setAttribute("professione", professione);
            request.getRequestDispatcher("WEB-INF/private_jsp/ModificaProfessione.jsp").forward(request, response);
        } else {
        	request.setAttribute("messaggio", "Professione non trovata");
        	request.getRequestDispatcher("ErrorServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idProfessione = Long.parseLong(request.getParameter("idProfessione"));
	    String nome = request.getParameter("nome");
	    String descrizione = request.getParameter("descrizione");
        String[] abilitaIds = request.getParameterValues("abilita");
	    int forza = Integer.parseInt(request.getParameter("forza"));
	    int destrezza = Integer.parseInt(request.getParameter("destrezza"));
	    int costituzione = Integer.parseInt(request.getParameter("costituzione"));
	    int intelligenza = Integer.parseInt(request.getParameter("intelligenza"));
	    int saggezza = Integer.parseInt(request.getParameter("saggezza"));
	    int carisma = Integer.parseInt(request.getParameter("carisma"));
	    int hp = Integer.parseInt(request.getParameter("hp"));

	    Professione professione = new Professione();
	    professione.setId(idProfessione);
	    professione.setNome(nome);
	    professione.setDescrizione(descrizione);
	    professione.setAbilitaProfessione(BusinessLogic.getEntitiesByIds(AbilitaProfessione.class, abilitaIds));
	    professione.setForza(forza);
	    professione.setDestrezza(destrezza);
	    professione.setCostituzione(costituzione);
	    professione.setIntelligenza(intelligenza);
	    professione.setSaggezza(saggezza);
	    professione.setCarisma(carisma);
	    professione.setHp(hp);

	    BusinessLogic.modificaProfessione(professione);

	    response.sendRedirect("ProfessioniServlet");
	}

}
