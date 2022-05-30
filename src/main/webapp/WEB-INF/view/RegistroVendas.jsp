<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Registro de Vendas</title>
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
			<%--<li><a href="Relatorios">Rel�torios</a></li>--%>
			<li><a href="GerenciarUsuarios">Gerenciar Usu�rios</a></li>
		</ul>
	</nav>
	<div class="formulario">
		<form action="RegistroVendas" method="post" class="form">
			<div>
				<input type="text" class="inputPesquisa" placeholder="Digite sua pesquisa">
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>ID</th>
							<th>Descri��o da Venda</th>
							<th>Data</th>
							<th>Valor</th>
						</tr>
					</thead>
					<tbody class="nomes">
						<c:forEach var="Venda" items="${listaVenda}">
							<tr>
								<td><input type="submit"><img src="./resources/img/editar"></td>
								<td><c:out value="${Venda.id}"></c:out></td>
								<td><c:out value="${Venda.descricao}"></c:out></td>
								<td><c:out value="${Venda.data}"></c:out></td>
								<td><c:out value="${Venda.valor}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="botoes">
				<a href="VendaVisualizar">Visualizar</a>
				<a href="Home">Voltar</a>
			</div>
		</form>
	</div>
	<!-- MODAL DE VISUALIZAR DETALHAMENTO DA VENDA 
		<table class="table">
			<thead>
				<tr>
					<th>Qtd</th>
					<th>Descri��o do Produto</th>
					<th>Valor Unitario</th>
					<th>Valor Total</th>
				</tr>
			</thead>
			<tbody class="nomes">
				<c:forEach var="Venda" items="${listaVenda}">
					<tr>
						<td><c:out value="${Venda.quantidade}"></c:out></td>
						<td><c:out value="${Venda.descricao}"></c:out></td>
						<td><c:out value="${Venda.valorUnitario}"></c:out></td>
						<td><c:out value="${Venda.valorTotal}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	-->	
</body>

</html>
