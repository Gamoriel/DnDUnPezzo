<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dettagli Status Alterato</title>
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
			</ul>
		</div>

        <%
        StatusAlterati statusAlterato = (StatusAlterati) request.getAttribute("statusAlterato");
        if (statusAlterato != null) {
        %>
        <div class="statusDetails">
            <h2><%= statusAlterato.getNome() %></h2>
            <p><strong>Descrizione:</strong> <%= statusAlterato.getDescrizione() %></p>

            <form action="ModificaStatusAlteratoServlet" method="get">
                <input type="hidden" name="idStatusAlterato" value="<%= statusAlterato.getId() %>">
                <button type="submit" class="buttonMod">Modifica</button>
            </form>

            <form action="EliminaStatusAlteratoServlet" method="post" onsubmit="return confirm('Sei sicuro di voler eliminare questo status alterato?');">
                <input type="hidden" name="idStatusAlterato" value="<%= statusAlterato.getId() %>">
                <button type="submit" class="buttonDel">Elimina</button>
            </form>
        </div>
        <%
        } else {
        %>
        <p>Status alterato non trovato.</p>
        <%
        }
        %>
    </div>
</body>
</html>
