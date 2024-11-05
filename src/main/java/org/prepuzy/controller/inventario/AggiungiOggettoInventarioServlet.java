package org.prepuzy.controller.inventario;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

@WebServlet("/AggiungiOggettoInventarioServlet")
public class AggiungiOggettoInventarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idPersonaggioStr = request.getParameter("idPersonaggio");
		String idOggettoStr = request.getParameter("idOggetto");

		if (idPersonaggioStr != null && !idPersonaggioStr.isEmpty() && idOggettoStr != null && !idOggettoStr.isEmpty()) {
			try {
				long idPersonaggio = Long.parseLong(idPersonaggioStr);
				long idOggetto = Long.parseLong(idOggettoStr);

				Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
				Oggetto oggetto = BusinessLogic.oggettoById(idOggetto);

				if (personaggio != null && oggetto != null) {
					Inventario inventario = personaggio.getInventario();
					if (inventario == null) {
						inventario = new Inventario();
						personaggio.setInventario(inventario);
						inventario.setPersonaggio(personaggio);
						BusinessLogic.aggiungiInventario(inventario);
					}

					if (inventario.getOggetti() == null) {
						inventario.setOggetti(new ArrayList<>());
					}
					int pesoAttuale = inventario.getOggetti().stream().mapToInt(Oggetto::getPeso).sum();

					if (pesoAttuale + oggetto.getPeso() <= inventario.getMaxCapienza()) {
						inventario.getOggetti().add(oggetto);
						BusinessLogic.modificaPersonaggio(personaggio);
						if (personaggio.isMercante()) { 
							OggettiMercante oggettiMercante = new OggettiMercante();
							oggettiMercante.setMercante(personaggio);
							oggettiMercante.setOggetto(oggetto);
							BusinessLogic.aggiungiOggettoMercante(oggettiMercante);
						}

						request.getRequestDispatcher("DettagliPersonaggioServlet?idPersonaggio=" + idPersonaggio).forward(request, response);
					} else {
						request.setAttribute("messaggio", "Capacità massima dell'inventario raggiunta. Non puoi aggiungere " + oggetto.getNome());
						request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
					}
				} else {
					request.setAttribute("messaggio", "Personaggio o Oggetto non trovati.");
					request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
				}
			} catch (NumberFormatException e) {
				request.setAttribute("messaggio", "ID non valido. Assicurati di aver selezionato un personaggio e un oggetto correttamente.");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
			}
		} else {
			request.setAttribute("messaggio", "ID del personaggio o dell'oggetto mancante.");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}
}
