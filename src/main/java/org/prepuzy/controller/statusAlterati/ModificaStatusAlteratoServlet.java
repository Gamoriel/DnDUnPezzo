package org.prepuzy.controller.statusAlterati;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.StatusAlterati;


@WebServlet("/master/ModificaStatusAlteratoServlet")
public class ModificaStatusAlteratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("idStatusAlterato");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                long id = Long.parseLong(idParam);
                StatusAlterati statusAlterato = BusinessLogic.statusById(id);
                if (statusAlterato != null) {
                    request.setAttribute("statusAlterato", statusAlterato);
                    request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaStatusAlterato.jsp").forward(request, response);
                } else {
                	request.setAttribute("messaggio", "Status Alterato non trovato");
                	request.getRequestDispatcher("ErrorServlet").forward(request, response);
                }
            } catch (NumberFormatException e) {
            	request.setAttribute("messaggio", "Errore durante la ricerca" + e.getMessage());
            	request.getRequestDispatcher("ErrorServlet").forward(request, response);
            }
        } else {
        	request.setAttribute("messaggio", "ID non valido");
        	request.getRequestDispatcher("ErrorServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String idParam = request.getParameter("idStatusAlterato");
	        String nome = request.getParameter("nome");
	        String descrizione = request.getParameter("descrizione");

	        if (idParam != null && nome != null && descrizione != null) {
	            try {
	                long id = Long.parseLong(idParam);

	                StatusAlterati statusAlterato = BusinessLogic.statusById(id);

	                if (statusAlterato != null) {
	                    statusAlterato.setNome(nome);
	                    statusAlterato.setDescrizione(descrizione);
	                    BusinessLogic.modificaStatus(statusAlterato);

	                    response.sendRedirect("DettagliStatusAlteratiServlet?idStatusAlterati=" + id);
	                } else {
	                	request.setAttribute("messaggio", "Status Alterato non trovato");
	                	request.getRequestDispatcher("ErrorServlet").forward(request, response);
	                }
	            } catch (NumberFormatException e) {
	            	request.setAttribute("messaggio", "Errore durante la modifica" + e.getMessage());
	            	request.getRequestDispatcher("ErrorServlet").forward(request, response);
	            }
	        } else {
	        	request.setAttribute("messaggio", "ID non valido");
	        	request.getRequestDispatcher("ErrorServlet").forward(request, response);
	        }
	}

}
