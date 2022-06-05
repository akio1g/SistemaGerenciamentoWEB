<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Adicionar Usuario</title>
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
		<form action="UsuarioAdicionar" method="post" class="form">
			<div class="posicionarCheck">
			<h2>Adicionar Usuario</h2>
			<div class="bordaTabelaAdicionar">
					<input type="text" class="tabelaAdicionar" id="nome" name="nome" placeholder="Nome"> 
					<input type="text" class="tabelaAdicionar" id="login_usuario" name="login_usuario" placeholder="CPF">
					<input type="text" class="tabelaAdicionar" id="senha_usuario" name="senha_usuario" placeholder="Telefone">
					<input type="text" class="tabelaAdicionar" id="email" name="email" placeholder="Email">
					<input type="text" class="tabelaAdicionar" id="tipoDeUsuario"  name="tipoDeUsuario" placeholder="tipoDeUsuario">
				</div>
			</div>
			<div class="botoes">
				<input type="submit" id="botaoAdicionar" name="botaoAdicionar" value="Adicionar">
				<a href="GerenciarUsuario" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
	
</body>

</html>
