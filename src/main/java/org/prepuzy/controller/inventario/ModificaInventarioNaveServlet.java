package org.prepuzy.controller.inventario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Nave;

@WebServlet("/ModificaBerryNaveServlet")
public class ModificaInventarioNaveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String idNaveStr = request.getParameter("idNave");
	String denaroStr = request.getParameter("berry").trim();

	if (idNaveStr != null && denaroStr != null) {
	    long idNave = Long.parseLong(idNaveStr);
	    int denaro = Integer.parseInt(denaroStr);
	    Nave nave = BusinessLogic.naveById(idNave);

	    if (nave != null) {
		Inventario inventario = nave.getDeposito();
		if (inventario != null) {
		    inventario.setBerry(denaro);
		    BusinessLogic.modificaNave(nave);
		    response.sendRedirect(request.getContextPath() + "/DettagliNaveServlet?idNave=" + idNave);
		} else {
		    request.setAttribute("messaggio", "Inventario non trovato");
		    request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	    } else {
		request.setAttribute("messaggio", "Personaggio non trovato");
		request.getRequestDispatcher("/ErrorServlet").forward(request, response);
	    }
	} else {
	    request.setAttribute("messaggio", "Nave non valida");
	    request.getRequestDispatcher("/ErrorServlet").forward(request, response);
	}
    }

}
