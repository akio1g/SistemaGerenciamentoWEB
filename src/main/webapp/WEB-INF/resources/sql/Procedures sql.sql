USE DistribuidoraAMZ
												--FUNÇÕES DO CLIENTE--
--******************************************************************************--
GO
CREATE PROC sp_adicionar_cliente @nomeRazaoSocial VARCHAR(max), @CpfCnpj VARCHAR(max), @Telefone VARCHAR(max), 
							     @Email VARCHAR(max), @InscricaoEstadual VARCHAR(max),
							     @Cep VARCHAR(max), @cidade VARCHAR(max), @estado VARCHAR(max), 
							     @logradouro VARCHAR(max), @numero INT, @complemento VARCHAR(max)
AS
	INSERT INTO Cliente VALUES(@nomeRazaoSocial, @CpfCnpj, @Telefone, @Email, @InscricaoEstadual)
	INSERT INTO Endereco VALUES((SELECT id FROM Cliente WHERE cpfCnpj = @CpfCnpj), @Cep, @cidade, @estado, @logradouro, @numero, @complemento)

--******************************************************************************--
GO
CREATE PROC sp_lista_clientes 
AS
	SELECT c.id, c.nomeRazaoSocial, c.cpfCnpj,c.telefone, c.email, c.inscricaoEstadual,
	 e.cep,  e.estado,e.cidade,e.logradouro, e.numero, e.complemento
	 FROM Cliente c INNER JOIN Endereco e ON c.id = e.id_cliente 
--******************************************************************************--
GO
CREATE PROC sp_buscar_cliente_por_nome (@nome VARCHAR(50))
AS
	SELECT * FROM Cliente WHERE nomeRazaoSocial like '%'+@nome+'%'
--******************************************************************************--
GO
CREATE PROC sp_buscar_cliente_por_id(@id INT)
AS
	SELECT * FROM Cliente WHERE id = @id
--******************************************************************************--
GO
CREATE PROC sp_buscar_endereco_por_id_cliente(@id_cliente INT)
AS
	SELECT * FROM Endereco WHERE id_cliente = @id_cliente
--******************************************************************************--
GO
CREATE PROC sp_update_cliente @id INT, @nomeRazaoSocial VARCHAR(max), @CpfCnpj VARCHAR(max), @Telefone VARCHAR(max), 
							  @Email VARCHAR(max), @InscricaoEstadual VARCHAR(max),
							  @Cep VARCHAR(max), @cidade VARCHAR(max), @estado VARCHAR(max), 
							  @logradouro VARCHAR(max), @numero INT, @complemento VARCHAR(max)
AS
	IF (@nomeRazaoSocial != '')
	BEGIN
		UPDATE Cliente SET nomeRazaoSocial = @nomeRazaoSocial WHERE id = @id
	END
	IF (@CpfCnpj != '')
	BEGIN
		UPDATE Cliente SET cpfCnpj = @CpfCnpj WHERE id = @id
	END
	IF (@Telefone != '')
	BEGIN
		UPDATE Cliente SET telefone = @Telefone WHERE id = @id
	END
	IF (@Email != '')
	BEGIN
		UPDATE Cliente SET email = @Email WHERE id = @id
	END
	IF(@InscricaoEstadual != '')
	BEGIN
		UPDATE Cliente SET inscricaoEstadual = @InscricaoEstadual WHERE id = @id
	END
	IF(@Cep != '')
	BEGIN
		UPDATE Endereco SET cep = @Cep WHERE id_cliente = @id
	END
	IF(@cidade != '')
	BEGIN
		UPDATE Endereco SET cidade = @cidade WHERE id_cliente = @id
	END
	IF(@estado != '')
	BEGIN
		UPDATE Endereco SET estado = @estado WHERE id_cliente = @id
	END
	IF(@logradouro != '')
	BEGIN
		UPDATE Endereco SET logradouro = @logradouro WHERE id_cliente = @id
	END
	IF(@numero != '')
	BEGIN
		UPDATE Endereco SET numero = @numero WHERE id_cliente = @id
	END
	IF(@complemento != '')
	BEGIN
		UPDATE Endereco SET complemento = @complemento WHERE id_cliente = @id
	END
--******************************************************************************--
GO
CREATE PROC sp_excluir_cliente(@id_cliente int) 
AS
	BEGIN
		DELETE FROM	Endereco WHERE id_cliente = @id_cliente		
		DELETE FROM Cliente WHERE id = @id_cliente
	END





													--FUNÇÕES DO FORNECEDOR--
