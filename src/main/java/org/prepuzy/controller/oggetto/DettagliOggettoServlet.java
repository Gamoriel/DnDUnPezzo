package org.prepuzy.controller.oggetto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Oggetto;


@WebServlet("/DettagliOggettoServlet")
public class DettagliOggettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idOggetto = Long.parseLong(request.getParameter("id"));
        Oggetto oggetto = BusinessLogic.oggettoById(idOggetto);
        
        if (oggetto != null) {
            request.setAttribute("oggetto", oggetto);
            request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliOggetto.jsp").forward(request, response);
        } else {
        	request.setAttribute("messaggio", "Oggetto non trovato");
        	request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
