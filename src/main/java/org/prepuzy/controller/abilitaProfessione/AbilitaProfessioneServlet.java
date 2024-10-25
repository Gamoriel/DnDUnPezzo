package org.prepuzy.controller.abilitaProfessione;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prepuzy.businesslogic.BusinessLogic;
import org.prepuzy.model.AbilitaProfessione;


@WebServlet("/master/AbilitaProfessioneServlet")
public class AbilitaProfessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AbilitaProfessione> abilitaList = BusinessLogic.listaAbilitaProfessione();

        Map<String, List<AbilitaProfessione>> abilitaPerProfessione = abilitaList.stream().collect(Collectors.groupingBy(abilita -> abilita.getProfessione().getNome()));
        
        request.setAttribute("abilitaPerProfessione", abilitaPerProfessione);
        request.getRequestDispatcher("/WEB-INF/private_jsp/AbilitaProfessione.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