--******************************************************************************--
GO
CREATE PROC  sp_adicionar_fornecedores @RazaoSocial VARCHAR(max), @Cnpj VARCHAR(max), @InscricaoEstadual CHAR(2), @Telefone VARCHAR(MAX),
									@Cep VARCHAR(max), @Cidade VARCHAR(MAX), @Estado VARCHAR(max), @Logradouro VARCHAR(max), @Numero INT, @Completo VARCHAR(max)
AS
	INSERT INTO Fornecedor VALUES(@RazaoSocial, @Cnpj, @InscricaoEstadual, @Telefone)
	INSERT INTO Endereco_Fornecedor VALUES ((SELECT id FROM Fornecedor WHERE cnpj = @Cnpj), @Cep, @Cidade, @Estado, @Logradouro, @Numero, @Completo)
--******************************************************************************--
GO
CREATE PROC sp_lista_fornecedores
AS
	SELECT * FROM FORNECEDOR
--******************************************************************************--
GO
CREATE PROC sp_buscar_fornecedor_por_nome (@nome_fornecedor VARCHAR(max))
AS
	SELECT * FROM FORNECEDOR WHERE razaoSocial like '%'+@nome_fornecedor+'%'
--******************************************************************************--
GO
CREATE PROC sp_buscar_fornecedor_por_id(@id_fornecedor INT)
AS
	SELECT * FROM FORNECEDOR WHERE id = @id_fornecedor
--******************************************************************************--
GO
CREATE PROC sp_buscar_endereco_por_id_fornecedor (@id_fornecedor INT)
AS
	SELECT * FROM Endereco_Fornecedor WHERE id_fornecedor = @id_fornecedor
--******************************************************************************--
GO
CREATE PROC sp_update_fornecedor  @id INT, @RazaoSocial VARCHAR(max), @Cnpj VARCHAR(max), @InscricaoEstadual CHAR(2), @Telefone VARCHAR(MAX),
								@Cep VARCHAR(max), @Cidade VARCHAR(MAX), @Estado VARCHAR(max), @Logradouro VARCHAR(max), @Numero INT, @Complemento VARCHAR(max)
AS
	IF (@RazaoSocial != '')
	BEGIN
		UPDATE Fornecedor SET razaoSocial = @RazaoSocial WHERE id = @id
	END
	IF (@Cnpj != '')
	BEGIN
		UPDATE Fornecedor SET Cnpj = @Cnpj WHERE id = @id
	END
	IF (@Telefone != '')
	BEGIN
		UPDATE Fornecedor SET telefone = @Telefone WHERE id = @id
	END
	IF(@InscricaoEstadual != '')
	BEGIN
		UPDATE Fornecedor SET inscricaoEstadual = @InscricaoEstadual WHERE id = @id
	END
	IF(@Cep != '')
	BEGIN
		UPDATE Endereco_Fornecedor SET cep = @Cep WHERE id_fornecedor = @id
	END
	IF(@cidade != '')
	BEGIN
		UPDATE Endereco_Fornecedor SET cidade = @cidade WHERE id_fornecedor = @id
	END
	IF(@estado != '')
	BEGIN
		UPDATE Endereco_Fornecedor SET estado = @estado WHERE id_fornecedor = @id
	END
	IF(@logradouro != '')
	BEGIN
		UPDATE Endereco_Fornecedor SET logradouro = @logradouro WHERE id_fornecedor = @id
	END
	IF(@numero != '')
	BEGIN
		UPDATE Endereco_Fornecedor SET numero = @numero WHERE id_fornecedor = @id
	END
	IF(@complemento != '')
	BEGIN
		UPDATE Endereco_Fornecedor SET complemento = @complemento WHERE id_fornecedor = @id
	END
--******************************************************************************--
GO
CREATE PROC sp_excluir_fornecedor_por_id (@id_fornecedor INT)
AS
	DELETE FROM Endereco_Fornecedor WHERE id_fornecedor = @id_fornecedor
	DELETE FROM FORNECEDOR WHERE id = @id_fornecedor
--******************************************************************************--	



														--FUNÇÕES DO PRODUTO
