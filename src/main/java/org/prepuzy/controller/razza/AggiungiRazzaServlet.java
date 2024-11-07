package org.prepuzy.controller.razza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Razza;


@WebServlet("/master/AggiungiRazzaServlet")
public class AggiungiRazzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiRazza.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");

        Razza razza = new Razza();
        razza.setNome(nome);
        razza.setDescrizione(descrizione);
        
        BusinessLogic.aggiungiRazza(razza);
       request.getRequestDispatcher("/RazzaServlet").forward(request, response);
	}

}
