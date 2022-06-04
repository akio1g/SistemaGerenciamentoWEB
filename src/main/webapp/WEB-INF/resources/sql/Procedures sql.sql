USE DistribuidoraAMZ
							--FUNÇÕES DO CLIENTE--
--******************************************************************************--
CREATE PROC sp_adicionar_cliente @nomeRazaoSocial VARCHAR(max), @CpfCnpj VARCHAR(max), @Telefone VARCHAR(max), 
							     @Email VARCHAR(max), @InscricaoEstadual VARCHAR(max),
							     @Cep VARCHAR(max), @cidade VARCHAR(max), @estado VARCHAR(max), 
							     @logradouro VARCHAR(max), @numero INT, @complemento VARCHAR(max)
AS
	INSERT INTO Cliente VALUES(@nomeRazaoSocial, @CpfCnpj, @Telefone, @Email, @InscricaoEstadual)
	INSERT INTO Endereco VALUES((SELECT id FROM Cliente WHERE cpfCnpj = @CpfCnpj), @Cep, @cidade, @estado, @logradouro, @numero, @complemento)
--******************************************************************************--
CREATE PROC sp_lista_clientes -- Usada para listar os clientes
AS
	SELECT c.id, c.nomeRazaoSocial, c.cpfCnpj,c.telefone, c.email, c.inscricaoEstadual,
	 e.cep,  e.estado,e.cidade,e.logradouro, e.numero, e.complemento
	 FROM Cliente c INNER JOIN Endereco e ON c.id = e.id_cliente 
--******************************************************************************--
CREATE PROC sp_buscar_cliente_por_nome (@nome VARCHAR(50))
AS
	SELECT * FROM Cliente WHERE nomeRazaoSocial like '%'+@nome+'%'
--******************************************************************************--
CREATE PROC sp_buscar_cliente_por_id(@id INT)
AS
	SELECT * FROM Cliente WHERE id = @id
--******************************************************************************--
CREATE PROC sp_buscar_endereco_por_id_cliente(@id_cliente INT)
AS
	SELECT * FROM Endereco WHERE id_cliente = @id_cliente
--******************************************************************************--
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
CREATE PROC sp_excluir_cliente(@id_cliente int) 
AS
	BEGIN
		DELETE FROM	Endereco WHERE id_cliente = @id_cliente		
		DELETE FROM Cliente WHERE id = @id_cliente
	END





													--FUNÇÕES DO FORNECEDOR--
--******************************************************************************--
CREATE PROC sp_adicionar_fornecedores @RazaoSocial VARCHAR(max), @Cnpj VARCHAR(max), @InscricaoEstadual CHAR(2), @Telefone VARCHAR(MAX),
									@Cep VARCHAR(max), @Cidade VARCHAR(MAX), @Estado VARCHAR(max), @Logradouro VARCHAR(max), @Numero INT, @Completo VARCHAR(max)
AS
	INSERT INTO Fornecedor VALUES(@RazaoSocial, @Cnpj, @InscricaoEstadual, @Telefone)
	INSERT INTO Endereco VALUES ((SELECT id FROM Fornecedor WHERE cnpj = @Cnpj), @Cep, @Cidade, @Estado, @Logradouro, @Numero, @Completo)
--******************************************************************************--
CREATE PROC sp_lista_fornecedores
AS
	SELECT * FROM FORNECEDOR
--******************************************************************************--
CREATE PROC sp_buscar_fornecedor_por_nome (@nome_fornecedor VARCHAR(max))
AS
	SELECT * FROM FORNECEDOR WHERE razaoSocial like '%'+@nome_fornecedor+'%'
--******************************************************************************--
CREATE PROC sp_buscar_fornecedor_por_id(@id_fornecedor INT)
AS
	SELECT * FROM FORNECEDOR WHERE id = @id_fornecedor
--******************************************************************************--
CREATE PROC sp_buscar_endereco_por_id_fornecedor (@id_fornecedor INT)
AS
	SELECT * FROM Endereco_Fornecedor WHERE id_fornecedor = @id_fornecedor
--******************************************************************************--
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
CREATE PROC sp_excluir_fornecedor_por_id (@id_fornecedor INT)
AS
	DELETE FROM Endereco_Fornecedor WHERE id_fornecedor = @id_fornecedor
	DELETE FROM FORNECEDOR WHERE id = @id_fornecedor
--******************************************************************************--	



					--FUNÇÕES DO PRODUTO
CREATE PROC sp_adicionar_produto (@nome VARCHAR(max), @descricao VARCHAR(max), @ncmSh VARCHAR(max), @preco Decimal(7,2), @categoria INT)
AS
	INSERT INTO Produto VALUES(@nome, @descricao, @ncmSh, @preco, @categoria)
--******************************************************************************--
CREATE PROC sp_listar_produto
AS
	SELECT SUBSTRING(nome, 6, 15) as nome,count(nome) as quantidade
	FROM Produto
	GROUP BY nome

--******************************************************************************--
CREATE PROC sp_listar_produto_por_categoria(@id_categoria INT)
AS
	SELECT p.* FROM Produto as p
	INNER JOIN categoria_produto as cp 
	ON  p.id = cp.id_produto
	WHERE cp.id_categoria = @id_categoria
--******************************************************************************--
CREATE PROC sp_editar_produto(@nome VARCHAR(max), @descricao VARCHAR(max), @ncmSh VARCHAR(max), @preco DECIMAL(7,2), @categoria INT, @id_produto INT)
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
		UPDATE Produto SET preco = @preco WHERE id = @id_produto
	END
	IF(@categoria != '')
	BEGIN
		UPDATE Produto SET id_categoria = @categoria WHERE id = @id_produto
	END
--******************************************************************************--
CREATE PROC sp_excluir_produto_por_id (@id_produto INT)
AS
	DELETE FROM Produto WHERE id = @id_produto