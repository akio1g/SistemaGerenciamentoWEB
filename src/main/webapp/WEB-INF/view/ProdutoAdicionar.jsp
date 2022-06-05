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
			<%--<li><a href="Relatorios">Relátorios</a></li>--%>
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
					<input type="text" class="tabelaAdicionar" id="categoria"  name="categoria" placeholder="Categoria">
				</div>
			</div>
			<div class="botoes">
				<input type="submit" id="botao" name="botaoSalvar" value="Salvar">
				<a href="Produto">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