--******************************************************************************--
GO
CREATE PROC sp_adicionar_produto (@nome VARCHAR(max), @descricao VARCHAR(max), @ncmSh VARCHAR(max), @preco Decimal(7,2), @categoria VARCHAR(20), @fornecedor VARCHAR(max))
AS
	DECLARE @aux INT, @aux2 INT

	SET @aux = (SELECT id FROM Categoria WHERE nome = @categoria)
	
	SET @aux2 = (SELECT id FROM Fornecedor WHERE razaoSocial = @fornecedor)

	INSERT INTO Produto VALUES(@nome, @descricao, @ncmSh, @preco, @aux, @aux2)
--******************************************************************************--
GO
CREATE PROC sp_listar_produto
AS
	SELECT SUBSTRING(nome, 1, 20) as nome,count(nome) as quantidade
	FROM Produto
	GROUP BY nome
--******************************************************************************--
GO
CREATE PROC sp_lista_produto_por_nome(@nome_produto VARCHAR(30))
AS
	SELECT SUBSTRING(nome, 1, 20) as nome,count(nome) as quantidade
	FROM Produto
	--WHERE nome like '%'+@nome_produto+'%'
	GROUP BY nome
--******************************************************************************--
GO
CREATE PROC sp_listar_produto_por_categoria(@id_categoria INT)
AS
	SELECT p.id, p.nome, p.descricao, p.ncmSh, p.preco, p.id_categoria, f.razaoSocial FROM Produto as p
	INNER JOIN Categoria as cp 
	ON  p.id_categoria = cp.id
	inner join Fornecedor AS f
	ON p.id_fornecedor = f.id
	WHERE cp.id = @id_categoria
--******************************************************************************--
GO
CREATE PROC sp_editar_produto(@nome VARCHAR(max), @descricao VARCHAR(max), @ncmSh VARCHAR(max), @preco VARCHAR(max), @categoria VARCHAR(max),@fornecedor VARCHAR(max), @id_produto INT)
AS
	IF(@nome != '')
	BEGIN
		UPDATE Produto SET nome = @nome WHERE id = @id_produto
	END
	IF(@descricao != '')
	BEGIN
		UPDATE Produto SET descricao = @descricao WHERE id = @id_produto
	END
	IF(@ncmSh != '')
	BEGIN
		UPDATE Produto SET ncmSh = @ncmSh WHERE id = @id_produto
	END
	IF(@preco != '')
	BEGIN
		UPDATE Produto SET preco = convert(float,@preco) WHERE id = @id_produto
	END
	IF(@categoria != '')
	BEGIN
		UPDATE Produto
		SET id_categoria =	(SELECT id FROM Categoria WHERE nome = @categoria)
		WHERE id = @id_produto
	IF(@fornecedor != '')
	BEGIN
		UPDATE Produto
		SET id_fornecedor = (SELECT id FROM Fornecedor WHERE razaoSocial = @fornecedor)
		WHERE id = @id_produto
	END
END
--******************************************************************************--
GO
CREATE PROC sp_excluir_produto_por_id (@id_produto INT)
AS
	DELETE FROM Produto WHERE id = @id_produto

--******************************************************************************--
GO
CREATE PROC sp_listar_categorias
AS
	SELECT * FROM Categoria
--******************************************************************************--
GO
CREATE PROC sp_pesquisar_produto_por_nome(@nome_produto VARCHAR(100))
AS
	SELECT * FROM Produto
	WHERE nome like '%'+@nome_produto+'%'
--******************************************************************************--
GO
CREATE PROC sp_pesquisar_produto_por_id(@id_produto INT)
AS
	SELECT p.id, p.nome, p.descricao, p.ncmSh, p.preco, p.id_categoria, f.razaoSocial FROM Produto p
	INNER JOIN Fornecedor f 
	ON p.id_fornecedor = f.id
	WHERE p.id = @id_produto
							--FUNÇÕES USUARIO--
GO
CREATE PROC sp_listar_usuarios
AS
	SELECT usuario.id, usuario.nome, tipo.nome AS tipo_de_usuario, usuario.email AS email
	FROM Usuario usuario 
	INNER JOIN Tipo_De_Usuario tipo 
	ON usuario.id_tipoDeUsuario = tipo.id
--******************************************************************************--
GO
CREATE PROC sp_adicionar_usuario(@nome VARCHAR(50), @login_usuario VARCHAR(30), @senha_usuario VARCHAR(30), @email VARCHAR(100), @tipo_usuario VARCHAR(13))	
AS
	DECLARE @aux INT

	SET @aux =
			CASE
				WHEN @tipo_usuario = 'Administrador' THEN 1
				WHEN @tipo_usuario = 'Estoquista' THEN 2
				WHEN @tipo_usuario = 'Vendedor' THEN 3
			END		

	INSERT INTO Usuario VALUES(@nome, @login_usuario, @senha_usuario, @email, @aux)
	 
