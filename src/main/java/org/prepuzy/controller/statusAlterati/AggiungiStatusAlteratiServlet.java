package org.prepuzy.controller.statusAlterati;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.StatusAlterati;


@WebServlet("/master/AggiungiStatusAlteratiServlet")
public class AggiungiStatusAlteratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiStatusAlterati.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");

        StatusAlterati statusAlterato = new StatusAlterati();
        statusAlterato.setNome(nome);
        statusAlterato.setDescrizione(descrizione);

        BusinessLogic.aggiungiStatusAlterati(statusAlterato);

       request.getRequestDispatcher("/StatusAlteratiServlet").forward(request, response);
	}

}
