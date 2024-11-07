package org.prepuzy.controller.nave;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Nave;

@WebServlet("/master/ModificaNaveServlet")
public class ModificaNaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idNave = Long.parseLong(request.getParameter("idNave"));
		Nave nave = BusinessLogic.naveById(idNave);
		List<Ciurma> ciurme = BusinessLogic.listaCiurme();

		if (nave != null) {
			request.setAttribute("nave", nave);
			request.setAttribute("ciurme", ciurme);
			request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaNave.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Nave non trovata");
        	request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long idNave = Long.parseLong(request.getParameter("idNave"));
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
	    String hpParam = request.getParameter("hp");
	    boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

		long idCiurma = Long.parseLong(request.getParameter("ciurma"));
		Ciurma ciurma = BusinessLogic.cercaCiurmaConId(idCiurma);
		
		Nave naveEsistente = BusinessLogic.naveById(idNave);

		Nave nave = naveEsistente;
		if (nome != null && !nome.isEmpty()) {
	        nave.setNome(nome);
	    }
	    if (descrizione != null && !descrizione.isEmpty()) {
	        nave.setDescrizione(descrizione);
	    }
	    if (hpParam != null && !hpParam.isEmpty()) {
	        nave.setHp(Integer.parseInt(hpParam));
	    }
	    nave.setCiurma(ciurma);
	    nave.setVisibleToAll(isVisibleToAll);

		BusinessLogic.modificaNave(nave);
		request.setAttribute("idNave", idNave);
		request.getRequestDispatcher("/DettagliNaveServlet").forward(request, response);
	}

}
