<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Tipologia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Tipologie</title>
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
        <h1>Lista delle Tipologie</h1>
            <%
            Set<Tipologia> tipologie = (Set<Tipologia>) request.getAttribute("listaTipologie");
            if (tipologie != null && !tipologie.isEmpty()) {
                for (Tipologia tipologia : tipologie) {
            %>
            <div class="tipologiaCard">
                <h2><%= tipologia.getNome() %></h2>
                <form action="EliminaTipologiaServlet" method="get">
                    <input type="hidden" name="idTipologia" value="<%= tipologia.getId() %>">
                    <button type="submit" class="buttonDel">Elimina tipologia</button>
                </form>
            </div>
            <%
                }
            } else {
            %>
            <p>Nessuna tipologia disponibile</p>
            <%
            }
            %>
            <div class="addNew">
                <form action="AggiungiTipologiaServlet" method="get">
                    <button type="submit" class="btnAdd">Aggiungi Tipologia</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
