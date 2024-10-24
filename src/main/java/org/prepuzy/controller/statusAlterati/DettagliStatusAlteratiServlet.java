package org.prepuzy.controller.statusAlterati;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.StatusAlterati;


@WebServlet("/DettagliStatusAlteratiServlet")
public class DettagliStatusAlteratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String idParam = request.getParameter("idStatusAlterati");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                long id = Long.parseLong(idParam);
                StatusAlterati statusAlterato = BusinessLogic.statusById(id);
                if (statusAlterato != null) {
                    request.setAttribute("statusAlterato", statusAlterato);
                    request.getRequestDispatcher("WEB-INF/private_jsp/DettagliStatusAlterato.jsp").forward(request, response);
                } else {
                	request.setAttribute("ErrorServlet","Status Alterato non trovato");
                	request.getRequestDispatcher("ErrorServlet").forward(request, response);
                }
            } catch (NumberFormatException e) {
            	request.setAttribute("ErrorServlet","Errore nella ricerca" + e.getMessage());
            	request.getRequestDispatcher("ErrorServlet").forward(request, response);
            }
        } else {
        	request.setAttribute("ErrorServlet","ID non valido");
        	request.getRequestDispatcher("ErrorServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
