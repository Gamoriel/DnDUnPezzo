package org.prepuzy.controller.frutto;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Qualita;
import org.prepuzy.model.Resistenza;
import org.prepuzy.model.StatusAlterati;
import org.prepuzy.model.Tipo;

@WebServlet("/master/AggiungiFruttoServlet")
public class AggiungiFruttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tipo> listaTipi = BusinessLogic.listaTipi();
		List<Qualita> listaQualita = BusinessLogic.listaQualita();
		List<StatusAlterati> listaStatus = BusinessLogic.listaStatusAlterati();
		List<Resistenza> listaResistenze = BusinessLogic.listaResistenze();
		List<AbilitaFrutto> listaAbilita = BusinessLogic.listaAbilitaFrutto();
		
		request.setAttribute("listaAbilita", listaAbilita);
		request.setAttribute("listaTipi", listaTipi);
		request.setAttribute("listaQualita", listaQualita);
		request.setAttribute("listaStatus", listaStatus);
		request.setAttribute("listaResistenze", listaResistenze);
		request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiFrutto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        int prezzo = Integer.parseInt(request.getParameter("prezzo"));
        int forza = Integer.parseInt(request.getParameter("forza"));
        int destrezza = Integer.parseInt(request.getParameter("destrezza"));
        int costituzione = Integer.parseInt(request.getParameter("costituzione"));
        int intelligenza = Integer.parseInt(request.getParameter("intelligenza"));
        int saggezza = Integer.parseInt(request.getParameter("saggezza"));
        int carisma = Integer.parseInt(request.getParameter("carisma"));
        int hp = Integer.parseInt(request.getParameter("hp"));
        String isVisibleToAllStr = request.getParameter("isVisibleToAll");
        boolean isVisibleToAll = "on".equals(isVisibleToAllStr);

        long idTipo = Long.parseLong(request.getParameter("tipo"));
        Tipo tipo = BusinessLogic.tipoById(idTipo);

        long idQualita = Long.parseLong(request.getParameter("qualita"));
        Qualita qualita = BusinessLogic.qualitaById(idQualita);

        String[] statusIds = request.getParameterValues("status");
        List<StatusAlterati> statusSet = new ArrayList<>();
        if (statusIds != null) {
            for (String id : statusIds) {
                StatusAlterati status = BusinessLogic.statusById(Long.parseLong(id));
                statusSet.add(status);
            }
        }

        String[] resistenzeIds = request.getParameterValues("resistenze");
        List<Resistenza> resistenzaSet = new ArrayList<>();
        if (resistenzeIds != null) {
            for (String id : resistenzeIds) {
                Resistenza resistenza = BusinessLogic.resistenzaById(Long.parseLong(id));
                resistenzaSet.add(resistenza);
            }
        }
        
        String[] abilitaIds = request.getParameterValues("abilita");
        List<AbilitaFrutto> listaAbilita = new ArrayList<>();
        if (abilitaIds != null) {
            for (String id : abilitaIds) {
                AbilitaFrutto abilitaFrutto = BusinessLogic.abilitaFruttoById(Long.parseLong(id));
                listaAbilita.add(abilitaFrutto);
            }
        }
        
        Frutto frutto = new Frutto();
        frutto.setNome(nome);
        frutto.setDescrizione(descrizione);
        frutto.setPrezzo(prezzo);
        frutto.setForza(forza);
        frutto.setDestrezza(destrezza);
        frutto.setCostituzione(costituzione);
        frutto.setIntelligenza(intelligenza);
        frutto.setSaggezza(saggezza);
        frutto.setCarisma(carisma);
        frutto.setHp(hp);
        frutto.setTipo(tipo);
        frutto.setQualita(qualita);
        frutto.setStatus(statusSet);
        frutto.setResistenza(resistenzaSet);
        frutto.setVisibleToAll(isVisibleToAll);
        frutto.setAbilita(listaAbilita);

        BusinessLogic.aggiungiFrutto(frutto);

       request.getRequestDispatcher("/FruttiServlet").forward(request, response);
	}

}
