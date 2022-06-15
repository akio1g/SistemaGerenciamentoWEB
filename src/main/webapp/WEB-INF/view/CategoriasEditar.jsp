<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Editar Categoria</title>
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
		
		<form action="CategoriasEditar" method="post" class="form">
			<div class="posicionarCheck">
				<h2>Editar Categoria</h2>
				<div class="bordaTabelaAdicionar">
					<input type="hidden" id="id" name="id" value="${categoria.id}">
					<input type="text" class="tabelaAdicionar" id="nome" name="nome" placeholder="Nome da Categoria" value="<c:out value="${categoria.nome}"></c:out>">
				</div>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<input type="submit"  id="botaoSalvar" name="botaoSalvar" value="Salvar">
				<input type="submit"  id="botaoExcluir" name="botaoExcluir" value="Excluir">
				<a href="Categorias" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
	
</body>

</html>
