package org.prepuzy.controller.ciurma;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Personaggio;

@WebServlet("/DettagliCiurmaServlet")
public class DettagliCiurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idCiurma = Long.parseLong(request.getParameter("idCiurma"));
        Ciurma ciurma = BusinessLogic.cercaCiurmaConId(idCiurma);

        if (ciurma != null) {
            List<Personaggio> membri = BusinessLogic.membriCiurma(idCiurma);
            request.setAttribute("ciurma", ciurma);
            request.setAttribute("membri", membri);
            request.getRequestDispatcher("/WEB-INF/private_jsp/DettagliCiurma.jsp").forward(request, response);
        } else {
           request.getRequestDispatcher("/CiurmaServlet").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
