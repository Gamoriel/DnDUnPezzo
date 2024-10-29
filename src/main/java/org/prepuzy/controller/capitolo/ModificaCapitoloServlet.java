package org.prepuzy.controller.capitolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Mappa;

@WebServlet("/master/ModificaCapitoloServlet")
public class ModificaCapitoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCapitoloStr = request.getParameter("idCapitolo");
        
        if (idCapitoloStr != null) {
            try {
                long idCapitolo = Long.parseLong(idCapitoloStr);
                Capitolo capitolo = BusinessLogic.cercaConId(idCapitolo);

                if (capitolo != null) {
                    request.setAttribute("capitolo", capitolo);
                    request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaCapitolo.jsp").forward(request, response);
                } else {
                   request.getRequestDispatcher("/ErrorServlet?messaggio=Capitolo non trovato").forward(request, response);
                }
            } catch (NumberFormatException e) {
               request.getRequestDispatcher("/ErrorServlet?messaggio=ID non valido").forward(request, response);
            }
        } else {
           request.getRequestDispatcher("/ErrorServlet?messaggio=ID del capitolo mancante").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCapitoloStr = request.getParameter("idCapitolo");
        String nuovoTitolo = request.getParameter("nuovoTitolo");
        String nuovoTesto = request.getParameter("nuovoTesto");
        String nuovaMappa = request.getParameter("nuovaMappa");
        boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

        if (idCapitoloStr != null && nuovoTitolo != null && nuovoTesto != null && nuovaMappa != null) {
        	long idCapitolo = Long.parseLong(idCapitoloStr);
        	long idMappa = Long.parseLong(nuovaMappa);
        	Mappa m = BusinessLogic.cercaMappaConId(idMappa);
        	Capitolo c = BusinessLogic.cercaConId(idCapitolo);
        	c.setTesto(nuovoTesto);
        	c.setTitolo(nuovoTitolo);
        	c.setMappa(m);
        	c.setVisibleToAll(isVisibleToAll);
            try {
                BusinessLogic.modificaCapitoloConMappa(c, m);
               request.getRequestDispatcher("/MasterPageServlet?message=Capitolo modificato con successo").forward(request, response);
            } catch (Exception e) {
               request.getRequestDispatcher("/ErrorServlet?messaggio=Errore nella modifica del capitolo").forward(request, response);
            }
        } else {
           request.getRequestDispatcher("/ErrorServlet?messaggio=Dati mancanti per la modifica").forward(request, response);
        }
	}

}
