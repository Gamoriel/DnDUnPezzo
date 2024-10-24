package org.prepuzy.controller.equipaggiamento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

@WebServlet("/RimuoviOggettoEquipServlet")
public class RimuoviOggettoEquipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
	        long idOggetto = Long.parseLong(request.getParameter("idOggetto"));

	        Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
	        Oggetto oggetto = BusinessLogic.oggettoById(idOggetto);

	        if (personaggio != null && oggetto != null) {
	            Equipaggiamento equip = personaggio.getEquip();

	            if (equip != null && equip.getOggetti().contains(oggetto)) {
	                equip.getOggetti().remove(oggetto);
	                personaggio.getInventario().getOggetti().add(oggetto);
	                BusinessLogic.modificaPersonaggio(personaggio);

	                response.sendRedirect("DettagliPersonaggioServlet?idPersonaggio=" + idPersonaggio);
	            } else {
	                response.sendRedirect("ErrorServlet?messaggio=Oggetto non presente nell'equipaggiamento");
	            }
	        } else {
	            response.sendRedirect("ErrorServlet?messaggio=Personaggio o Oggetto non trovati");
	        }
	}

}
