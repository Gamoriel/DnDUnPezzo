package org.prepuzy.controller.inventario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;


@WebServlet("/RimuoviOggettoInventarioServlet")
public class RimuoviOggettoInventarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
	    String idOggettoStr = request.getParameter("idOggetto");
	    if(idOggettoStr != null && !idOggettoStr.isEmpty()) {
	    	Long idOggetto = Long.parseLong(idOggettoStr);
	    	Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
	    	
	    	if (personaggio != null) {
	    		Inventario inventario = personaggio.getInventario();
	    		
	    		Oggetto oggettoDaRimuovere = inventario.getOggetti().stream()
	    				.filter(o -> o.getId() == idOggetto)
	    				.findFirst()
	    				.orElse(null);
	    		
	    		if (oggettoDaRimuovere != null) {
	    			inventario.getOggetti().remove(oggettoDaRimuovere);
	    			BusinessLogic.modificaPersonaggio(personaggio);
	    			request.setAttribute("idPersonaggio", idPersonaggio);
	    			request.getRequestDispatcher("DettagliPersonaggioServlet").forward(request, response);
	    		} else {
	    			request.setAttribute("messaggio", "Oggetto non trovato nell'inventario");
	    			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
	    		}
	    	} else {
    			request.setAttribute("messaggio", "Personaggio non trovato");
    			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
	    	}
	    } else {
			request.setAttribute("messaggio", "Id non valido");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
	    }
	}

}
