package org.prepuzy.controller.personaggio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Personaggio;


@WebServlet("/DettagliMercanteServlet")
public class DettagliMercanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idMercante = Long.parseLong(request.getParameter("idMercante"));

		Personaggio mercante = BusinessLogic.personaggioById(idMercante);
		if (mercante != null) {
			List<OggettiMercante> inventario = BusinessLogic.inventarioMercante(mercante);
			request.setAttribute("mercante", mercante);
			request.setAttribute("inventario", inventario);
			request.getRequestDispatcher("WEB-INF/private_jsp/DettagliMercante.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Mercante non trovato");
			request.getRequestDispatcher("ErrorServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idMercante = Long.parseLong(request.getParameter("idMercante"));
		Personaggio mercante = BusinessLogic.personaggioById(idMercante);
		List<OggettiMercante> inventario = BusinessLogic.inventarioMercante(mercante);
		for (OggettiMercante invOggetto : inventario) {
			String prezzoModificato = request.getParameter("prezzo_" + invOggetto.getOggetto().getId());
			if (prezzoModificato != null) {
				long nuovoPrezzo = Long.parseLong(prezzoModificato);
				BusinessLogic.aggiornaPrezzo(invOggetto, nuovoPrezzo);
			}
		}
		response.sendRedirect("DettagliMercanteServlet?idMercante=" + idMercante);
	}

}
