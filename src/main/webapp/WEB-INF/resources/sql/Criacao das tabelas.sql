
CREATE DATABASE DistribuidoraAMZ
GO
USE DistribuidoraAMZ
GO
CREATE TABLE Cliente(
	id INT IDENTITY,
	nomeRazaoSocial VARCHAR(max) NOT NULL,
	cpfCnpj VARCHAR(15) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
	email VARCHAR(100) NOT NULL,
	inscricaoEstadual CHAR(2) 

	CONSTRAINT pk_id_cliente PRIMARY KEY(id)
)
GO
CREATE TABLE Endereco(
	id INT IDENTITY,
	id_cliente INT NOT NULL,
	cep VARCHAR(8) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	estado VARCHAR(20) NOT NULL,
	logradouro VARCHAR(max) NOT NULL,
	numero INT NOT NULL,
	complemento VARCHAR(max),
	
	CONSTRAINT fk_id_cliente_endereco FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
	CONSTRAINT pk_id_endereco PRIMARY KEY(id)
)
GO
CREATE TABLE Fornecedor(
	id INT IDENTITY,
	razaoSocial VARCHAR(max) NOT NULL,
	cnpj VARCHAR(15) NOT NULL,
	inscricaoEstadual CHAR(2),
	telefone VARCHAR(11) NOT NULL

	CONSTRAINT pk_id_fornecedor PRIMARY KEY(id)
)
GO
CREATE TABLE Endereco_Fornecedor(
	id INT IDENTITY,
	id_fornecedor INT NOT NULL,
	cep VARCHAR(8) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	estado VARCHAR(20) NOT NULL,
	logradouro VARCHAR(max) NOT NULL,
	numero INT NOT NULL,
	complemento VARCHAR(max),
	
	CONSTRAINT fk_id_fornecedor_endereco FOREIGN KEY (id_fornecedor) REFERENCES Fornecedor(id),
	CONSTRAINT pk_id_endereco_fornecedor PRIMARY KEY(id)
)
GO
CREATE TABLE Categoria (
	id INT IDENTITY,
	nome VARCHAR(20) NOT NULL

	CONSTRAINT pk_categoria PRIMARY KEY(id)
)
GO
CREATE TABLE Produto (
	id INT IDENTITY,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(max),
	ncmSh VARCHAR(15) NOT NULL,
	preco DECIMAL(7,2) NOT NULL,
	id_categoria INT NOT NULL,
	id_fornecedor INT NOT NULL

	CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
	CONSTRAINT fk_id_produto FOREIGN KEY(id_fornecedor) REFERENCES Fornecedor(id),
	CONSTRAINT pk_produto PRIMARY KEY (id)
)
GO
CREATE TABLE Estoque(
	id INT IDENTITY,
	id_Produto INT NOT NULL,
	quantidade INT NOT NULL

	CONSTRAINT fk_id_produto_estoque FOREIGN KEY(id_Produto) REFERENCES Produto (id),
	CONSTRAINT pk_id_estoque PRIMARY KEY(id)
)
GO
CREATE TRIGGER t_atualizar_estoque
ON Produto
AFTER INSERT
AS
BEGIN
		INSERT INTO Estoque VALUES((SELECT id FROM inserted), 0)
END
GO
CREATE TRIGGER t_deletar_produto
ON PRODUTO
INSTEAD OF DELETE
AS
BEGIN
	DELETE FROM Estoque WHERE id_Produto = (SELECT id FROM deleted) 
	DELETE FROM Produto WHERE id = (SELECT id FROM deleted)
END
GO
CREATE TABLE Tipo_De_Usuario(
	id INT IDENTITY,
	nome CHAR(13) NOT NULL

	CONSTRAINT pk_id_tipoDeUsuario PRIMARY KEY (id)
)
GO
CREATE TABLE Usuario(
	id INT IDENTITY,
	nome VARCHAR(50) NOT NULL,
	login_usuario VARCHAR(30) NOT NULL,
	senha_usuario VARCHAR(30) NOT NULL,
	email VARCHAR(100) NOT NULL,
	id_tipoDeUsuario INT NOT NULL,
	
	CONSTRAINT fk_id_tipoDeUsuario FOREIGN KEY(id_tipoDeUsuario) REFERENCES Tipo_De_Usuario(id),
	CONSTRAINT pk_id_usuario PRIMARY KEY(id)
)
GO
CREATE TRIGGER t_verificar_administrador
ON Usuario
INSTEAD OF DELETE
AS
BEGIN
	IF((SELECT Count(id_tipoDeUsuario) FROM Usuario WHERE id_tipoDeUsuario = 1) > 1)
	BEGIN
		DELETE FROM Usuario WHERE id = (SELECT id FROM deleted)
	END
