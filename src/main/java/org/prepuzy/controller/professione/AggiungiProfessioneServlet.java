package org.prepuzy.controller.professione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Professione;

@WebServlet("/master/AggiungiProfessioneServlet")
public class AggiungiProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AbilitaProfessione> listaAbilita = BusinessLogic.listaAbilitaProfessione();
		
		request.setAttribute("listaAbilita", listaAbilita);
        request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiProfessione.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nome = request.getParameter("nome");
	        String descrizione = request.getParameter("descrizione");
	        int forza = Integer.parseInt(request.getParameter("forza"));
	        int destrezza = Integer.parseInt(request.getParameter("destrezza"));
	        int costituzione = Integer.parseInt(request.getParameter("costituzione"));
	        int intelligenza = Integer.parseInt(request.getParameter("intelligenza"));
	        int saggezza = Integer.parseInt(request.getParameter("saggezza"));
	        int carisma = Integer.parseInt(request.getParameter("carisma"));
	        int hp = Integer.parseInt(request.getParameter("hp"));
	        
	        String[] abilitaIds = request.getParameterValues("abilita");
	        List<AbilitaProfessione> listaAbilita = new ArrayList<>();
	        if (abilitaIds != null) {
	            for (String id : abilitaIds) {
	            	AbilitaProfessione abilitaProfessione = BusinessLogic.abilitaProfessioneById(Long.parseLong(id));
	                listaAbilita.add(abilitaProfessione);
	            }
	        }

	        Professione nuovaProfessione = new Professione();
	        nuovaProfessione.setNome(nome);
	        nuovaProfessione.setDescrizione(descrizione);
	        nuovaProfessione.setForza(forza);
	        nuovaProfessione.setDestrezza(destrezza);
	        nuovaProfessione.setCostituzione(costituzione);
	        nuovaProfessione.setIntelligenza(intelligenza);
	        nuovaProfessione.setSaggezza(saggezza);
	        nuovaProfessione.setCarisma(carisma);
	        nuovaProfessione.setHp(hp);
	        
	        BusinessLogic.aggiungiProfessione(nuovaProfessione);
	        response.sendRedirect("ProfessioniServlet");
	}

}
