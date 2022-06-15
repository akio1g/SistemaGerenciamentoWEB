<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
   <link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styless.css"/>'>
</head>
<body>
    <header>
        <h1>Tela de Login</h1>

    </header>
    <main>
        <form action="Login" method="post" class="form">
            <section class="inputs-container"> <!-- Onde vai ficar os dois inputs  -->
                <input type="text" id="login" name="login" placeholder="Login do usuário"> <!-- INPUT EMAIL -->

                <div class="password-container"> <!-- CSS -->
                    <input type="password" id="field-password" name="field-password" class="field-password" placeholder="**********"> <!-- INPUT SENHA -->

                </div>
            </section>

            <section CLASS="password-infos"> <!-- Onde vai ficar o lembrar a senha, o checkbox -->
                <a href="LoginReset">Esqueceu sua senha?</a>
            </section>

			<input type="submit" class= "btn-login" id="btn-login" name="btn-login" value="Acessar">
      		<c:out value="${erro}"></c:out>
            <footer>
                <hr> <!-- gerar linha -->
                <span>Ainda não tem uma conta? Solicite ao administrador</span>
            </footer>
        </form>
    </main>
</body>
</html>