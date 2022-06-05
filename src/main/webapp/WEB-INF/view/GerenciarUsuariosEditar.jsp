<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Editar Usuario</title>
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
		<form action="UsuarioEditar" method="post" class="form">
			<div class="posicionarCheck">
				<div class="bordaTabelaAdicionar">
					<input type="hidden" id="id" name="Id" value="${usuario.id}">
		
					<input type="text" class="tabelaAdicionar" id="nome" name="nome" value="<c:out value="${usuario.nome}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="email" name="email" value="<c:out value="${usuario.email}"></c:out>">
						<label for="tipoDeUsuario">Tipo De Usuario</label>
						<select name="tipoDeUsuario" id="tipoDeUsuario">
						  <option value="Administrador">Administrador</option>
						  <option value="Estoquista">Estoquista</option>
						  <option value="Vendedor">Vendedor</option>
						</select>
				</div>
			</div>
			<div class="botoes">
				<input type="submit" class="categoriasChaves" id="botaoSalvar" name="botaoSalvar" value="Salvar">
				<input type="submit" class="categoriasChaves" id="botaoExcluir" name="botaoExcluir" value="Excluir">
				<a href="Cliente" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
	
</body>

</html>
