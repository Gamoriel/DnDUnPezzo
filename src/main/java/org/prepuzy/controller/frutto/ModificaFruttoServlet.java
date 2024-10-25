package org.prepuzy.controller.frutto;

import java.io.IOException;
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

@WebServlet("/master/ModificaFruttoServlet")
public class ModificaFruttoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idFruttoStr = request.getParameter("idFrutto");

        if (idFruttoStr != null && !idFruttoStr.isEmpty()) {
            try {
                long idFrutto = Long.parseLong(idFruttoStr);

                Frutto frutto = BusinessLogic.trovaFruttoById(idFrutto);

                if (frutto != null) {
                    List<Tipo> tipi = BusinessLogic.listaTipi();
                    List<Qualita> qualita = BusinessLogic.listaQualita();
                    List<StatusAlterati> status = BusinessLogic.listaStatusAlterati();
                    List<Resistenza> resistenze = BusinessLogic.listaResistenze();
                    List<AbilitaFrutto> abilita = BusinessLogic.listaAbilitaFrutto();
                    
                    request.setAttribute("frutto", frutto);
                    request.setAttribute("tipi", tipi);
                    request.setAttribute("qualita", qualita);
                    request.setAttribute("status", status);
                    request.setAttribute("resistenze", resistenze);
                    request.setAttribute("listaAbilita", abilita);
                    request.getRequestDispatcher("/WEB-INF/private_jsp/ModificaFrutto.jsp").forward(request, response);
                } else {
                	request.setAttribute("messaggio", "Frutto non trovato");
                    request.getRequestDispatcher("ErrorServlet").forward(request, response);
                }
            } catch (NumberFormatException e) {
            	request.setAttribute("messaggio", "ID Frutto non valido");
            	request.getRequestDispatcher("ErrorServlet").forward(request, response);
            }
        } else {
        	request.setAttribute("messaggio", "ID Frutto non fornito");
        	request.getRequestDispatcher("ErrorServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idFruttoStr = request.getParameter("idFrutto");
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        String prezzoStr = request.getParameter("prezzo");
        String tipoIdStr = request.getParameter("tipo");
        String qualitaIdStr = request.getParameter("qualita");
        String[] resistenzeIds = request.getParameterValues("resistenze");
        String[] statusIds = request.getParameterValues("status");
        String[] abilitaIds = request.getParameterValues("abilita");
        String forzaStr = request.getParameter("forza");
        String destrezzaStr = request.getParameter("destrezza");
        String costituzioneStr = request.getParameter("costituzione");
        String intelligenzaStr = request.getParameter("intelligenza");
        String saggezzaStr = request.getParameter("saggezza");
        String carismaStr = request.getParameter("carisma");
        String hpStr = request.getParameter("hp");
        String isVisibleToAllStr = request.getParameter("isVisibleToAll");
        boolean isVisibleToAll = "on".equals(isVisibleToAllStr);

        if (idFruttoStr != null && nome != null && descrizione != null && prezzoStr != null) {
            try {
                long idFrutto = Long.parseLong(idFruttoStr);
                int prezzo = Integer.parseInt(prezzoStr);

                Frutto frutto = BusinessLogic.trovaFruttoById(idFrutto);

                if (frutto != null) {
                    frutto.setNome(nome);
                    frutto.setDescrizione(descrizione);
                    frutto.setPrezzo(prezzo);

                    if (tipoIdStr != null && !tipoIdStr.isEmpty()) {
                        long tipoId = Long.parseLong(tipoIdStr);
                        Tipo tipo = BusinessLogic.tipoById(tipoId);
                        frutto.setTipo(tipo);
                    }

                    if (qualitaIdStr != null && !qualitaIdStr.isEmpty()) {
                        long qualitaId = Long.parseLong(qualitaIdStr);
                        Qualita qualita = BusinessLogic.qualitaById(qualitaId);
                        frutto.setQualita(qualita);
                    }

                    frutto.setResistenza(BusinessLogic.getEntitiesByIds(Resistenza.class, resistenzeIds));
                    frutto.setStatus(BusinessLogic.getEntitiesByIds(StatusAlterati.class, statusIds));
                    frutto.setAbilita(BusinessLogic.getEntitiesByIds(AbilitaFrutto.class, abilitaIds));
                    frutto.setForza(parseInteger(forzaStr));
                    frutto.setDestrezza(parseInteger(destrezzaStr));
                    frutto.setCostituzione(parseInteger(costituzioneStr));
                    frutto.setIntelligenza(parseInteger(intelligenzaStr));
                    frutto.setSaggezza(parseInteger(saggezzaStr));
                    frutto.setCarisma(parseInteger(carismaStr));
                    frutto.setHp(parseInteger(hpStr));
                    frutto.setVisibleToAll(isVisibleToAll);


                    BusinessLogic.modificaFrutto(frutto);

                    response.sendRedirect("DettagliFruttoServlet?idFrutto=" + idFrutto);
                } else {
                    response.sendRedirect("ErrorServlet.jsp?error=Frutto non trovato");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("ErrorServlet.jsp?error=Errore nei valori numerici");
            }
        } else {
            response.sendRedirect("ErrorServlet.jsp?error=Parametri mancanti o non validi");
        }
    }

    private int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