--******************************************************************************--
GO
CREATE PROC sp_excluir_usuario_por_id (@id_usuario INT)
AS
	DELETE FROM Usuario WHERE id = @id_usuario
--******************************************************************************--
GO
CREATE PROC sp_editar_usuario(@id_usuario INT, @nome VARCHAR(50), @email VARCHAR(100), @tipo_usuario VARCHAR(13))
AS
	IF(@nome != '')
	BEGIN
		UPDATE Usuario
		SET nome = @nome
		WHERE id = @id_usuario
	END

	IF(@email != '')
	BEGIN
		UPDATE Usuario
		SET email = @email
		WHERE id = @id_usuario
	END

	IF(@tipo_usuario != '')
	BEGIN
		UPDATE Usuario
		SET id_tipoDeUsuario =
			CASE
				WHEN @tipo_usuario = 'Administrador' THEN 1
				WHEN @tipo_usuario = 'Estoquista' THEN 2
				WHEN @tipo_usuario = 'Vendedor' THEN 3
			END		
		WHERE id = @id_usuario	
	END
--******************************************************************************--
GO
CREATE PROC sp_verificar_duplicidade(@login_usuario VARCHAR(30), @email VARCHAR(100))
AS
	SELECT login_usuario, email FROM Usuario WHERE login_usuario = @login_usuario AND email = @email
--******************************************************************************--
GO
CREATE PROC sp_pesquisar_Usuario_Por_Nome (@nome VARCHAR(30))
AS
	SELECT u.id, u.nome,u.email, t.nome as tipo_de_usuario FROM Usuario u 
	INNER JOIN Tipo_de_Usuario t 
	ON u.id_tipoDeUsuario = t.id 
	WHERE u.nome like '%'+@nome+'%'
	--******************************************************************************--
GO
--******************************************************************************--
CREATE PROC sp_pesquisar_Usuario_Por_Id(@id_usuario INT)
AS
	SELECT  u.id,  u.nome, u.email,t.nome as tipo_de_usuario FROM Usuario u 
	INNER JOIN Tipo_de_Usuario t 
	ON u.id_tipoDeUsuario = t.id 
	WHERE u.id = @id_usuario
--******************************************************************************--


							--FUNÇÕES ESTOQUE

--****************************************************************************--
GO
CREATE PROC sp_editar_estoque(@nome VARCHAR(50), @quantidade int)
AS
	DECLARE @id_produto INT
	SET @id_produto = (SELECT id FROM Produto WHERE nome = @nome)
	
	IF (@quantidade > -1 )
	BEGIN
		UPDATE Estoque
		SET quantidade = @quantidade
		WHERE id_Produto = @id_produto
	END
--****************************************************************************--
GO
CREATE PROC sp_listar_estoque
AS
	SELECT p.nome, e.quantidade 
	FROM Estoque e INNER JOIN Produto p 
	ON e.id_Produto = p.id
--****************************************************************************--
GO
CREATE PROC sp_procurar_no_estoque(@nomeProduto VARCHAR(50))
AS
	SELECT p.nome, e.quantidade
	FROM Estoque e INNER JOIN Produto p
	ON e.id_Produto = p.id
	WHERE p.nome like '%'+@nomeProduto+'%'
--****************************************************************************--
--****************************************************************************--
GO
CREATE PROC sp_validar_acesso(@login VARCHAR(max), @senha VARCHAR(max))
AS
	SELECT * FROM Usuario WHERE login_usuario = @login and senha_usuario = @senha
--****************************************************************************--
GO
CREATE PROC sp_salvarAutenticacao(@login VARCHAR(max))
AS
	DELETE FROM Acesso
	DECLARE @id INT, @tipo INT

	SET @id = (SELECT id FROM Usuario WHERE login_usuario = @login)
	set @tipo = (SELECT id_tipoDeUsuario FROM Usuario WHERE login_usuario = @login)

	INSERT INTO Acesso VALUES(@id, @tipo)
--****************************************************************************--
GO
CREATE PROC sp_verificar_cargo
AS
	SELECT * FROM Acesso
