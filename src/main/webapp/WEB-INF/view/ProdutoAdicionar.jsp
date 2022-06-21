<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css"
		href='<c:url value="./resources/css/styles.css"/>'>
	<title>Adicionar Produto</title>
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
		<form action="ProdutoAdicionar" method="post" class="form">
			<div class="posicionarCheck">
				<h2>Adicionar Produto</h2>
				<div class="bordaTabelaAdicionar">
					<input type="text" class="tabelaAdicionar" id="Nome" name="Nome" placeholder="Nome">
					<input type="text" class="tabelaAdicionar" id="Descricao" name="Descricao" placeholder="Descricao">
					<input type="text" class="tabelaAdicionar" id="ncmSh" name="ncmSh" placeholder="ncmSh">
					<input type="text" class="tabelaAdicionar" id="preco" name="preco"placeholder="Preço">
					<label class="dropbox" for="Fornecedor">Fornecedor</label>
						<select class="selectDrop"name="fornecedor" id="fornecedor">
						<c:forEach var="fornecedor" items="${listaFornecedores}">
						  <option value="${fornecedor.razaoSocial}"><c:out value="${fornecedor.razaoSocial}"></c:out></option>
						</c:forEach>
						</select>
					<label class="dropbox" for="Categoria">Categoria</label>
						<select class="selectDrop"name="categoria" id="categoria">
							<c:forEach var="categoria" items="${listaCategorias}">
							  	<option value="${categoria.nome}"><c:out value="${categoria.nome}"></c:out></option>
							</c:forEach>
						</select>
				</div>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<input type="submit" id="botao" name="botaoSalvar" value="Salvar">
				<a href="ProdutoListar">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
