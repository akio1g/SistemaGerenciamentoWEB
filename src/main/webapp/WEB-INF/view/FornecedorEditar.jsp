<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"/>'>
<title>Editar Fornecedor</title>
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
		
		<form action="FornecedorEditar" method="post" class="form">
			<div class="posicionarCheck">
				<h2>Editar Fornecedor</h2>
				<div class="bordaTabelaAdicionar">
					<input type="hidden" id="Id" name="Id" value="${fornecedor.id}">
					<input type="text" class="tabelaAdicionar" id="RazaoSocial" name="RazaoSocial" placeholder="RazaoSocial" value="<c:out value="${fornecedor.razaoSocial}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Cnpj" name="Cnpj" placeholder="Cnpj" value="<c:out value="${fornecedor.cnpj}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Telefone" name="Telefone" placeholder="Telefone" value="<c:out value="${fornecedor.telefone}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="InscricaoEstadual" name="InscricaoEstadual" placeholder="InscricaoEstadual" value="<c:out value="${fornecedor.inscricaoEstadual}"></c:out>">
					
					
					<input type="text" class="tabelaAdicionar" id="CEP"  name="CEP" placeholder="CEP" value="<c:out value="${endereco.cep}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Logradouro" name="Logradouro" placeholder="Logradouro"  value="<c:out value="${endereco.logradouro}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Numero" name="Numero" placeholder="Numero" value="<c:out value="${endereco.numero}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Complemento" name="Complemento" placeholder="Complemento"  value="<c:out value="${endereco.complemento}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Cidade" name="Cidade" placeholder="Cidade" value="<c:out value="${endereco.cidade}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Estado" name="Estado" placeholder="Estado" value="<c:out value="${endereco.estado}"></c:out>">
				</div>
				<c:out value="${erro}"></c:out>
			</div>
			<div class="botoes">
				<input type="submit"  id="botaoSalvar" name="botaoSalvar" value="Salvar">
				<input type="submit"  id="botaoExcluir" name="botaoExcluir" value="Excluir">
				<a href="Fornecedores" class="voltarProduto">Voltar</a>
			</div>
		</form>
	</div>
	
</body>

</html>
