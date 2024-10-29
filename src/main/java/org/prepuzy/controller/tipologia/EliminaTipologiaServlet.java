package org.prepuzy.controller.tipologia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaTipologiaServlet")
public class EliminaTipologiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTipologiaParam = request.getParameter("idTipologia");

        if (idTipologiaParam != null && !idTipologiaParam.isEmpty()) {
            long idTipologia = Long.parseLong(idTipologiaParam);
            boolean eliminato = BusinessLogic.eliminaTipologia(idTipologia);
            if (eliminato) {
               request.getRequestDispatcher("/master/TipologieServlet").forward(request, response);
            } else {
            	request.setAttribute("messaggio", "Errore durante l'eliminazione della tipologia");
                request.getRequestDispatcher("/ErrorServlet").forward(request, response);
            }
        } else {
        	request.setAttribute("messaggio", "D della tipologia non valido");
            request.getRequestDispatcher("/ErrorServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
