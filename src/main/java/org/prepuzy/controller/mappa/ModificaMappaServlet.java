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
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Mappa;
import org.prepuzy.model.Personaggio;

@MultipartConfig
@WebServlet("/master/ModificaMappaServlet")
public class ModificaMappaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idMappa = Long.parseLong(request.getParameter("idMappa"));

		Mappa mappa = BusinessLogic.cercaMappaConId(idMappa);

		List<Personaggio> personaggiDisponibili = BusinessLogic.listaPersonaggi();
		List<Mappa> mappeDisponibili = BusinessLogic.listaMappe();
		List<Capitolo> capitoliDisponibili = BusinessLogic.mostraCapitoli();

		request.setAttribute("mappa", mappa);
		request.setAttribute("personaggiDisponibili", personaggiDisponibili);
		request.setAttribute("mappeDisponibili", mappeDisponibili);
		request.setAttribute("capitoliDisponibili", capitoliDisponibili);

		request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaMappa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long idMappa = Long.parseLong(request.getParameter("idMappa"));
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
		Part immaginePart = request.getPart("immagine");
		boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

		Mappa mappa = BusinessLogic.cercaMappaConId(idMappa);
		if (mappa == null) {
			request.setAttribute("messaggio", "Mappa non trovata.");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
			return;
		}

		aggiornaMappa(mappa, nome, descrizione, isVisibleToAll, immaginePart, request, response);

		gestisciPersonaggiEMappe(mappa, request);

		BusinessLogic.modificaMappa(mappa);
		request.setAttribute("idMappa", idMappa);
		request.getRequestDispatcher("/DettagliMappaServlet").forward(request, response);
	}

	private void aggiornaMappa(Mappa mappa, String nome, String descrizione, boolean isVisibleToAll, Part immaginePart,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		mappa.setNome(nome);
		mappa.setDescrizione(descrizione);
		mappa.setVisibleToAll(isVisibleToAll);

		if (immaginePart != null && immaginePart.getSize() > 0) {
			String fileName = System.currentTimeMillis() + "_"
					+ Paths.get(immaginePart.getSubmittedFileName()).getFileName().toString();
			String uploadDir = getServletContext().getRealPath("/uploads");
			File uploadDirFile = new File(uploadDir);
			if (!uploadDirFile.exists()) {
				uploadDirFile.mkdirs();
			}

			String filePath = uploadDir + File.separator + fileName;
			try {
				immaginePart.write(filePath);
				mappa.setImmagine("uploads/" + fileName);
			} catch (IOException e) {
				request.setAttribute("errorMessage", "Errore durante il caricamento dell'immagine.");
				request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaMappa.jsp").forward(request, response);
				throw e;
			}
		}
	}

	private void gestisciPersonaggiEMappe(Mappa mappa, HttpServletRequest request) {
		String[] personaggiIds = request.getParameterValues("personaggi");
		List<Personaggio> nuoviPersonaggi = new ArrayList<>();
		if (personaggiIds != null) {
			for (String idPersonaggio : personaggiIds) {
				Personaggio personaggio = BusinessLogic.personaggioById(Long.parseLong(idPersonaggio));
				if (personaggio != null) {
					nuoviPersonaggi.add(personaggio);
				}
			}
		}
		mappa.setPersonaggi(nuoviPersonaggi);

		long idCapitolo = Long.parseLong(request.getParameter("capitolo"));
		if (idCapitolo != -1) {
			Capitolo capitolo = BusinessLogic.cercaConId(idCapitolo);
			mappa.setCapitolo(capitolo);
		} else {
			mappa.setCapitolo(null);
		}

		String[] mappeIds = request.getParameterValues("mappe");
		List<Mappa> mappeAssociate = new ArrayList<>();
		if (mappeIds != null) {
			for (String idMappaAssociata : mappeIds) {
				Mappa mappaAssociata = BusinessLogic.cercaMappaConId(Long.parseLong(idMappaAssociata));
				if (mappaAssociata != null) {
					mappeAssociate.add(mappaAssociata);
				}
			}
		}
		mappa.setMappe(mappeAssociate);
	}
}
