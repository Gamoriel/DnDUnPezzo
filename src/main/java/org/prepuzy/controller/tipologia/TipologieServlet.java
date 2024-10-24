package org.prepuzy.controller.tipologia;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Tipologia;

@WebServlet("/TipologieServlet")
public class TipologieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Tipologia> listaTipologie = BusinessLogic.listTipologie();
            request.setAttribute("listaTipologie", listaTipologie);
            request.getRequestDispatcher("WEB-INF/private_jsp/Tipologie.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("ErrorServlet?=Errore durante il recupero delle tipologie" + e.getMessage()).forward(request, response);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
