package org.prepuzy.controller.capitolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.model.Capitolo;

@WebServlet("/CapitoloPageServlet")
public class CapitoloPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Capitolo capitolo = (Capitolo) request.getAttribute("capitoloSelezionato");

        if (capitolo != null) {
            request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliCapitolo.jsp").forward(request, response);
        } else {
            response.sendRedirect("ErrorServlet?messaggio=capitolo non trovato");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
