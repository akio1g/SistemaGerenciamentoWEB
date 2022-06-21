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
		<form action="ProdutoListar" method="post" class="form">
			<div>
				<h2>Lista de Produtos</h2>
				<input type="text" class="inputPesquisa" id="inputPesquisa" name="inputPesquisa" placeholder="Digite sua pesquisa">
				<table class="table">	
					<thead>
						<tr>
							<th></th>
							<th>Nome do Produto</th>
							<th>Preco</th>
						</tr>
					</thead>
					<tbody class="nomes">
						<c:forEach var="Produto" items="${listaProduto}">
							<tr>
								<td><button id="botaoEditar" name="botaoEditar" value="${Produto.id}">Editar</button></td>
								<td><c:out value="${Produto.nome}"></c:out></td>
								<td><c:out value="${Produto.preco}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<a href="ProdutoAdicionar">Adicionar</a>
				<a href="Produto">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
