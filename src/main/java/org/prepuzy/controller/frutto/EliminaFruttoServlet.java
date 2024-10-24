package org.prepuzy.controller.frutto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;

@WebServlet("/EliminaFruttoServlet")
public class EliminaFruttoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idFruttoStr = request.getParameter("idFrutto");

        if (idFruttoStr != null && !idFruttoStr.isEmpty()) {
            try {
                long idFrutto = Long.parseLong(idFruttoStr);
                BusinessLogic.eliminaFrutto(idFrutto);
                response.sendRedirect("FruttiServlet");
            } catch (NumberFormatException e) {
                response.sendRedirect("ErrorServlet.jsp?error=ID Frutto non valido");
            }
        } else {
            response.sendRedirect("ErrorServlet.jsp?error=ID Frutto non fornito");
        }
    }
}
