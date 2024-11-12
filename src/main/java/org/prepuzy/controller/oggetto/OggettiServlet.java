package org.prepuzy.controller.oggetto;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebServlet("/OggettiServlet")
public class OggettiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	    Utente loggedUser = (Utente) session.getAttribute("loggedUser");
	    
	    List<Oggetto> listaOggetti;
	    
	    if(loggedUser != null) {
	    	
	    	if(loggedUser.getRole() == Role.MASTER) {	    	
	    		listaOggetti = BusinessLogic.listaOggetti();
	    		Map<String, List<Oggetto>> oggettoPerTipologia = listaOggetti.stream() .collect(Collectors.groupingBy(oggetto -> oggetto.getTipologia() != null ? oggetto.getTipologia().getNome() : "Senza Professione"));
	    		request.setAttribute("oggetti", oggettoPerTipologia);
	    	} else {
	    		listaOggetti = BusinessLogic.mostraOggettiVisibilitaUtenteBase();
	    		Map<String, List<Oggetto>> oggettoPerTipologia = listaOggetti.stream() .collect(Collectors.groupingBy(oggetto -> oggetto.getTipologia() != null ? oggetto.getTipologia().getNome() : "Senza Professione"));
	    		request.setAttribute("oggetti", oggettoPerTipologia);
	    	}
	    } else {
	    	request.getRequestDispatcher("/Login").forward(request, response);
	    }
		request.getRequestDispatcher("/WEB-INF/private_jsp/Oggetto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
