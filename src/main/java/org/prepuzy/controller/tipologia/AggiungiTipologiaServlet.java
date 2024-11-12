package org.prepuzy.controller.tipologia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Tipologia;

@WebServlet("/master/AggiungiTipologiaServlet")
public class AggiungiTipologiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiTipologia.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        Tipologia nuovaTipologia = new Tipologia();
        nuovaTipologia.setNome(nome);

        BusinessLogic.aggiungiTipologia(nuovaTipologia);
        response.sendRedirect(request.getContextPath() + "/master/TipologieServlet");
	}

}
