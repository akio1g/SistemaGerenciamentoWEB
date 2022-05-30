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
			<%--<li><a href="Relatorios">Rel�torios</a></li>--%>
			<li><a href="GerenciarUsuarios">Gerenciar Usu�rios</a></li>
		</ul>
	</nav>
	<div class="formulario">
		<form action="ClienteAdicionar" method="post" class="form">
			<div class="posicionarCheck">
				<div class="bordaTabelaAdicionar">
					<input type="checkbox">
					<input type="text" class="tabelaAdicionar" id="Nome" name="Nome" placeholder="Nome"> 
					<input type="text" class="tabelaAdicionar" id="CPF" name="CPF" placeholder="CPF">
					<input type="text" class="tabelaAdicionar" id="Telefone" name="Telefone" placeholder="Telefone">
					<input type="text" class="tabelaAdicionar" id="Email" name="Email" placeholder="Email">
					<input type="text" class="tabelaAdicionar" id="CEP"  name="CEP" placeholder="CEP">
					<input type="text" class="tabelaAdicionar" id="Logradouro" name="Logradouro" placeholder="Logradouro">
					<input type="text" class="tabelaAdicionar" id="Numero"  name="Numero" placeholder="Numero">
					<input type="text" class="tabelaAdicionar" id="Complemento" name="Complemento" placeholder="Complemento">
					<input type="text" class="tabelaAdicionar" id="Cidade" name="Cidade" placeholder="Cidade">
					<input type="text" class="tabelaAdicionar" id="Estado" name="Estado" placeholder="Estado">
				</div>
				<div class="bordaTabelaAdicionar">
					<input type="checkbox">
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
				<input type="submit" id="botao" name="botaoAdicionar" value="Adicionar">
				<a href="Home">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
