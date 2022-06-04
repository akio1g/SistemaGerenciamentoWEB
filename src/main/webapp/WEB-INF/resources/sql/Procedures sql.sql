CREATE PROC sp_lista_clientes -- Usada para listar os clientes
AS
	SELECT c.id, c.nomeRazaoSocial, c.cpfCnpj,c.telefone, c.email, c.inscricaoEstadual,
	 e.cep,  e.estado,e.cidade,e.logradouro, e.numero, e.complemento
	 FROM Cliente c INNER JOIN Endereco e ON c.id = e.id_cliente 
--******************************************************************************--
CREATE PROC sp_lista_fornecedores
AS
	SELECT * FROM FORNECEDOR
--******************************************************************************--
CREATE PROC sp_buscar_cliente_por_id(@id INT)
AS
	SELECT * FROM Cliente WHERE id = @id
--******************************************************************************--
CREATE PROC sp_buscar_endereco_por_id_cliente(@id_cliente INT)
AS
	SELECT * FROM Endereco WHERE id_cliente = @id_cliente
--******************************************************************************--

	 1001,'Roberto Freitas','12682957294','11987460692','rfreitas@outlook.com.br',null,'50421343','S�o Paulo','SP','rua da Macieira','23',null
CREATE PROC sp_update_cliente @id INT, @nomeRazaoSocial VARCHAR(max), @CpfCnpj VARCHAR(max), @Telefone VARCHAR(max), 
							  @Email VARCHAR(max), @InscricaoEstadual VARCHAR(max),
							  @Cep VARCHAR(max), @cidade VARCHAR(max), @estado VARCHAR(max), 
							  @logradouro VARCHAR(max), @numero VARCHAR(max), @complemento VARCHAR(max)
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
	

