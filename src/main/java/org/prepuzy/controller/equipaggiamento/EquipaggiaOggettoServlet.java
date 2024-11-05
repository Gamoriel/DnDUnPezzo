package org.prepuzy.controller.equipaggiamento;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

@WebServlet("/EquipaggiaOggettoServlet")
public class EquipaggiaOggettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
		String idOggetto = request.getParameter("idOggetto");

		if(idOggetto == null) {
			request.setAttribute("messaggio", "Nessun oggetto selezionato");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			return;
		}
		
		Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
		Oggetto oggetto = BusinessLogic.oggettoById(Long.parseLong(idOggetto));

		if (personaggio != null && oggetto != null) {
			if (personaggio.getInventario().getOggetti().contains(oggetto)) {
				personaggio.getInventario().getOggetti().remove(oggetto);

				Equipaggiamento equip = personaggio.getEquip();
				if (equip == null) {
					equip = new Equipaggiamento();
					equip.setOggetti(new ArrayList<>());
					equip.setPersonaggio(personaggio);
					BusinessLogic.aggiungiEquipaggiamento(equip);
					personaggio.setEquip(equip);
				}
				
				equip.getOggetti().add(oggetto);
				oggetto.setEquipaggiamento(equip);

				BusinessLogic.modificaEquipaggiamento(equip);
				BusinessLogic.modificaPersonaggio(personaggio);

				response.sendRedirect(request.getContextPath() + "/DettagliPersonaggioServlet?idPersonaggio=" + idPersonaggio);
			} else {
				request.setAttribute("messaggio", "Oggetto non presente nell'inventario");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "Personaggio o Oggetto non trovati");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}
}
