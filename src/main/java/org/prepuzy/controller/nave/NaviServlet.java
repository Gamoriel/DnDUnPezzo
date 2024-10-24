package org.prepuzy.controller.nave;

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
import org.prepuzy.model.Nave;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebServlet("/NaviServlet")
public class NaviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    Utente loggedUser = (Utente) session.getAttribute("loggedUser");
	    List<Nave> navi = new ArrayList<>();
	    
	    if(loggedUser != null) {
	    	
	    	if(loggedUser.getRole() == Role.MASTER) {
	    		navi = BusinessLogic.listaNavi();
	    	} else {
	    		navi = BusinessLogic.mostraNaviVisibilitaUtenteBase();
	    	}
	    } else {
	    	request.getRequestDispatcher("Login").forward(request, response);
	    }
	    
	        request.setAttribute("navi", navi);
	        request.getRequestDispatcher("WEB-INF/private_jsp/Navi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
