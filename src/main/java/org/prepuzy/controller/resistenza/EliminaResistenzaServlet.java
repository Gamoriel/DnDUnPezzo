package org.prepuzy.controller.resistenza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaResistenzaServlet")
public class EliminaResistenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idResistenzaParam = request.getParameter("idResistenza");
        if (idResistenzaParam != null && !idResistenzaParam.isEmpty()) {
            try {
                long idResistenza = Long.parseLong(idResistenzaParam);
                BusinessLogic.eliminaResistenza(idResistenza);
                response.sendRedirect("ResistenzeServlet");
            } catch (NumberFormatException e) {
            	response.sendRedirect("ErrorServlet?=Errore nell'eliminazione" + e.getMessage());
            }
        } else {
        	response.sendRedirect("ErrorServlet?=Id non valido");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
