package org.prepuzy.controller.nave;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/master/EliminaNaveServlet")
public class EliminaNaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idNave = Long.parseLong(request.getParameter("idNave"));

        boolean eliminata = BusinessLogic.eliminaNave(idNave);

        if (eliminata) {
        	response.sendRedirect(request.getContextPath() + "/NaviServlet");
        } else {
        	request.setAttribute("messaggio", "eliminazione fallita");
        	request.getRequestDispatcher("/ErrorServlet").forward(request, response);  
        }
	}

}
