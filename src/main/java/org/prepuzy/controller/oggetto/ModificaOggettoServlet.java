package org.prepuzy.controller.oggetto;

import java.io.IOException;
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

@WebServlet("/master/ModificaOggettoServlet")
public class ModificaOggettoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String idOggettoStr = request.getParameter("idOggetto");

        if (idOggettoStr != null && !idOggettoStr.isEmpty()) {
            try {
                long idOggetto = Long.parseLong(idOggettoStr);
                Oggetto oggetto = BusinessLogic.oggettoById(idOggetto);

                if (oggetto != null) {
                    List<Resistenza> resistenze = BusinessLogic.listaResistenze();
                    List<Razza> razze = BusinessLogic.listaRazze();
                    List<Professione> professioni = BusinessLogic.listaProfessioni();
                    List<StatusAlterati> status = BusinessLogic.listaStatusAlterati();
                    List<Tipologia> tipologie = BusinessLogic.listTipologie();

                    request.setAttribute("oggetto", oggetto);
                    request.setAttribute("resistenze", resistenze);
                    request.setAttribute("razze", razze);
                    request.setAttribute("professioni", professioni);
                    request.setAttribute("status", status);
                    request.setAttribute("tipologie", tipologie);

                    request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaOggetto.jsp").forward(request, response);
                } else {
                   request.getRequestDispatcher("/ErrorServlet?messaggio=Oggetto non trovato").forward(request, response);
                }
            } catch (NumberFormatException e) {
               request.getRequestDispatcher("/ErrorServlet?messaggio=ID Oggetto non valido").forward(request, response);
            }
        } else {
           request.getRequestDispatcher("/ErrorServlet?messaggio=ID Oggetto non fornito").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idOggettoStr = request.getParameter("idOggetto");
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");descrizione = descrizione.replace("\n", "<br>");
        String prezzoStr = request.getParameter("prezzo");
        String[] resistenzeIds = request.getParameterValues("resistenze");
        String[] razzeIds = request.getParameterValues("razze");
        String[] professioniIds = request.getParameterValues("professioni");
        String[] statusIds = request.getParameterValues("status");
        String tipologiaIdStr = request.getParameter("tipologia");
        boolean isVisibleToAll = request.getParameter("isVisibleToAll") != null;

        String forzaStr = request.getParameter("forza");
        String destrezzaStr = request.getParameter("destrezza");
        String costituzioneStr = request.getParameter("costituzione");
        String intelligenzaStr = request.getParameter("intelligenza");
        String saggezzaStr = request.getParameter("saggezza");
        String carismaStr = request.getParameter("carisma");
        String hpStr = request.getParameter("hp");
        String pesoStr = request.getParameter("peso");

        if (idOggettoStr != null && nome != null && descrizione != null && prezzoStr != null) {
            try {
                long idOggetto = Long.parseLong(idOggettoStr);
                int prezzo = Integer.parseInt(prezzoStr);
                int forza = Integer.parseInt(forzaStr);
                int destrezza = Integer.parseInt(destrezzaStr);
                int costituzione = Integer.parseInt(costituzioneStr);
                int intelligenza = Integer.parseInt(intelligenzaStr);
                int saggezza = Integer.parseInt(saggezzaStr);
                int carisma = Integer.parseInt(carismaStr);
                int hp = Integer.parseInt(hpStr);
                int peso = Integer.parseInt(pesoStr);
                int classeArmatura = Integer.parseInt(request.getParameter("classeArmatura"));

                Oggetto oggetto = BusinessLogic.oggettoById(idOggetto);

                if (oggetto != null) {
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
                    oggetto.setResistenze(BusinessLogic.getEntitiesByIds(Resistenza.class, resistenzeIds));
                    oggetto.setRazze(BusinessLogic.getEntitiesByIds(Razza.class, razzeIds));
                    oggetto.setProfessioni(BusinessLogic.getEntitiesByIds(Professione.class, professioniIds));
                    oggetto.setStatus(BusinessLogic.getEntitiesByIds(StatusAlterati.class, statusIds));
                    oggetto.setClasseArmatura(classeArmatura);
                    oggetto.setVisibleToAll(isVisibleToAll);

                    if (tipologiaIdStr != null && !tipologiaIdStr.isEmpty()) {
                        long tipologiaId = Long.parseLong(tipologiaIdStr);
                        Tipologia tipologia = BusinessLogic.trovaTopologiaById(tipologiaId);
                        oggetto.setTipologia(tipologia);
                    }

                    BusinessLogic.aggiornaOggetto(oggetto);
                   response.sendRedirect(request.getContextPath() + "/DettagliOggettoServlet?id=" + idOggetto);
                } else {
                   request.getRequestDispatcher("/ErrorServlet?messaggio=Oggetto non trovato").forward(request, response);
                }
            } catch (NumberFormatException e) {
               request.getRequestDispatcher("/ErrorServlet?messaggio=Errore nei valori numerici").forward(request, response);
            }
        } else {
           request.getRequestDispatcher("/ErrorServlet?messaggio=Parametri mancanti o non validi").forward(request, response);
        }
    }
}
