<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="org.prepuzy.model.Capitolo"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Mappa</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
    </nav>

    <div class="container">
        <h1>Modifica Mappa</h1>

        <%
        Mappa mappa = (Mappa) request.getAttribute("mappa");
        Set<Personaggio> personaggiDisponibili = (Set<Personaggio>) request.getAttribute("personaggiDisponibili");
        Set<Mappa> mappeDisponibili = (Set<Mappa>) request.getAttribute("mappeDisponibili");
        Set<Capitolo> capitoliDisponibili = (Set<Capitolo>) request.getAttribute("capitoliDisponibili");
        Set<Personaggio> personaggiAssociati = mappa.getPersonaggi();
        %>

        <form action="ModificaMappaServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="idMappa" value="<%= mappa.getId() %>">

            <label for="nome">Nome Mappa:</label>
            <input type="text" name="nome" value="<%= mappa.getNome() %>"><br><br>

            <label for="descrizione">Descrizione:</label>
            <textarea name="descrizione" rows="4" cols="50"><%= mappa.getDescrizione() %></textarea><br><br>

            <label for="immagine">Carica Nuova Immagine:</label>
            <input type="file" name="immagine"><br><br>
            <p>Immagine attuale:</p>
            <img src="<%= mappa.getImmagine() %>" alt="Immagine della mappa" width="200"><br><br>

            <label for="personaggi">Personaggi associati:</label><br>
            <%
            for (Personaggio p : personaggiDisponibili) {
                boolean isChecked = personaggiAssociati.contains(p);
            %>
            <input type="checkbox" name="personaggi" value="<%= p.getId() %>" <%= isChecked ? "checked" : "" %>> 
            <%= p.getNome() %><br>
            <%
            }
            %>

            <label for="capitolo">Capitolo associato:</label>
            <select name="capitolo">
                <option value="-1">Nessun capitolo associato</option>
                <%
                for (Capitolo c : capitoliDisponibili) {
                    boolean isSelected = (mappa.getCapitolo() != null && mappa.getCapitolo().getId() == c.getId());
                %>
                <option value="<%= c.getId() %>" <%= isSelected ? "selected" : "" %>><%= c.getTitolo() %></option>
                <%
                }
                %>
            </select><br><br>

            <label for="mappe">Mappe associate:</label><br>
            <%
            for (Mappa m : mappeDisponibili) {
                boolean isChecked = mappa.getMappe().contains(m);
            %>
            <input type="checkbox" name="mappe" value="<%= m.getId() %>" <%= isChecked ? "checked" : "" %>> 
            <%= m.getNome() %><br>
            <%
            }
            %>

            <br>
           <button type="submit" class="btnSave">Salva Modifiche</button>
        </form>
    </div>
</body>
</html>
