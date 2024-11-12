package org.prepuzy.controller.frutto;

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
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;


@WebServlet("/FruttiServlet")
public class FruttiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    Utente loggedUser = (Utente) session.getAttribute("loggedUser");
	    List<Frutto> listaFrutti = new ArrayList<>();

	    if(loggedUser != null) {
	    	
	    	if(loggedUser.getRole() == Role.MASTER) {	    	
	    		listaFrutti = BusinessLogic.listaFrutti();
	    	} else {
	    		listaFrutti = BusinessLogic.mostraFruttiVisibilitaUtenteBase();
	    	}
	    } else {
	    	request.getRequestDispatcher("Login").forward(request, response);
	    }
		
		request.setAttribute("listaFrutti", listaFrutti);
		request.getRequestDispatcher("/WEB-INF/private_jsp/Frutti.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
