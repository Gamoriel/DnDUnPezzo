package org.prepuzy.controller.resistenza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Resistenza;


@WebServlet("/master/AggiungiResistenzaServlet")
public class AggiungiResistenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiResistenza.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");

        Resistenza resistenza = new Resistenza();
        resistenza.setNome(nome);
        resistenza.setDescrizione(descrizione);

        BusinessLogic.aggiungiResistenza(resistenza);

       request.getRequestDispatcher("/ResistenzeServlet").forward(request, response);
	}

}
