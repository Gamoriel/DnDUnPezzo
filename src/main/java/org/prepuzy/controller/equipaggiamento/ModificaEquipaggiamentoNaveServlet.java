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
import org.prepuzy.model.Nave;
import org.prepuzy.model.Oggetto;

@WebServlet("/ModificaEquipaggiamentoNaveServlet")
public class ModificaEquipaggiamentoNaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idNave = Long.parseLong(request.getParameter("idNave"));
		String idOggetto = request.getParameter("idOggetto");

		if (idOggetto == null) {
			request.setAttribute("messaggio", "Nessun oggetto selezionato");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			return;
		}
		Nave nave = BusinessLogic.naveById(idNave);
		Oggetto oggetto = BusinessLogic.oggettoById(idNave);
		
		if (nave != null && oggetto != null) {
			if (nave.getDeposito().getOggetti().contains(oggetto)) {
				nave.getDeposito().getOggetti().remove(oggetto);

				Equipaggiamento equip = nave.getEquip();
				if (equip == null) {
					equip = new Equipaggiamento();
					equip.setOggetti(new ArrayList<>());
					equip.setNave(nave);
					BusinessLogic.aggiungiEquipaggiamento(equip);
					nave.setEquip(equip);
				}
				
				equip.getOggetti().add(oggetto);
				oggetto.setEquipaggiamento(equip);

				BusinessLogic.modificaEquipaggiamento(equip);
				BusinessLogic.modificaNave(nave);

				response.sendRedirect(request.getContextPath() + "/DettaglinaveServlet?idnave=" + idNave);
			} else {
				request.setAttribute("messaggio", "Oggetto non presente nell'inventario");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "Nave o Oggetto non trovati");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}
}
