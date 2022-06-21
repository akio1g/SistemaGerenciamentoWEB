<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Editar Produto</title>
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
		<form action="ProdutoEditar" method="post" class="form">
			<div class="posicionarCheck">
				<h2>Editar Produto</h2>
				<div class="bordaTabelaAdicionar">
					<input type="hidden" id="Id" name="Id" value="${produto.id}">
					<input type="text" class="tabelaAdicionar" id="Nome" name="Nome" placeholder="Nome" value="<c:out value="${produto.nome}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Descricao" name="Descricao" placeholder="Descricao" value="<c:out value="${produto.descricao}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="ncmSh" name="ncmSh" placeholder="Ncm/Sh" value="<c:out value="${produto.ncmSh}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="preco" name="preco" placeholder="Preço" value="<c:out value="${produto.preco}"></c:out>">
					<input type="text" class="tabelaAdicionar" placeholder="Fornecedor" value="<c:out value="${produto.fornecedor}"></c:out>">

					<label class="dropbox" for="Fornecedor" style="text-align: center;">Fornecedor</label>
						<select class="selectDrop"name="fornecedor" id="fornecedor">
						<option selected="selected">
						<c:forEach var="fornecedor" items="${listaFornecedores}">
						  <option value="${fornecedor.razaoSocial}"><c:out value="${fornecedor.razaoSocial}"></c:out></option>
						</c:forEach>
						</select>
					<label class="dropbox" for="Categoria" style="text-align: center;">Categoria</label>
						<select class="selectDrop"name="categoria" id="categoria">
						<option selected="selected">
						<c:forEach var="categoria" items="${listaCategorias}">
						  <option value="${categoria.nome}"><c:out value="${categoria.nome}"></c:out></option>
						</c:forEach>
						</select>
				</div>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<input type="submit" id="botao" name="botaoSalvar" value="Salvar">
				<input type="submit" id="botao" name="botaoExcluir" value="Excluir">
				<a href="Produto">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
