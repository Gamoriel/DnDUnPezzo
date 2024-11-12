package org.prepuzy.controller.nave;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Nave;


@WebServlet("/master/AggiungiNaveServlet")
public class AggiungiNaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ciurma> listaCiurme = BusinessLogic.listaCiurme();
        request.setAttribute("listaCiurme", listaCiurme);
        request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiNave.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
	    String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
	    long ciurmaId = Long.parseLong(request.getParameter("ciurma"));
	    boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

	    if (nome == null || descrizione == null || nome.isEmpty() || descrizione.isEmpty()) {
	        request.setAttribute("errorMessage", "Devi riempire tutti i campi.");
	        request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiNave.jsp").forward(request, response);
	        return;
	    }
	    Nave nave = new Nave();
	    nave.setNome(nome);
	    nave.setDescrizione(descrizione);
	    nave.setVisibleToAll(isVisibleToAll);

	    Inventario deposito = new Inventario();

	    BusinessLogic.aggiungiInventario(deposito); 

	    nave.setDeposito(deposito);

	    if (ciurmaId > 0) {
	        Ciurma ciurma = BusinessLogic.cercaCiurmaConId(ciurmaId);
	        nave.setCiurma(ciurma);
	    }
	    
		Part navePart = request.getPart("imgNave");
		if (navePart != null && navePart.getSize() > 0) {
			String naveFileName = System.currentTimeMillis() + "_"
					+ Paths.get(navePart.getSubmittedFileName()).getFileName().toString();
			String uploadDir = getServletContext().getRealPath("/uploads");
			File uploadDirFile = new File(uploadDir);
			if (!uploadDirFile.exists()) {
				uploadDirFile.mkdir();
			}

			File file = new File(uploadDir + File.separator + naveFileName);
			navePart.write(file.getAbsolutePath());
			nave.setImmagine("uploads/" + naveFileName);
		} else {
			request.setAttribute("messaggio", "Immagine non valida");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	    BusinessLogic.aggiungiNave(nave);
	    response.sendRedirect(request.getContextPath() + "/NaviServlet");
	}

}
