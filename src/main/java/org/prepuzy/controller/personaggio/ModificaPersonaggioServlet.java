package org.prepuzy.controller.personaggio;

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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Razza;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@MultipartConfig
@WebServlet("/ModificaPersonaggioServlet")
public class ModificaPersonaggioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));

		Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);

		List<Razza> razze = BusinessLogic.listaRazze();
		List<Professione> professioni = BusinessLogic.listaProfessioni();
		List<Ciurma> ciurme = BusinessLogic.listaCiurme();
		List<Nave> navi = BusinessLogic.listaNavi();
		List<Frutto> frutti = BusinessLogic.listaFrutti();

		HttpSession session = request.getSession();
		Utente loggedUser = (Utente) session.getAttribute("loggedUser");

		if ((loggedUser.getId() == personaggio.getId()) || loggedUser.getRole().equals(Role.MASTER)) {
			request.setAttribute("personaggio", personaggio);
			request.setAttribute("razze", razze);
			request.setAttribute("professioni", professioni);
			request.setAttribute("ciurme", ciurme);
			request.setAttribute("navi", navi);
			request.setAttribute("frutti", frutti);
			request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaPersonaggio.jsp").forward(request, response);
		} else {
			request.setAttribute("messaggio", "Non puoi modificare il personaggio di qualcun'altro, biricchino. Porcaccioddio!");
			request.getRequestDispatcher("/ErrorServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long idPersonaggio = Long.parseLong(request.getParameter("idPersonaggio"));
		String razzaStr = request.getParameter("razza");
		String professioneStr = request.getParameter("professione");
		String naveStr = request.getParameter("nave");
		String fruttoStr = request.getParameter("frutto");
		String nome = request.getParameter("nome");
		String soprannome = request.getParameter("soprannome");
		String descrizione = request.getParameter("descrizione");
		int forza = Integer.parseInt(request.getParameter("forza"));
		int destrezza = Integer.parseInt(request.getParameter("destrezza"));
		int costituzione = Integer.parseInt(request.getParameter("costituzione"));
		int intelligenza = Integer.parseInt(request.getParameter("intelligenza"));
		int saggezza = Integer.parseInt(request.getParameter("saggezza"));
		int carisma = Integer.parseInt(request.getParameter("carisma"));
		int hp = Integer.parseInt(request.getParameter("hp"));
		int classeArmatura = Integer.parseInt(request.getParameter("classeArmatura"));
		boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;
		boolean isMercante = request.getParameter("isMercante") != null;

		Personaggio personaggio = BusinessLogic.personaggioById(idPersonaggio);

		Part filePart = request.getPart("urlImmagine");

		if (razzaStr != null && !razzaStr.isEmpty()) {
			Razza razza = BusinessLogic.razzaById(Long.parseLong(razzaStr));
			personaggio.setRazza(razza);
		} else {
			personaggio.setRazza(null);
		}

		if (professioneStr != null && !professioneStr.isEmpty()) {
			Professione professione = BusinessLogic.professioneById(Long.parseLong(professioneStr));
			personaggio.setProfessione(professione);
		} else {
			personaggio.setProfessione(null);
		}

		if (naveStr != null && !naveStr.isEmpty()) {
			Nave nave = BusinessLogic.naveById(Long.parseLong(naveStr));
			personaggio.setNave(nave);
		} else {
			personaggio.setNave(null);
		}

		if (fruttoStr != null && !fruttoStr.isEmpty()) {
			Frutto frutto = BusinessLogic.trovaFruttoById(Long.parseLong(fruttoStr));
			personaggio.setFrutto(frutto);
		} else {
			personaggio.setFrutto(null);
		}

		if (filePart != null && filePart.getSize() > 0) {
			String immagineFileName = System.currentTimeMillis() + "_"
					+ Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			String uploadDir = getServletContext().getRealPath("/uploads");
			File uploadDirFile = new File(uploadDir);
			if (!uploadDirFile.exists()) {
				uploadDirFile.mkdir();
			}

			File file = new File(uploadDir + File.separator + immagineFileName);
			try {
				filePart.write(file.getAbsolutePath());
				personaggio.setUrlImmagine("uploads/" + immagineFileName);
			} catch (IOException e) {
				request.setAttribute("errorMessage", "Errore durante il caricamento dell'immagine.");
				request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaPersonaggio.jsp").forward(request, response);
				return;
			}
		}

		personaggio.setNome(nome);
		personaggio.setSoprannome(soprannome);
		personaggio.setDescrizione(descrizione);
		personaggio.setVisibleToAll(isVisibleToAll);
		personaggio.setMercante(isMercante);
		personaggio.setForza(forza);
		personaggio.setDestrezza(destrezza);
		personaggio.setCostituzione(costituzione);
		personaggio.setIntelligenza(intelligenza);
		personaggio.setSaggezza(saggezza);
		personaggio.setCarisma(carisma);
		personaggio.setHp(hp);
		personaggio.setClasseArmatura(classeArmatura);
		BusinessLogic.modificaPersonaggio(personaggio);
		request.setAttribute("idPersonaggio", idPersonaggio);
		request.getRequestDispatcher("/DettagliPersonaggioServlet").forward(request, response);
	}

}
