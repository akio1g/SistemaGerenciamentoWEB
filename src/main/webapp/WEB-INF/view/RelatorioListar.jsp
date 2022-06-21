<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Relatorios</title>
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
			<li><a href="GerenciarUsuarios">Gerenciar Usuarios</a></li>
		</ul>
	</nav>
	<form action="RelatorioListar" method="post" class="formulario">
		<div>
			<h2>Lista de Relatorios</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Registro</th>
						<th>Cliente</th>
						<th>Valor</th>
						<th></th>
					</tr>
				</thead>
				<tbody class="nomes">
					<c:forEach var="relatorio" items="${listaRelatorios}">
						<tr>
							<td><c:out value="${relatorio.id}"></c:out></td>
							<td><c:out value="${relatorio.cliente}"></c:out></td>
							<td><c:out value="${relatorio.valor}"></c:out></td>
							<td><button id="botaoVisualizar" name="botaoVisualizar" value="${relatorio.id}">Visualizar</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>