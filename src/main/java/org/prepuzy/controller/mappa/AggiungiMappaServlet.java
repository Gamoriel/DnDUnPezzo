package org.prepuzy.controller.mappa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Mappa;

@MultipartConfig
@WebServlet("/AggiungiMappaServlet")
public class AggiungiMappaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mappa> listaMappePadri = BusinessLogic.listaMappe();
        if (listaMappePadri == null) {
            listaMappePadri = new ArrayList<>();
        }
        request.setAttribute("listaMappePadri", listaMappePadri);
        request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiMappa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nome = request.getParameter("nome");
	    String descrizione = request.getParameter("descrizione");
	    boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

	    Mappa mappa = new Mappa();

	    if (nome != null && descrizione != null && !nome.isEmpty() && !descrizione.isEmpty()) {
	        mappa.setNome(nome);
	        mappa.setDescrizione(descrizione);
	        mappa.setVisibleToAll(isVisibleToAll);
	    } else {
	        request.setAttribute("errorMessage", "Devi riempire tutti i campi.");
	        request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiMappa.jsp").forward(request, response);
	        return;
	    }

	    Part immaginePart = request.getPart("immagine");
	    if (immaginePart != null && immaginePart.getSize() > 0) {
	        String immagineFileName = System.currentTimeMillis() + "_" + Paths.get(immaginePart.getSubmittedFileName()).getFileName().toString();
	        String uploadDir = getServletContext().getRealPath("/uploads");
	        System.out.println(uploadDir);
	        File uploadDirFile = new File(uploadDir);
	        if (!uploadDirFile.exists()) {
	            uploadDirFile.mkdir();
	        }

	        File file = new File(uploadDir + File.separator + immagineFileName);
	        try {
	            immaginePart.write(file.getAbsolutePath());
	            
	            mappa.setImmagine("uploads/" +  immagineFileName);
	        } catch (IOException e) {
	            request.setAttribute("errorMessage", "Errore durante il caricamento dell'immagine.");
	            request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiMappa.jsp").forward(request, response);
	            return;
	        }
	    }
	    
	    String idMappaPadreStr = request.getParameter("mappaPadre");
	    if (idMappaPadreStr != null && !idMappaPadreStr.isEmpty()) {
	        try {
	            long idMappaPadre = Long.parseLong(idMappaPadreStr);
	            Mappa mappaPadre = BusinessLogic.cercaMappaConId(idMappaPadre);
	            mappa.setMappaPadre(mappaPadre);
	        } catch (NumberFormatException e) {
	            request.setAttribute("errorMessage", "Errore nell'ID della mappa padre.");
	            request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiMappa.jsp").forward(request, response);
	            return;
	        }
	    }

	    BusinessLogic.aggiungiMappa(mappa);
	    response.sendRedirect("MappeServlet");
	}

}
