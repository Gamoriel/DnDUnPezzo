<%@page import="java.util.Set"%>
<%@ page import="org.prepuzy.model.Professione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Professioni</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar">
        </div>
    </nav>

    <div class="container">
        <div class="leftBar">
            <h2>Collegamenti</h2>
            <ul>
				<li><a href="MasterPageServlet">Capitoli</a></li>
				<li><a href="CiurmaServlet">Ciurma</a></li>
				
				<li><a href="FruttiServlet">Frutti</a></li>
				<li><a href="MappeServlet">Mappe</a></li>
				<li><a href="NaviServlet">Navi</a></li>
				<li><a href="OggettiServlet">Oggetti</a></li>
				<li><a href="PersonaggiServlet">Personaggi</a></li>
				<li><a href="ProfessioniServlet">Professioni</a></li>
				<li><a href="RazzaServlet">Razze</a></li>
				<li><a href="ResistenzeServlet">Resistenze</a></li>
				<li><a href="StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="TipiServlet">Tipo Frutti</a></li>
				<li><a href="QualitaServlet">Qualità Frutti</a></li>
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
            </ul>
        </div>

        <div class="centerBar">
            <h1>Lista Professioni</h1>

            <%
            Set<Professione> listaProfessioni = (Set<Professione>) request.getAttribute("professioni");
            if (listaProfessioni != null && !listaProfessioni.isEmpty()) {
                for (Professione professione : listaProfessioni) {
            %>
            <div class="professioneCard">
                <h2><%= professione.getNome() %></h2>
                <p><%= professione.getDescrizione() %></p>
                <form action="DettagliProfessioneServlet" method="get">
                    <input type="hidden" name="idProfessione" value="<%= professione.getId() %>">
                    <button class="buttonMod" type="submit">Dettagli Professione</button>
                </form>
            </div>
            <%
                }
            } else {
            %>
            <p>Nessuna professione trovata.</p>
            <%
            }
            %>

            <div class="addNew">
                <form action="AggiungiProfessioneServlet" method="get">
                    <button type="submit" class="btnAdd">Aggiungi Professione</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
