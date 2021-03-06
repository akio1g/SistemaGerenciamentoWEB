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
			<li><a href="RelatorioListar">Relátorios</a></li>
			<li><a href="GerenciarUsuarios">Gerenciar Usuários</a></li>
		</ul>
	</nav>
	<div class="formulario">
		<form action="RegistroVendas" method="post" class="form">
			<h2>Lista de Registros de Venda</h2>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>Vendedor</th>
							<th>Cliente</th>
							<th>Valor</th>	
							<th>Data</th>
							<th>Carrinho</th>
						</tr>
					</thead>
					<tbody class="nomes">
						<c:forEach var="Venda" items="${listaVenda}">
							<tr>
								<td><button id="botaoExcluir" name="botaoExcluir" value="${Venda.id}">Excluir</button></td>
								<td><c:out value="${Venda.vendedor}"></c:out></td>
								<td><c:out value="${Venda.cliente}"></c:out></td>
								<td><c:out value="${Venda.valor}"></c:out></td>
								<td><input type="date" id="botaoData" name="botaoData" value="${Venda.data}"></td>
								<td><button id="botaoid" name="botaoid" value="${Venda.id}">Carrinho</button>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<a href="RegistroVendasAdicionar">Adicionar</a>
				<a href="Home">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
