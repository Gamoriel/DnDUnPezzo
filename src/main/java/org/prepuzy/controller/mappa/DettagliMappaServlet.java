package org.prepuzy.controller.mappa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Mappa;

@WebServlet("/DettagliMappaServlet")
public class DettagliMappaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idMappaParam = request.getParameter("idMappa");
        Long idMappa = null;

        if (idMappaParam != null) {
            try {
                idMappa = Long.parseLong(idMappaParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("messaggio", "ID mappa non valido");
            	request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
                return;
            }
        }

        Mappa mappa = BusinessLogic.cercaMappaConId(idMappa);

        if (mappa == null) {
        	request.setAttribute("messaggio", "Mappa non trovata");
        	request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
            return;
        }

        request.setAttribute("mappa", mappa);
        request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliMappa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
