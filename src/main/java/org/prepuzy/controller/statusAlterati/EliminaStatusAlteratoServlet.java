package org.prepuzy.controller.statusAlterati;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaStatusAlteratoServlet")
public class EliminaStatusAlteratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("idStatusAlterato");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                long id = Long.parseLong(idParam);
                BusinessLogic.eliminaStatus(id);
                response.sendRedirect(request.getContextPath() + "/StatusAlteratiServlet");
            } catch (NumberFormatException e) {
            	request.setAttribute("messaggio", "Errore durante l'eliminzione"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
            }
        } else {
        	request.setAttribute("messaggio", "ID non valido"); request.getRequestDispatcher("/ErrorServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
