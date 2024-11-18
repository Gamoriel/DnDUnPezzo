package org.prepuzy.controller.personaggio;

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
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@WebServlet("/TaglieServlet")
public class TaglieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	Utente loggedUser = (Utente) session.getAttribute("loggedUser");

	List<Personaggio> personaggi = new ArrayList<>();
	List<Personaggio> personaggiConTaglia = new ArrayList<>();
	if (loggedUser.getRole() == Role.MASTER) {
	    personaggi = BusinessLogic.listaPersonaggi();
	    for (Personaggio p : personaggi) {
		if (p.getTaglia() != null && p.getTaglia().size() > 0) {
		    personaggiConTaglia.add(p);
		}
	    }
	} else {
	    personaggi = BusinessLogic.mostraPersonaggiVisibilitaUtenteBase();
	    for (Personaggio p : personaggi) {
		if (p.getTaglia().size() > 0) {
		    personaggiConTaglia.add(p);
		}
	    }
	}

	request.setAttribute("personaggi", personaggiConTaglia);
	request.getRequestDispatcher("/WEB-INF/private_jsp/Taglie.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
