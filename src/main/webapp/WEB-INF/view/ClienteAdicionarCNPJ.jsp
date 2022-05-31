<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Adicionar Cliente</title>
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
		<form action="ClienteAdicionarCNPJ" method="post" class="form">
			<div class="posicionarCheck">
				<div class="bordaTabelaAdicionar">
					<input type="text" class="tabelaAdicionar" placeholder="Razao Social"> 
					<input type="text" class="tabelaAdicionar" placeholder="CNPJ">
					<input type="text" class="tabelaAdicionar" placeholder="Telefone">
					<input type="text" class="tabelaAdicionar" placeholder="Email">
					<input type="text" class="tabelaAdicionar" placeholder="CEP">
					<input type="text" class="tabelaAdicionar" placeholder="Logradouro">
					<input type="text" class="tabelaAdicionar" placeholder="Numero">
					<input type="text" class="tabelaAdicionar" placeholder="Complemento">
					<input type="text" class="tabelaAdicionar" placeholder="Cidade">
					<input type="text" class="tabelaAdicionar" placeholder="Estado">
				</div>
			</div>
			<div class="botoes">
				<input type="submit" class="categoriasChaves" id="botaoAdicionar" name="botaoAdicionar" value="Adicionar">
				<a href="ClienteAdicionar" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
	
</body>

</html>
