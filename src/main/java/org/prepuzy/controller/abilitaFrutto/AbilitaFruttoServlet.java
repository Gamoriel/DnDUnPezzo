package org.prepuzy.controller.abilitaFrutto;

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
import org.prepuzy.model.AbilitaFrutto;


@WebServlet("/master/AbilitaFruttoServlet")
public class AbilitaFruttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AbilitaFrutto> abilitaList = BusinessLogic.listaAbilitaFrutto();

		Map<String, List<AbilitaFrutto>> abilitaPerFrutto = abilitaList.stream().collect(Collectors.groupingBy(abilita -> {
			        if (abilita.getFrutto() == null || abilita.getFrutto().getNome() == null) {
			            return "Nessun Frutto Associato";
			        } else {
			            return abilita.getFrutto().getNome();
			        }
			    }));
        
        request.setAttribute("abilitaPerFrutto", abilitaPerFrutto);
        request.getRequestDispatcher("/WEB-INF/private_jsp/AbilitaFrutto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
