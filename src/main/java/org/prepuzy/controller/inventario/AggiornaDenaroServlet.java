package org.prepuzy.controller.inventario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Personaggio;


@WebServlet("/AggiornaDenaroServlet")
public class AggiornaDenaroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPersonaggioStr = request.getParameter("idPersonaggio");
        String denaroStr = request.getParameter("denaro").trim();

        if (idPersonaggioStr != null && denaroStr != null) {
            long idPersonaggio = Long.parseLong(idPersonaggioStr);
            int denaro = Integer.parseInt(denaroStr);

            Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);
            if (personaggio != null) {
                Inventario inventario = personaggio.getInventario();
                if (inventario != null) {
                    inventario.setBerry(denaro);
                    BusinessLogic.modificaPersonaggio(personaggio);
                    response.sendRedirect(request.getContextPath() + "/DettagliPersonaggioServlet?idPersonaggio=" + idPersonaggio);
                } else {
    				request.setAttribute("messaggio", "Inventario non trovato");
    				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
                }
            } else {
				request.setAttribute("messaggio", "Personaggio non trovato");
				request.getRequestDispatcher("/ErrorServlet").forward(request, response);
            }
        } else {
			request.setAttribute("messaggio", "Personaggio non valido");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
        }
	}
}
