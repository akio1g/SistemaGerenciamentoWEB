<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Fornecedores</title>
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
		<form action="Fornecedor" method="post" class="formulario">
			<div>
				<input type="text" class="inputPesquisa" placeholder="Digite sua pesquisa">
				<table class="table">	
					<thead>
						<tr>
							<th></th>
							<th>Nome do Fornecedor</th>
						</tr>
					</thead>
					<tbody class="nomes">
						<c:forEach var="fornecedor" items="${listaFornecedores}">
							<tr>
								<td><input type="checkbox"></td>
								<td><c:out value="${fornecedor.razaoSocial}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<div class="botoes">
				<a href="FornecedorAdicionar">Adicionar</a>
				<a href="FornecedorEditar">Editar</a>
				<a href="Home">Voltar</a>
			</div>
			</div>
		</form>
</body>

</html>
