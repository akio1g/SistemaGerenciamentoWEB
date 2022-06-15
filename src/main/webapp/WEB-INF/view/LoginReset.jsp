<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Redefinir</title>
   <link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styless.css"/>'>
</head>
<body>
    <header>
        <h1>Resetar senha</h1>

    </header>
    <main>
        <form action="LoginReset" method="post" class="form">
            <section class="inputs-container"> <!-- Onde vai ficar os dois inputs  -->
                <input type="text" id="login" name="login" placeholder="Login do usuário"> <!-- INPUT EMAIL -->

                <div class="password-container"> <!-- CSS -->
                   <input type="email" id="field-email" name="field-email" class="field-password" placeholder="email@email.com"> <!-- INPUT SENHA -->
                    </br>
                    <input type="password" id="field-password" name="field-password" class="field-password" placeholder="nova senha"> <!-- INPUT SENHA -->

                </div>
            </section>

			<input type="submit" class= "btn-login" id="btn-salvar" name="btn-salvar" value="Salvar">
			
      		<c:out value="${erro}"></c:out>
        </form>
    </main>
</body>
</html>