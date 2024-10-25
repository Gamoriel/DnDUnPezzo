package org.prepuzy.controller.mappa;

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
import org.prepuzy.model.Mappa;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;


@WebServlet("/MappeServlet")
public class MappeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	    Utente loggedUser = (Utente) session.getAttribute("loggedUser");
		
		try {
			List<Mappa> listaMappe = new ArrayList<>();
			if(loggedUser != null) {
				
				if(loggedUser.getRole() == Role.MASTER) {
					listaMappe = BusinessLogic.listaMappe();	
				} else {
					listaMappe = BusinessLogic.mostraMappeVisibilitaUtenteBase();
				}
			} else {
				request.getRequestDispatcher("Login").forward(request, response);
			}

			request.setAttribute("listaMappe", listaMappe);
			request.getRequestDispatcher("/WEB-INF/private_jsp/Mappe.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("ErrorServlet?=Errore durante il recupero delle mappe.").forward(request, response);
		}
	}

}