--****************************************************************************--
GO
CREATE PROC sp_limpar_acesso
AS
	DELETE FROM Acesso
--******************************************************************************--
GO
CREATE PROC sp_resetar_senha(@login VARCHAR(MAX), @email VARCHAR(MAX), @senha VARCHAR(MAX))
AS
	UPDATE Usuario
	SET senha_usuario = @senha
	WHERE login_usuario = @login and email = @email	
--******************************************************************************--
GO
CREATE PROC sp_adicionar_categoria(@nome_categoria VARCHAR(MAX))
AS
	IF(@nome_categoria) NOT IN (SELECT nome FROM Categoria)
	BEGIN
		INSERT INTO Categoria VALUES(@nome_categoria)
	END

--******************************************************************************--
GO
CREATE PROC sp_editar_categoria(@id_categoria INT, @nome_categoria VARCHAR(max))

AS
	UPDATE Categoria
	SET nome = @nome_categoria
	WHERE id = @id_categoria
--******************************************************************************--
GO
CREATE PROC sp_excluir_categoria(@id_categoria INT)
AS
	IF @id_categoria NOT IN(SELECT id_categoria FROM Produto)
	BEGIN
		DELETE FROM Categoria WHERE id = @id_categoria
	END
--******************************************************************************--
GO 
CREATE PROC sp_verificar_duplicidade_categoria(@nome VARCHAR(max))
AS
	SELECT nome FROM Categoria WHERE nome = @nome
--******************************************************************************--
GO
CREATE PROC sp_pesquisar_categoria_por_nome(@nome VARCHAR(max))
AS
	SELECT id, nome FROM Categoria WHERE nome like '%'+@nome+'%'

GO
--******************************************************************************--
CREATE PROC sp_pesquisar_categoria_por_id(@id INT)
AS
	SELECT id, nome FROM Categoria WHERE id = @id
--******************************************************************************----******************************************************************************--
GO 
CREATE PROC sp_adicionar_registroDeVenda(@nome_vendedor VARCHAR(max), @nome_cliente VARCHAR(max), @data DATE)
AS
	INSERT INTO RegistrosVenda (nome_vendedor, nome_cliente, dataVenda) VALUES(@nome_vendedor, @nome_cliente, @data)

--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_listar_vendas
AS
	SELECT * FROM RegistrosVenda
--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_listar_vendedores
AS
	SELECT nome FROM Usuario WHERE id_tipoDeUsuario = 3
	--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_listar_clientes
AS
	SELECT nomeRazaoSocial FROM Cliente
--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_excluir_registroDeVenda(@id INT)
AS
	DELETE FROM Carrinho WHERE id_registroVenda = @id
	DELETE FROM RegistrosVenda WHERE id = @id
	--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_listar_produto_carrinho
AS
	SELECT nome FROM Produto

GO
--******************************************************************************----******************************************************************************--
CREATE PROC sp_buscar_id_registro
AS
	SELECT TOP 1 id FROM RegistrosVenda 
	ORDER BY id DESC
--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_adicionar_carrinho(@nome_produto VARCHAR(max), @quantidade INT, @id INT) --Adicionar a quantidade de vezes antes do reset//passar por parametro o tamanho //criar uma tabela com a quantidade armazenada
AS
	INSERT INTO Carrinho VALUES(@nome_produto, @quantidade, (SELECT preco FROM Produto WHERE nome = @nome_produto), @id)


	IF(SELECT valor FROM TabelaBoolean) = 0
	BEGIN
		DELETE FROM Carrinho WHERE id_registroVenda = @id
		UPDATE RegistrosVenda
		SET valor = 0
		WHERE id = @id
		EXEC sp_tabela_boolean 1
	END
	IF (SELECT valor FROM TabelaBoolean) = 1
	BEGIN
		UPDATE RegistrosVenda
		SET valor += (SELECT preco FROM Produto WHERE nome = @nome_produto)*@quantidade
		WHERE id = @id
	END
GO
--******************************************************************************----******************************************************************************--
CREATE PROC sp_tabela_boolean(@valor int)
AS
	DELETE FROM TabelaBoolean 
	INSERT INTO TabelaBoolean VALUES(@valor)
--******************************************************************************----******************************************************************************--
GO
CREATE PROC sp_listar_produtos_carrinho(@id int)
AS
	SELECT nome_produto, quantidade, valor FROM Carrinho WHERE id_registroVenda = @id 

	