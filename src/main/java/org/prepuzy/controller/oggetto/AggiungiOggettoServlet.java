package org.prepuzy.controller.oggetto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Razza;
import org.prepuzy.model.Resistenza;
import org.prepuzy.model.StatusAlterati;
import org.prepuzy.model.Tipologia;


@WebServlet("/master/AggiungiOggettoServlet")
public class AggiungiOggettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaResistenze", BusinessLogic.listaResistenze());
		request.setAttribute("listaRazze", BusinessLogic.listaRazze());
		request.setAttribute("listaProfessioni", BusinessLogic.listaProfessioni());
		request.setAttribute("listaStatus", BusinessLogic.listaStatusAlterati());
		request.setAttribute("listaTipologie", BusinessLogic.listTipologie());

		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiOggetto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		int forza = Integer.parseInt(request.getParameter("forza"));
		int destrezza = Integer.parseInt(request.getParameter("destrezza"));
		int costituzione = Integer.parseInt(request.getParameter("costituzione"));
		int intelligenza = Integer.parseInt(request.getParameter("intelligenza"));
		int saggezza = Integer.parseInt(request.getParameter("saggezza"));
		int carisma = Integer.parseInt(request.getParameter("carisma"));
		int hp = Integer.parseInt(request.getParameter("hp"));
		int peso = Integer.parseInt(request.getParameter("peso"));
		int classeArmatura = Integer.parseInt(request.getParameter("classeArmatura"));
		boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

		Oggetto oggetto = new Oggetto();
		
		if(nome != null && descrizione != null && !nome.isEmpty() && !descrizione.isEmpty()) {
			oggetto.setNome(nome);
			oggetto.setDescrizione(descrizione);
			oggetto.setPrezzo(prezzo);
			oggetto.setForza(forza);
			oggetto.setDestrezza(destrezza);
			oggetto.setCostituzione(costituzione);
			oggetto.setIntelligenza(intelligenza);
			oggetto.setSaggezza(saggezza);
			oggetto.setCarisma(carisma);
			oggetto.setHp(hp);
			oggetto.setPeso(peso);
			oggetto.setClasseArmatura(classeArmatura);
			oggetto.setVisibleToAll(isVisibleToAll);
		} else {
            request.setAttribute("errorMessage", "Devi riempire tutti i campi.");
            request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiOggetto.jsp").forward(request, response);
		}

		String[] resistenzeIds = request.getParameterValues("resistenze");
		List<Resistenza> resistenze = new ArrayList<>();
		if (resistenzeIds != null) {
			for (String id : resistenzeIds) {
				long resistenzaId = Long.parseLong(id);
				Resistenza resistenza = BusinessLogic.resistenzaById(resistenzaId);
				resistenze.add(resistenza);
			}
		}
		oggetto.setResistenze(resistenze);

		String[] razzeIds = request.getParameterValues("razze");
		List<Razza> razze = new ArrayList<>();
		if (razzeIds != null) {
			for (String id : razzeIds) {
				long razzaId = Long.parseLong(id);
				Razza razza = BusinessLogic.razzaById(razzaId);
				razze.add(razza);
			}
		}
		oggetto.setRazze(razze);

		String[] professioniIds = request.getParameterValues("professioni");
		List<Professione> professioni = new ArrayList<>();
		if (professioniIds != null) {
			for (String id : professioniIds) {
				long professioneId = Long.parseLong(id);
				Professione professione = BusinessLogic.professioneById(professioneId);
				professioni.add(professione);
			}
		}
		oggetto.setProfessioni(professioni);

		String[] statusIds = request.getParameterValues("status");
		List<StatusAlterati> status = new ArrayList<>();
		if (statusIds != null) {
			for (String id : statusIds) {
				long statusId = Long.parseLong(id);
				StatusAlterati statusAlterato = BusinessLogic.statusById(statusId);
				status.add(statusAlterato);
			}
		}
		oggetto.setStatus(status);

		long tipologiaId = Long.parseLong(request.getParameter("tipologia"));
		Tipologia tipologia = BusinessLogic.trovaTopologiaById(tipologiaId);
		oggetto.setTipologia(tipologia);

		BusinessLogic.aggiungiOggetto(oggetto);
		response.sendRedirect(request.getContextPath() + "/OggettiServlet");
	}

}
