package org.prepuzy.controller.tipologia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/EliminaTipologiaServlet")
public class EliminaTipologiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTipologiaParam = request.getParameter("idTipologia");

        if (idTipologiaParam != null && !idTipologiaParam.isEmpty()) {
            long idTipologia = Long.parseLong(idTipologiaParam);
            boolean eliminato = BusinessLogic.eliminaTipologia(idTipologia);
            if (eliminato) {
                response.sendRedirect("TipologieServlet");
            } else {
                request.getRequestDispatcher("ErrorServlet?=Errore durante l'eliminazione della tipologia").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("ErrorServlet?=ID della tipologia non valido").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
