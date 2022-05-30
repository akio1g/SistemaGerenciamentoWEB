<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Gerenciar Usuarios</title>
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
		<form action="GerenciarUsuarios" method="post" class="form">
			<input type="text" class="inputPesquisa" placeholder="Digite sua pesquisa">
			<table class="table">	
						<thead>
							<tr>
								<th></th>
								<th>Usu�rios</th>
							</tr>
						</thead>
						<tbody class="nomes">
							<c:forEach var="usuario" items="${listaUsuarios}">
								<tr>
									<td><button>editar</button></td>
									<td><c:out value="${usuario.nome}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				<div class="botoes">
					<a href="ClienteAdicionar">Adicionar</a>
					<a href="ClienteEditar">Editar</a>
					<a href="Home">Voltar</a>
				</div>
		</form>
	</div>
</body>

</html>
