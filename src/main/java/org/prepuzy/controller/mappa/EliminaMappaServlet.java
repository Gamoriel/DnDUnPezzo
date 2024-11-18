package org.prepuzy.controller.mappa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaMappaServlet")
public class EliminaMappaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method not supported for this action");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {
	    long idMappa = Long.parseLong(request.getParameter("idMappa"));
	    BusinessLogic.eliminaMappa(idMappa);
	    response.sendRedirect(request.getContextPath() + "/MappeServlet");
	} catch (NumberFormatException e) {

	    request.setAttribute("messaggio", "ID della mappa non valido.");
	    request.getRequestDispatcher("/ErrorServlet").forward(request, response);
	} catch (Exception e) {

	    request.setAttribute("messaggio", "Errore durante l'eliminazione della mappa.");
	    request.getRequestDispatcher("/ErrorServlet").forward(request, response);
	}
    }

}
