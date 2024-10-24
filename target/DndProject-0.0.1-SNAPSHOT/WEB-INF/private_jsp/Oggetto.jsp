<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Oggetto"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista Oggetti</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
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
            <h1>Lista Oggetti</h1>

            <%
            Set<Oggetto> oggetti = (Set<Oggetto>) request.getAttribute("oggetti");
            if (oggetti != null && !oggetti.isEmpty()) {
            %>
            <div class="oggettoList">
                <%
                for (Oggetto oggetto : oggetti) {
                %>
                <div class="oggettoCard">
                    <h2><%=oggetto.getNome()%></h2>
                    <form action="DettagliOggettoServlet" method="get">
                        <input type="hidden" name="id" value="<%=oggetto.getId()%>">
                        <button type="submit" class="buttonMod">Visualizza Dettagli</button>
                    </form>
                </div>
                <%
                }
                %>
            </div>
            <%
            } else {
            %>
            <p>Nessun oggetto trovato.</p>
            <%
            }
            %>

            <div class="addNew">
                <form action="AggiungiOggettoServlet" method="get">
                    <button type="submit" class="btnAdd">Aggiungi Oggetto</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
