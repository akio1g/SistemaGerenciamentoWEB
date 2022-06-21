<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Estoque</title>
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
	<form action="Estoque" method="post" class="formulario">
			<div>
				<h2>Estoque</h2>
				<input type="text" class="inputPesquisa" id="inputPesquisa" name="inputPesquisa" placeholder="Digite sua pesquisa">
				<table class="table">	
					<thead>
						<tr>
							<th>Quantidade</th>
							<th>Nome</th>
						</tr>
					</thead>
					<tbody class="nomes">
						<c:forEach var="estoque" items="${listaEstoque}">
							<tr>	
								<td><input style="text-align: center;width: 80px;" type="number" id="idQuantidade" name="quantidade{}" value="<c:out value="${estoque.quantidade}"></c:out>"></td>
								<td><c:out value="${estoque.nome}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:out value="${erro}"></c:out>
				<div class="botoes">
					<input type="submit" id="botaoSalvar" name="botaoSalvar" value="Salvar">
					<a href="Home">Voltar</a>
				</div>
			</div>
		</form>
</body>

</html>
