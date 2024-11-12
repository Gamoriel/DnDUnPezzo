package org.prepuzy.controller.inventario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;


@WebServlet("/SpostaOggettoDepositoServlet")
public class SpostaOggettoDepositoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
        String idOggettoStr = request.getParameter("idOggetto");
        
        if(idOggettoStr == null) {
        	request.setAttribute("messaggio", "Nessun oggetto selezionato");
            request.getRequestDispatcher("/ErrorServlet").forward(request, response);
            return;
        }

        Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
        
        if (personaggio.getNave() == null) {
        	request.setAttribute("messaggio", "Nessuna nave associata a questo peronaggio");
            request.getRequestDispatcher("/ErrorServlet").forward(request, response);
        }

        Inventario inventario = personaggio.getInventario();
		Nave nave = BusinessLogic.naveById(personaggio.getNave().getId());

		if (nave != null) {
		    Inventario deposito = nave.getDeposito();

		    if (deposito != null) {
		        Oggetto oggettoDaSpostare = inventario.getOggetti().stream()
		            .filter(o -> o.getId() == Long.parseLong(idOggettoStr))
		            .findFirst()
		            .orElse(null);

		        if (oggettoDaSpostare != null) {
		            inventario.getOggetti().remove(oggettoDaSpostare);
		            deposito.getOggetti().add(oggettoDaSpostare);

		            BusinessLogic.modificaPersonaggio(personaggio);
		            BusinessLogic.modificaNave(nave);
		            response.sendRedirect(request.getContextPath() + "/DettagliPersonaggioServlet?idPersonaggio" + idPersonaggio);
		        } else {
		            request.setAttribute("messaggio", "Oggetto non trovato o deposito pieno");
		            request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		        }
		    } else {
		        request.setAttribute("messaggio", "Deposito non trovato");
		        request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		    }
		} else {
		    request.setAttribute("messaggio", "Nave non trovata");
		    request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}
}
