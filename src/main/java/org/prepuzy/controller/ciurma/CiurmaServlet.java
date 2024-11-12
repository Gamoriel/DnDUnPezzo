package org.prepuzy.controller.ciurma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebServlet("/CiurmaServlet")
public class CiurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	    Utente loggedUser = (Utente) session.getAttribute("loggedUser");
	    List<Ciurma> listaCiurme = new ArrayList<Ciurma>();
	    
	    if(loggedUser != null) {	    	
	    	if(loggedUser.getRole() == Role.MASTER) {	    	
	    		listaCiurme = BusinessLogic.listaCiurme();
	    	} else {
	    		listaCiurme = BusinessLogic.mostraCiurmaVisibilitaUtenteBase();
	    	}
	    } else {
	    	request.getRequestDispatcher("Login").forward(request, response);
	    }
	    

		request.setAttribute("listaCiurme", listaCiurme);
		request.getRequestDispatcher("/WEB-INF/private_jsp/Ciurme.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
