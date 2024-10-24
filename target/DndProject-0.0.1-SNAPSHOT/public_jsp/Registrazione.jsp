<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrazione</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <div class="registerContainer">
        <div class="registerFormWrapper">
            <h1 class="registerTitle">D&D OP</h1>
            <form class="registerForm" action="RegisterLogicServlet" method="POST">
                <div class="formGroup">
                    <label for="usernameFormInput">Username</label>
                    <input type="text" name="usernameFormInput" id="usernameFormInput" placeholder="Inserisci Username..." required>
                </div>
                <div class="formGroup">
                    <label for="passwordFormInput">Password</label>
                    <input type="password" name="passwordFormInput" id="passwordFormInput" placeholder="Inserisci Password..." required>
                </div>
                <input type="hidden" name="action" id="action" value="">
                <div class="formActions">
                    <button type="button" class="btnRegister" onclick="submitForm('registrati')">Registrati</button>
                    <button type="button" class="btnLogin" onclick="submitForm('login')">Ho già un account</button>
                </div>
                <% String message = (String) request.getAttribute("errorMsg");
                if (message != null) { %>
                    <p class="errorMsg"><%= message %></p>
                <% } %>
            </form>
        </div>
    </div>

    <script>
        function submitForm(actionValue) {
            document.getElementById('action').value = actionValue;
            document.querySelector('.registerForm').submit();
        }
    </script>
</body>
</html>
