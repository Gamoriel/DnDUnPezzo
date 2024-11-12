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
import org.prepuzy.model.Nave;

@WebServlet("/RimuoviOggEquipNaveServlet")
public class RimuoviOggEquipNaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idNave = Long.parseLong(request.getParameter("idNave"));
		String idOggettoStr = request.getParameter("idOggetto");

		Nave nave = BusinessLogic.naveById(idNave);
		if(idOggettoStr != null && !idOggettoStr.isEmpty()) {			
			Oggetto oggetto = BusinessLogic.oggettoById(Long.parseLong(idOggettoStr));
			if (nave != null && oggetto != null) {
				Equipaggiamento equip = nave.getEquip();
				
				if (equip != null && equip.getOggetti().contains(oggetto)) {
					equip.getOggetti().remove(oggetto);
					oggetto.setEquipaggiamento(null);
					nave.getDeposito().getOggetti().add(oggetto);
					BusinessLogic.modificaEquipaggiamentoNave(equip, nave, oggetto);
					
					response.sendRedirect(request.getContextPath() + "/DettagliNaveServlet?idNave=" + idNave);
				} else {
					request.getRequestDispatcher("/ErrorServlet?messaggio=Oggetto non presente nell'equipaggiamento")
					.forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/ErrorServlet?messaggio=Nave o Oggetto non trovati").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/ErrorServlet?messaggio=Non hai selezionato niente").forward(request, response);
		}

	}

}
