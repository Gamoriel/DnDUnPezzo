<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Tipo"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista Tipi</title>
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
        <h1>Lista Tipi Frutto</h1>
            <%
            Set<Tipo> tipi = (Set<Tipo>) request.getAttribute("tipi");
            if (tipi != null && !tipi.isEmpty()) {
                for (Tipo tipo : tipi) {
            %>
            <div class="tipoCard">
                <h2><%=tipo.getTipo()%></h2>
                <p>Descrizione: <%=tipo.getDescrizione() != null ? tipo.getDescrizione() : "N/A"%></p>
                <form action="EliminaTipoServlet" method="get">
                    <input type="hidden" name="idTipo" value="<%=tipo.getId()%>">
                    <button type="submit" class="buttonDel">Elimina</button>
                </form>
            </div>
            <%
                }
            } else {
            %>
            <p>Nessun tipo disponibile</p>
            <%
            }
            %>

            <div class="addNew">
                <form action="AggiungiTipoServlet" method="get">
                    <button type="submit" class="btnAdd">Aggiungi Tipo</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
