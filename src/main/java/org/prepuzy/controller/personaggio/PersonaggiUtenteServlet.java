package org.prepuzy.controller.personaggio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Personaggio;

@WebServlet("/PersonaggiUtenteServlet")
public class PersonaggiUtenteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Personaggio> personaggi = BusinessLogic.listaPersonaggiUtente();
	if (personaggi == null) {
	    request.setAttribute("messaggio", "Nessun personaggio presente");
	    request.getRequestDispatcher("/ErrorServlet").forward(request, response);
	}
	request.setAttribute("personaggi", personaggi);
	request.getRequestDispatcher("/WEB-INF/private_jsp/PersonaggiUtente.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
