package org.prepuzy.controller.frutto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Utente;

@WebServlet("/DettagliFruttoServlet")
public class DettagliFruttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String idFruttoStr = request.getParameter("idFrutto");

	        if (idFruttoStr != null && !idFruttoStr.isEmpty()) {
	            try {
	                long idFrutto = Long.parseLong(idFruttoStr);
	                Frutto frutto = BusinessLogic.trovaFruttoById(idFrutto);

	                if (frutto != null) {
	                	HttpSession session = request.getSession();
	                    Utente utenteLoggato = (Utente) session.getAttribute("loggedUser");
	                    
	                    List<AbilitaFrutto> abilitaFruttoUtente = BusinessLogic.abilitaFruttoUtente(utenteLoggato.getId());
	                	
	                    request.setAttribute("abilitaVisibili", abilitaFruttoUtente);
	                	request.setAttribute("frutto", frutto);
	                    request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliFrutto.jsp").forward(request, response);
	                } else {
	                	request.setAttribute("messaggio", "Frutto non trovato");
	                	request.getRequestDispatcher("ErrorServlet").forward(request, response);
	                }
	            } catch (NumberFormatException e) {
	            	request.setAttribute("messaggio", "Frutto non valido");
	            	request.getRequestDispatcher("ErrorServlet").forward(request, response);
	            }
	        } else {
	        	request.setAttribute("messaggio", "Frutto non fornito");
	        	request.getRequestDispatcher("ErrorServlet").forward(request, response);
	        }
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
