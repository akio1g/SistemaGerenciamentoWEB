<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Produto</title>
</head>

<body>
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
		</ul>
	</nav>
	<div class="formulario">
	<form action="Produto" method="post" class="form">
			<div class="listaBotoesCategoria">
				<input type="submit" id="id" name="botaoCategoria" value="Gorje">
				<input type="submit" id="id" name="botaoCategoria" value="Yale">
				<input type="submit" id="id" name="botaoCategoria" value="Yale Dupla">
				<input type="submit" id="id" name="botaoCategoria" value="Tetra">
				<input type="submit" id="id" name="botaoCategoria" value="Pantográficas">
				<input type="submit" id="id" name="botaoCategoria" value="Codificadas">
				<input type="submit" id="id" name="botaoCategoria" value="Lâminas de Segredo">
			</div>	
			<div class="botoes">
				<a href="Home" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
