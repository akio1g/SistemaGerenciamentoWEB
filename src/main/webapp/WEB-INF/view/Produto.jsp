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
				<button id="id" name="botaoCategoria" value="1">Gorje</button>
				<button id="id" name="botaoCategoria" value="2">Yale</button>
				<button id="id" name="botaoCategoria" value="3">Yale Dupla</button>
				<button id="id" name="botaoCategoria" value="4">Tetra</button>
				<button id="id" name="botaoCategoria" value="5">Pantográficas</button>
				<button id="id" name="botaoCategoria" value="6">Codificadas</button>
				<button id="id" name="botaoCategoria" value="7">Laminas de Segredo</button>
			</div>	
			<div class="botoes">
				<a href="Home" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