END
go
CREATE TABLE Carrinho (
	id int IDENTITY,
	nome_produto VARCHAR(max),
	quantidade INT NOT NULL,
	valor decimal(7,2),
	id_registroVenda INT NOT NULL 

	CONSTRAINT pk_id_carrinho PRIMARY KEY(id)
)
GO
CREATE TABLE RegistrosVenda (
	id int identity,
	nome_vendedor VARCHAR(max) NOT NULL,
	nome_cliente VARCHAR(max) NOT NULL,
	dataVenda DATE,
	valor decimal(7,2) 

	CONSTRAINT pk_id_registroVenda PRIMARY KEY(id)
)
GO
CREATE TABLE Acesso(
	id int identity,
	id_usuario INT NOT NULL,
	tipo_usuario INT NOT NULL

	CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
	CONSTRAINT pk_id_Acesso PRIMARY KEY(id)
)
GO
CREATE TABLE TabelaBoolean(
	 id int identity,
	 valor INT not null

	 Primary key(id)
)
GO
INSERT INTO Cliente (nomeRazaoSocial,cpfCnpj,telefone,email,inscricaoEstadual) VALUES 
('Marcos Josue','19238592832','11983275921','majosue@gmail.com',null),
('Roberto Freitas','12682957294','11987460692','rfreitas@outlook.com.br',null),
('Joao Queiroz','40928592401','13972650193','queirozjoao@gmail.com',null),
('Gabriel Felipe','01956728491','11903951728','gabrielgabriel@outlook.com.br',null),
('Igor Santos','49028591307','11972635912','igorsa@gmail.com',null),
('Marcela Zambrosio','12349672821','11997128543','marcelazambrosio@outlook.com.br',null)
GO
INSERT INTO Endereco (id_cliente,cep,cidade,estado,logradouro,numero,complemento) VALUES 
(5,'40623315','Sao Paulo','SP','rua da Arvore','152',null),
(4,'50421343','Sao Paulo','SP','rua da Macieira','23',null),
(2,'12958585','Sao Paulo','SP','Av. Seu Jorge','567',null),
(3,'43964392','Sao Paulo','SP','rua Erivaldo Rossi','125',null),
(6,'12521689','Sao Paulo','SP','Pra�a Dom Luiz','13',null),
(1,'50354103','Sao Paulo','SP','rua Cachoeira da Luz','1252',null)
GO
INSERT INTO Fornecedor (razaoSocial, cnpj, inscricaoEstadual, telefone) VALUES
('3F CHAVES LTDA','14842903000124', 'MG', '2225250030'),
('PADO SA','61144150000678', 'PR', '1121251400'),
('STAM METALURGICA SA','30560205000192', 'RJ', '2225251006')
GO
INSERT INTO Endereco_Fornecedor(id_fornecedor,cep,cidade,estado,logradouro,numero,complemento) VALUES 
(1,'40623315','Sao Paulo','SP','rua da Arvore','152',null),
(2,'50421343','Sao Paulo','SP','rua da Macieira','23',null),
(3,'12958585','Sao Paulo','SP','Av. Seu Jorge','567',null)
GO
INSERT INTO Categoria (nome) values ('Gorje'),
('Yale'),
('Yale Dupla'),
('Tetra'),
('Pantograficas'),
('Codificadas'),
('Laminas de Segredo')
GO
INSERT INTO Produto (nome,descricao,ncmSh,preco, id_categoria, id_fornecedor) VALUES
--('Chave Pado Original 2',null,'83017000',7.9, 2,2),
--('Chave Pado 682',null,'83017000',1.75, 1,2),
--('Chave Stam 799',null,'83017000',1.75, 3,3),
--('Chave Tetram Niquelada Fechadura 1201',null,'83017000',6.30,1,3),
--('Chave 3F 1040 Gold',null,'83017000',1.79, 2,1),
('Chave 3F 1125.1',null,'83017000',0.97, 1,1)
GO
INSERT INTO Tipo_De_Usuario(nome) VALUES
('Administrador'),
('Estoquista'),
('Vendedor')
go
INSERT INTO Usuario (nome, login_usuario, senha_usuario, email, id_tipoDeUsuario)VALUES
('Higor', 'Higor123', 'senha123', 'gabriel@bol.com.br', 1),
('Gabriel', 'Gabriel123', 'senha123', 'gabriel@bol.com.br', 2),
('Breno', 'Breno789', 'senha123', 'breno@bol.com.br', 3)

