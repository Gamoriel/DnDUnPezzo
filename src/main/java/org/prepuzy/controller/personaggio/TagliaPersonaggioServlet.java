package org.prepuzy.controller.personaggio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Personaggio;


@WebServlet("/TagliaPersonaggioServlet")
public class TagliaPersonaggioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
        Personaggio personaggio = BusinessLogic.personaggioConAllInfoById(idPersonaggio);
        		
        if (personaggio != null) {
            request.setAttribute("personaggio", personaggio);
            request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliTagliaPersonaggio.jsp").forward(request, response);
        } else {
        	request.setAttribute("messaggio", "Personaggio non trovato");
        	request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
