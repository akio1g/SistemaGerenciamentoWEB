<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Editar Cliente</title>
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
		<form action="ClienteEditar" method="post" class="form">
			<h2>Editar Cliente</h2>
			<div class="posicionarCheck">
				<div class="bordaTabelaAdicionar">
					<input type="hidden" id="id" name="Id" value="${cliente.id}">
					<input type="text" class="tabelaAdicionar" id="Nome" name="Nome" placeholder="Nome" value="<c:out value="${cliente.nomeRazaoSocial}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="CNPJ" name="CNPJ" placeholder="CNPJ/CPF" value="<c:out value="${cliente.cpfCnpj}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Telefone" name="Telefone" placeholder="Telefone" value="<c:out value="${cliente.telefone}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Email" name="Email" placeholder="Email" value="<c:out value="${cliente.email}"></c:out>">
					
					<input type="text" class="tabelaAdicionar" id="CEP"  name="CEP" placeholder="CEP" value="<c:out value="${endereco.cep}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Logradouro" name="Logradouro" placeholder="Logradouro" value="<c:out value="${endereco.logradouro}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Numero" name="Numero" placeholder="Numero" value="<c:out value="${endereco.numero}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Complemento" name="Complemento" placeholder="Complemento" value="<c:out value="${endereco.complemento}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Cidade" name="Cidade" placeholder="Cidade" value="<c:out value="${endereco.cidade}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Estado" name="Estado" placeholder="Estado" value="<c:out value="${endereco.estado}"></c:out>">
				</div>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<input type="submit" id="botaoSalvar" name="botaoSalvar" value="Salvar">
				<input type="submit" id="botaoExcluir" name="botaoExcluir" value="Excluir">
				<a href="Cliente" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
	
</body>

</html>
