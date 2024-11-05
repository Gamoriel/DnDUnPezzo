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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
		String idOggettoStr = request.getParameter("idOggetto");

		Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
		if(idOggettoStr != null && !idOggettoStr.isEmpty()) {			
			Oggetto oggetto = BusinessLogic.oggettoById(Long.parseLong(idOggettoStr));
			if (personaggio != null && oggetto != null) {
				Equipaggiamento equip = personaggio.getEquip();
				
				if (equip != null && equip.getOggetti().contains(oggetto)) {
					equip.getOggetti().remove(oggetto);
					oggetto.setEquipaggiamento(null);
					personaggio.getInventario().getOggetti().add(oggetto);
					BusinessLogic.modificaEquipaggiamentoPersonaggio(equip, personaggio, oggetto);
					
					request.getRequestDispatcher("/DettagliPersonaggioServlet?idPersonaggio=" + idPersonaggio)
					.forward(request, response);
				} else {
					request.getRequestDispatcher("/ErrorServlet?messaggio=Oggetto non presente nell'equipaggiamento")
					.forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/ErrorServlet?messaggio=Personaggio o Oggetto non trovati").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/ErrorServlet?messaggio=Non hai selezionato niente").forward(request, response);
		}

	}

}
