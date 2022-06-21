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
			<li><a href="RelatorioListar">Relátorios</a></li>
			<li><a href="GerenciarUsuarios">Gerenciar Usuários</a></li>
		</ul>
	</nav>
	<div class="formulario">
	<form action="Produto" method="post" class="form">
			<h2>Lista de Categorias</h2>
			<div class="listaBotoesCategoria">
				<c:forEach var="categoria" items="${listaCategorias}">
					<button id="id" name="botaoCategoria" value="${categoria.id}"><c:out value="${categoria.nome}"></c:out></button>
				</c:forEach>
			</div>	
			<c:out value="${erro}"></c:out>
			<div class="botoes">
				<a href="Categorias" class="voltarProduto">Categorias</a>
				<a href="Home" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
