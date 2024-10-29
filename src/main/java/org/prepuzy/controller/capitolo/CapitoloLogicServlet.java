package org.prepuzy.controller.capitolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Capitolo;

@WebServlet("/CapitoloLogicServlet")
public class CapitoloLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String capitoloIdStr = request.getParameter("portaACapitolo");

        if (capitoloIdStr != null && !capitoloIdStr.isEmpty()) {
            try {
                long capitoloId = Integer.parseInt(capitoloIdStr);

                Capitolo capitolo = BusinessLogic.cercaConId(capitoloId);
                if (capitolo != null) {
                    request.setAttribute("capitoloSelezionato", capitolo);
                    request.getRequestDispatcher("CapitoloPageServlet").forward(request, response);
                } else {
                   request.getRequestDispatcher("/ErrorServlet?messaggio=Capitolo non trovato").forward(request, response);
                }
            } catch (NumberFormatException e) {
               request.getRequestDispatcher("/ErrorServlet?messaggio=ID non valido").forward(request, response);
            }
        } else {
           request.getRequestDispatcher("/ErrorServlet?messaggio=Nessun capitolo selezionato").forward(request, response);
        }
	}
}
