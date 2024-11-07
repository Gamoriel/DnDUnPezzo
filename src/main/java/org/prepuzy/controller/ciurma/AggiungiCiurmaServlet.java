package org.prepuzy.controller.ciurma;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;

@MultipartConfig
@WebServlet("/master/AggiungiCiurmaServlet")
public class AggiungiCiurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiCiurma.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
		boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

		Ciurma nuovaCiurma = new Ciurma();

		Part jollyRogerPart = request.getPart("jollyRoger");
		if (jollyRogerPart != null && jollyRogerPart.getSize() > 0) {
			String jollyRogerFileName = System.currentTimeMillis() + "_"
					+ Paths.get(jollyRogerPart.getSubmittedFileName()).getFileName().toString();
			String uploadDir = getServletContext().getRealPath("/uploads");
			File uploadDirFile = new File(uploadDir);
			if (!uploadDirFile.exists()) {
				uploadDirFile.mkdir();
			}

			File file = new File(uploadDir + File.separator + jollyRogerFileName);
			try {
				jollyRogerPart.write(file.getAbsolutePath());
				nuovaCiurma.setNome(nome);
				nuovaCiurma.setDescrizione(descrizione);
				nuovaCiurma.setVisibleToAll(isVisibleToAll);
				nuovaCiurma.setJollyRoger("uploads/" + jollyRogerFileName);
			} catch (IOException e) {
				request.setAttribute("errorMessage",
						"Errore durante il caricamento, controlla di aver popolato tutti i campi.");
				request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiCiurma.jsp").forward(request, response);
				return;
			}
		}

		BusinessLogic.inserisciCiurma(nuovaCiurma);

		request.getRequestDispatcher("/CiurmaServlet").forward(request, response);
	}

}
