package org.prepuzy.controller.qualita;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Qualita;

@WebServlet("/master/AggiungiQualitaServlet")
public class AggiungiQualitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiQualita.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qualitaNome = request.getParameter("nome");

        Qualita qualita = new Qualita();
        qualita.setQualita(qualitaNome);

        BusinessLogic.aggiungiQualita(qualita);
        response.sendRedirect(request.getContextPath() + "/master/QualitaServlet");
	}

}
