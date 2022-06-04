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
			<div class="posicionarCheck">
				<div class="bordaTabelaAdicionar">
					<input type="hidden" id="id" name="Id" value="${cliente.id}">
					<input type="text" class="tabelaAdicionar" id="Nome" name="Nome" value="<c:out value="${cliente.nomeRazaoSocial}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="CNPJ" name="CNPJ" value="<c:out value="${cliente.cpfCnpj}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Telefone" name="Telefone" value="<c:out value="${cliente.telefone}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Email" name="Email" value="<c:out value="${cliente.email}"></c:out>">
					
					<input type="text" class="tabelaAdicionar" id="CEP"  name="CEP" value="<c:out value="${endereco.cep}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Logradouro" name="Logradouro" value="<c:out value="${endereco.logradouro}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Numero" name="Numero" value="<c:out value="${endereco.numero}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Complemento" name="Complemento" value="<c:out value="${endereco.complemento}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Cidade" name="Cidade" value="<c:out value="${endereco.cidade}"></c:out>">
					<input type="text" class="tabelaAdicionar" id="Estado" name="Estado" value="<c:out value="${endereco.estado}"></c:out>">
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
