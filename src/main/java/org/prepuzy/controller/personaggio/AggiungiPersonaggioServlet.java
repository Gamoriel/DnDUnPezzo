package org.prepuzy.controller.personaggio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
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
	
	List<Razza> razze = BusinessLogic.listaRazze();
	razze.sort(Comparator.comparing(Razza::getNome));
	List<Professione> professioni = BusinessLogic.listaProfessioni();
	professioni.sort(Comparator.comparing(Professione::getNome));
	List<Ciurma> ciurme = BusinessLogic.listaCiurme();
	ciurme.sort(Comparator.comparing(Ciurma::getNome));
	List<Nave> navi = BusinessLogic.listaNavi();
	navi.sort(Comparator.comparing(Nave::getNome));
	List<Mappa> mappe = BusinessLogic.listaMappe();
	mappe.sort(Comparator.comparing(Mappa::getNome));

	request.setAttribute("listaRazze", razze);
	request.setAttribute("listaProfessioni", professioni);
	request.setAttribute("listaCiurme", ciurme);	
	request.setAttribute("listaNavi", navi);
	request.setAttribute("listaMappe", mappe);
	request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiPersonaggio.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String nome = request.getParameter("nome");
	String soprannome = request.getParameter("soprannome");
	String descrizione = request.getParameter("descrizione");
	descrizione = descrizione.replace("\n", "<br>");
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
	
	List<String> urlImmagineList = new ArrayList<>();
	List<String> tagliaImg = new ArrayList<>();

	String uploadDir = getServletContext().getRealPath("/uploads");
	File uploadDirFile = new File(uploadDir);
	if (!uploadDirFile.exists()) {
	    uploadDirFile.mkdirs();
	}

	for (Part part : request.getParts()) {
	    if (part.getSize() > 0) {
		String partName = part.getName();
		if (part.getSubmittedFileName() != null) {
		    String fileName = System.currentTimeMillis() + "_"
			    + Paths.get(part.getSubmittedFileName()).getFileName().toString();
		    File file = new File(uploadDir + File.separator + fileName);

		    try {
			part.write(file.getAbsolutePath());
			if ("immagine".equals(partName)) {
			    urlImmagineList.add("uploads/" + fileName);
			} else if ("taglia".equals(partName)) {
			    tagliaImg.add("uploads/" + fileName);
			}

		    } catch (IOException e) {
			request.setAttribute("errorMessage", "Errore durante il caricamento dell'immagine.");
			request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiPersonaggio.jsp").forward(request,
				response);
			return;
		    }
		}
	    }
	}
	personaggio.setUrlImmagine(urlImmagineList);
	personaggio.setTaglia(tagliaImg);

	if (nome != null && descrizione != null && !nome.isEmpty() && !descrizione.isEmpty() && soprannome != null
		&& !soprannome.isEmpty()) {
	    personaggio.setNome(nome);
	    personaggio.setSoprannome(soprannome);
	    personaggio.setDescrizione(descrizione);
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
	    request.getRequestDispatcher("/WEB-INF/private_jsp/AggiungiPersonaggio.jsp").forward(request, response);
	}


	String[] professioneIds = request.getParameterValues("professione");
	if (professioneIds != null && professioneIds.length > 0) {
	    List<Professione> professioniSelezionate = new ArrayList<>();
	    for (String professioneIdStr : professioneIds) {
		long professioneId = Long.parseLong(professioneIdStr);
		Professione professione = BusinessLogic.professioneById(professioneId);
		if (professione != null) {
		    professioniSelezionate.add(professione);
		}
	    }
	    personaggio.setProfessioni(professioniSelezionate);
	}

	String ciurmaStr = request.getParameter("ciurma");
	if (ciurmaStr != null && !ciurmaStr.isEmpty()) {
	    long ciurmaId = Long.parseLong(ciurmaStr);
	    personaggio.setCiurma(BusinessLogic.cercaCiurmaConId(ciurmaId));
	}

	String naveStr = request.getParameter("nave");
	if (naveStr != null && !naveStr.isEmpty()) {
	    long naveId = Long.parseLong(request.getParameter("nave"));
	    personaggio.setNave(BusinessLogic.naveById(naveId));
	}

	String[] mappaIds = request.getParameterValues("mappa");
	if (mappaIds != null && mappaIds.length > 0) {
	    List<Mappa> mappeSelezionate = new ArrayList<>();
	    for (String mappaIdStr : mappaIds) {
		long mappaId = Long.parseLong(mappaIdStr);
		Mappa mappa = BusinessLogic.cercaMappaConId(mappaId);
		if (mappa != null) {
		    mappeSelezionate.add(mappa);
		}
	    }
	    personaggio.setMappe(mappeSelezionate);
	}
	
	String razzaStr = request.getParameter("razza");
	if (razzaStr != null & !razzaStr.isEmpty()) {
	    long razzaId = Long.parseLong(razzaStr);
	    personaggio.setRazza(BusinessLogic.razzaById(razzaId));
	}
	
	personaggio.setUtente(utenteLoggato);
	
	List<Personaggio> personaggi = utenteLoggato.getPersonaggi();
	if (personaggi == null) {
	    personaggi = new ArrayList<>();
	}
	if (utenteLoggato.getRole().equals(Role.BASE)) {
	    personaggio.setVisibleToAll(true);
	}
	personaggi.add(personaggio);
	utenteLoggato.setPersonaggi(personaggi);
	BusinessLogic.aggiungiPersonaggio(personaggio);
	response.sendRedirect(request.getContextPath() + "/PersonaggiServlet");
    }
}
