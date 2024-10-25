package org.prepuzy.controller;

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
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebServlet("/MasterPageServlet")
public class MasterPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    Utente loggedUser = (Utente) session.getAttribute("loggedUser");

	    List<Capitolo> listaCapitoli = new ArrayList<>();
		
		if(loggedUser != null) {
			if (loggedUser.getRole() == Role.MASTER) {
				listaCapitoli = BusinessLogic.mostraCapitoli();
			} else {
				listaCapitoli = BusinessLogic.mostraCapitoliVisibilitaUtenteBase();
			}
		}
		request.setAttribute("listaCapitoli", listaCapitoli);
		request.getRequestDispatcher("/WEB-INF/private_jsp/MasterHomePage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
