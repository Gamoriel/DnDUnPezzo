package org.prepuzy.controller.personaggio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

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
import org.prepuzy.model.Mappa;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Razza;
import org.prepuzy.model.Role;
import org.prepuzy.model.Utente;

@MultipartConfig
@WebServlet("/AggiungiPersonaggioServlet")
public class AggiungiPersonaggioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listaRazze", BusinessLogic.listaRazze());
		request.setAttribute("listaProfessioni", BusinessLogic.listaProfessioni());
		request.setAttribute("listaCiurme", BusinessLogic.listaCiurme());
		request.setAttribute("listaNavi", BusinessLogic.listaNavi());
		request.setAttribute("listaMappe", BusinessLogic.listaMappe());
		request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiPersonaggio.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String soprannome = request.getParameter("soprannome");
		String descrizione = request.getParameter("descrizione");
		String abilita = request.getParameter("abilita");
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

		HttpSession session = request.getSession();
		Utente utenteLoggato = (Utente) session.getAttribute("loggedUser");

		Personaggio personaggio = new Personaggio();
		Part immaginePart = request.getPart("immagine");
		if (immaginePart != null && immaginePart.getSize() > 0) {
			String immagineFileName = System.currentTimeMillis() + "_"
					+ Paths.get(immaginePart.getSubmittedFileName()).getFileName().toString();
			String uploadDir = getServletContext().getRealPath("/uploads");
			File uploadDirFile = new File(uploadDir);
			if (!uploadDirFile.exists()) {
				uploadDirFile.mkdir();
			}

			File file = new File(uploadDir + File.separator + immagineFileName);
			try {
				immaginePart.write(file.getAbsolutePath());
				personaggio.setUrlImmagine("uploads/" + immagineFileName);
			} catch (IOException e) {
				request.setAttribute("errorMessage", "Errore durante il caricamento dell'immagine.");
				request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiPersonaggio.jsp").forward(request, response);
				return;
			}
		}

		if (nome != null && descrizione != null && !nome.isEmpty() && !descrizione.isEmpty() && soprannome != null
				&& !soprannome.isEmpty()) {
			personaggio.setNome(nome);
			personaggio.setSoprannome(soprannome);
			personaggio.setDescrizione(descrizione);
			personaggio.setAbilita(abilita);
			personaggio.setForza(forza);
			personaggio.setDestrezza(destrezza);
			personaggio.setCostituzione(costituzione);
			personaggio.setIntelligenza(intelligenza);
			personaggio.setSaggezza(saggezza);
			personaggio.setCarisma(carisma);
			personaggio.setHp(hp);
			personaggio.setClasseArmatura(classeArmatura);
			personaggio.setVisibleToAll(isVisibleToAll);
			personaggio.setMercante(isMercante);
		} else {
			request.setAttribute("errorMessage", "Devi riempire tutti i campi.");
			request.getRequestDispatcher("WEB-INF/private_jsp/AggiungiPersonaggio.jsp").forward(request, response);
		}

		String razzaStr = request.getParameter("razza");
		if (razzaStr != null & !razzaStr.isEmpty()) {
			long razzaId = Long.parseLong(razzaStr);
			Razza razza = BusinessLogic.razzaById(razzaId);
			personaggio.setRazza(razza);
		}

		String professioneStr = request.getParameter("professione");
		if (professioneStr != null & !professioneStr.isEmpty()) {
			long professioneId = Long.parseLong(professioneStr);
			Professione professione = BusinessLogic.professioneById(professioneId);
			personaggio.setProfessione(professione);
		}

		String ciurmaStr = request.getParameter("ciurma");
		if (ciurmaStr != null && !ciurmaStr.isEmpty()) {
			long ciurmaId = Long.parseLong(ciurmaStr);
			Ciurma ciurma = BusinessLogic.cercaCiurmaConId(ciurmaId);
			personaggio.setCiurma(ciurma);
		}

		String naveStr = request.getParameter("nave");
		if (naveStr != null && !naveStr.isEmpty()) {
			long naveId = Long.parseLong(request.getParameter("nave"));
			Nave nave = BusinessLogic.naveById(naveId);
			personaggio.setNave(nave);
		}

		String mappaStr = request.getParameter("mappa");
		if (mappaStr != null & !mappaStr.isEmpty()) {
			long mappaId = Long.parseLong(mappaStr);
			Mappa mappa = BusinessLogic.cercaMappaConId(mappaId);
			personaggio.setMappa(mappa);
		}

		BusinessLogic.aggiungiPersonaggio(personaggio);
		if(utenteLoggato != null && utenteLoggato.getRole().equals(Role.BASE)) {
			if(utenteLoggato.getPersonaggio() == null) {
			utenteLoggato.setPersonaggio(personaggio);
			BusinessLogic.modificaUtente(utenteLoggato);
			} else {
				request.setAttribute("messaggio", "Hai già creato un personaggio");
				request.getRequestDispatcher("ErrorServlet").forward(request, response);
			}
		}
		response.sendRedirect("PersonaggiServlet");
	}
}
