package org.prepuzy.controller.ciurma;

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
import org.prepuzy.model.Personaggio;


@MultipartConfig
@WebServlet("/master/ModificaCiurmaServlet")
public class ModificaCiurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long idCiurma = Long.parseLong(request.getParameter("idCiurma"));
		Ciurma ciurma = BusinessLogic.cercaCiurmaConId(idCiurma);

		List<Personaggio> allPersonaggi = BusinessLogic.listaPersonaggi();

		request.setAttribute("ciurma", ciurma);
		request.setAttribute("allPersonaggi", allPersonaggi);

		request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaCiurma.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long idCiurma = Long.parseLong(request.getParameter("idCiurma"));
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

		Ciurma ciurma = new Ciurma();
		ciurma.setId(idCiurma);
		ciurma.setNome(nome);
		ciurma.setVisibleToAll(isVisibleToAll);

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
				ciurma.setJollyRoger("uploads/" +  jollyRogerFileName);
			} catch (IOException e) {
				request.setAttribute("errorMessage", "Errore durante il caricamento dell'immagine.");
				request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaCiurma.jsp").forward(request, response);
				return;
			}
		}

		ciurma.setDescrizione(descrizione);

		String[] personaggiDaRimuovere = request.getParameterValues("personaggiDaRimuovere");
		if (personaggiDaRimuovere != null) {
			for (String id : personaggiDaRimuovere) {
				long idPersonaggio = Long.parseLong(id);
				BusinessLogic.rimuoviPersonaggioDaCiurma(idPersonaggio, idCiurma);
			}
		}

		String[] personaggiDaAggiungere = request.getParameterValues("personaggiDaAggiungere");
		if (personaggiDaAggiungere != null) {
			for (String id : personaggiDaAggiungere) {
				long idPersonaggio = Long.parseLong(id);
				BusinessLogic.aggiungiPersonaggioACiurma(idPersonaggio, idCiurma);
			}
		}

		BusinessLogic.modificaCiurma(ciurma);
		response.sendRedirect("CiurmaServlet");
	}
}