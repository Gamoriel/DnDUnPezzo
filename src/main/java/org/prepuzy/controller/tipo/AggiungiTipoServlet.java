package org.prepuzy.controller.tipo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Tipo;


@WebServlet("/master/AggiungiTipoServlet")
public class AggiungiTipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiTipo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");

        Tipo nuovoTipo = new Tipo();
        nuovoTipo.setTipo(tipo);
        nuovoTipo.setDescrizione(descrizione);

        BusinessLogic.aggiungiTipo(nuovoTipo);
        response.sendRedirect(request.getContextPath() + "/master/TipiServlet");
	}

}
