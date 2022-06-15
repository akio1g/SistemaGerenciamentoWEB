<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Home</title>
</head>

<body>
	 <form action="Home" method="post" class="form">
		<nav class="menu-lateral">
			<ul>
				<li><a href="Home"><img src="./resources/img/DistribuidoraAMZ.png"></a>
				<li><a href="Produto">Produto</a></li>
				<li><a href="Cliente">Clientes</a></li>
				<li><a href="Estoque">Estoque</a></li>
				<li><a href="RegistroVendas">Registro De Vendas</a></li>
				<li><a href="Fornecedores">Fornecedores</a></li>
				<%--<li><a href="Relatorios">Relátorios</a></li>--%>
				<li><a href="GerenciarUsuarios">Gerenciar Usuários</a></li>
				<li></li>
				<li></li>
			</ul>
		</nav>
			<div class="informacaoEmpresa">
				<h2>DISTRIBUIDORA AMZ</h2>
				<img src="./resources/img/DistribuidoraAMZ.png">
				<input type="submit" class="btn-login" id="desconectar" name="desconectar" value="Desconectar">
			</div>
	</form>
</body>

</html>
