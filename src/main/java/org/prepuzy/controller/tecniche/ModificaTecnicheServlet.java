package org.prepuzy.controller.tecniche;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Tecniche;


@WebServlet("/master/ModificaTecnicheServlet")
public class ModificaTecnicheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idTecnica = Long.parseLong(request.getParameter("idTecnica"));
		Tecniche t = BusinessLogic.tecnicaById(idTecnica);
		
		if (t != null) {
			List<Personaggio> personaggi = BusinessLogic.listaPersonaggiUtente();
			request.setAttribute("tecnica", t);
			request.setAttribute("listaPersonaggi", personaggi);
			request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaTecnica.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Abilita non trovata");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idTecnica = Long.parseLong(request.getParameter("idTecnica"));
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String[] personaggiVisibiliIds = request.getParameterValues("personaggiVisibili");
		
		Tecniche t = BusinessLogic.tecnicaById(idTecnica);
		t.setNome(nome);
		t.setDescrizione(descrizione);
		List<Personaggio> personaggiVisibili = BusinessLogic.getEntitiesByIds(Personaggio.class, personaggiVisibiliIds);
		t.setVisibileAPersonaggio(personaggiVisibili);
		
		BusinessLogic.modificaTecnica(t);
		request.getRequestDispatcher("/master/TecnicheServlet").forward(request, response);
		
	}

}
