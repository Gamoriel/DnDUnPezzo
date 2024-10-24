<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Qualita"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Qualità Frutti</title>
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
            <h1>Lista Qualità</h1>

            <%
            Set<Qualita> listaQualita = (Set<Qualita>) request.getAttribute("listaQualita");
            if (listaQualita != null && !listaQualita.isEmpty()) {
                for (Qualita qualita : listaQualita) {
            %>
            <div class="qualitaCard">
                <h2><%= qualita.getQualita() %></h2>
                <form action="EliminaQualitaServlet" method="get">
                    <input type="hidden" name="idQualita" value="<%= qualita.getId() %>">
                    <button class="buttonMod" type="submit">Elimina Qualità</button>
                </form>
            </div>
            <%
                }
            } else {
            %>
            <p>Nessuna qualità trovata.</p>
            <%
            }
            %>

            <div class="addNew">
                <form action="AggiungiQualitaServlet" method="get">
                    <button type="submit" class="btnAdd">Aggiungi Qualità</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
