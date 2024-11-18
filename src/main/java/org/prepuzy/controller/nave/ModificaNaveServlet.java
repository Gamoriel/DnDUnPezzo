package org.prepuzy.controller.nave;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Nave;

@MultipartConfig
@WebServlet("/master/ModificaNaveServlet")
public class ModificaNaveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	long idNave = Long.parseLong(request.getParameter("idNave"));
	Nave nave = BusinessLogic.naveById(idNave);
	List<Ciurma> ciurme = BusinessLogic.listaCiurme();

	if (nave != null) {
	    request.setAttribute("nave", nave);
	    request.setAttribute("ciurme", ciurme);
	    request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaNave.jsp").forward(request, response);
	} else {
	    request.setAttribute("messaggio", "Nave non trovata");
	    request.getRequestDispatcher("/ErrorServlet").forward(request, response);
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	long idNave = Long.parseLong(request.getParameter("idNave"));
	String nome = request.getParameter("nome");
	String descrizione = request.getParameter("descrizione");
	descrizione = descrizione.replace("\n", "<br>");
	String hpStr = request.getParameter("hp");
	String classeArmaturaStr = request.getParameter("classeArmatura");
	String idCiurmaStr = request.getParameter("ciurma");
	boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;
	
	if (nome == null || descrizione == null || nome.isEmpty() || descrizione.isEmpty() || hpStr == null || hpStr.isEmpty() || classeArmaturaStr == null || classeArmaturaStr.isEmpty()) {
	    request.setAttribute("errorMessage", "Devi riempire tutti i campi.");
	    request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiNave.jsp").forward(request, response);
	    return;
	}
	
	Nave nave = BusinessLogic.naveById(idNave);
	
	if(idCiurmaStr != null && !idCiurmaStr.isEmpty()) {
	Ciurma ciurma = BusinessLogic.cercaCiurmaConId(Long.parseLong(idCiurmaStr));
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
	
	nave.setNome(nome);
	nave.setDescrizione(descrizione);
	nave.setHp(Integer.parseInt(hpStr));
	nave.setClasseArmatura(Integer.parseInt(classeArmaturaStr));
	nave.setVisibleToAll(isVisibleToAll);
	BusinessLogic.modificaNave(nave);
	response.sendRedirect(request.getContextPath() + "/DettagliNaveServlet?idNave=" + idNave);
    }

}
