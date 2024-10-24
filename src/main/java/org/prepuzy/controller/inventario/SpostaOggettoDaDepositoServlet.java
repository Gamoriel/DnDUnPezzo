package org.prepuzy.controller.inventario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

@WebServlet("/SpostaOggettoDaDepositoServlet")
public class SpostaOggettoDaDepositoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPersonaggio = Integer.parseInt(request.getParameter("idPersonaggio"));
		int idOggetto = Integer.parseInt(request.getParameter("idOggetto"));

		Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);

		Oggetto oggetto = BusinessLogic.oggettoById(idOggetto);
		Nave nave = personaggio.getNave();

		if (nave != null && oggetto != null) {
			nave.getDeposito().getOggetti().remove(oggetto);
			personaggio.getInventario().getOggetti().add(oggetto);

			BusinessLogic.modificaPersonaggio(personaggio);
			BusinessLogic.modificaNave(nave);
		}

		response.sendRedirect("DettagliPersonaggioServlet?idPersonaggio=" + idPersonaggio);
	}

}
