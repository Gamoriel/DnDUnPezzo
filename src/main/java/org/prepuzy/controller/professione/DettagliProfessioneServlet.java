package org.prepuzy.controller.professione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;


@WebServlet("/DettagliProfessioneServlet")
public class DettagliProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("idProfessione");
        List<AbilitaProfessione> abilitaProfessioneUtente;
        if (idString != null) {
            long idProfessione = Long.parseLong(idString);
            Professione professione = BusinessLogic.professioneById(idProfessione);
            
            if (professione != null) {
            	HttpSession session = request.getSession();
                Utente utenteLoggato = (Utente) session.getAttribute("loggedUser");
            	if (utenteLoggato.getRole().equals(Role.BASE)) {            		
            		abilitaProfessioneUtente = BusinessLogic.abilitaProfessioneUtente(utenteLoggato.getId(), professione.getId());
            	} else {
            		abilitaProfessioneUtente = BusinessLogic.listaAbilitaProfessioneByProfessione(professione.getId());
            	}
                request.setAttribute("abilitaVisibili", abilitaProfessioneUtente);
                request.setAttribute("professione", professione);
                request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliProfessione.jsp").forward(request, response);
            } else {
                request.setAttribute("messaggio", "Professione non trovata."); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
            }
        } else {
            request.setAttribute("messaggio", "ID professione non fornito."); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
