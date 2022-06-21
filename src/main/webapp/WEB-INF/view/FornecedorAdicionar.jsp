<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Adicionar Fornecedor</title>
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
		<form action="FornecedorAdicionar" method="post" class="form">
			<div class="posicionarCheck">
				<h2>Adicionar Fornecedor</h2>
				<div class="bordaTabelaAdicionar">
					<input type="text" class="tabelaAdicionar" id="razaoSocial" name="razaoSocial" placeholder="razaoSocial"> 
					<input type="text" class="tabelaAdicionar" id="cnpj" name="cnpj" placeholder="cnpj">
					<input type="text" class="tabelaAdicionar" id="inscricaoEstadual" name="inscricaoEstadual" placeholder="inscricaoEstadual">
					<input type="text" class="tabelaAdicionar" id="telefone" name="telefone" placeholder="telefone">
					<input type="text" class="tabelaAdicionar" id="CEP"  name="CEP" placeholder="CEP">
					<input type="text" class="tabelaAdicionar" id="Logradouro" name="Logradouro" placeholder="Logradouro">
					<input type="text" class="tabelaAdicionar" id="Numero"  name="Numero" placeholder="Numero">
					<input type="text" class="tabelaAdicionar" id="Complemento" name="Complemento" placeholder="Complemento">
					<input type="text" class="tabelaAdicionar" id="Cidade" name="Cidade" placeholder="Cidade">
					<input type="text" class="tabelaAdicionar" id="Estado" name="Estado" placeholder="Estado">
				</div>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<input type="submit" id="botao" name="botaoAdicionar" value="Adicionar">
				<a href="Fornecedores">Voltar</a>
			</div>
		</form>
	</div>
</body>

</html>
