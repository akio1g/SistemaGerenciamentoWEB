CREATE DATABASE DistribuidoraAMZ
use DistribuidoraAMZ

CREATE TABLE Cliente(
	id INT IDENTITY,
	nomeRazaoSocial VARCHAR(max) NOT NULL,
	cpfCnpj VARCHAR(15) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
	email VARCHAR(100) NOT NULL,
	inscricaoEstadual CHAR(2) NOT NULL

	CONSTRAINT pk_id_cliente PRIMARY KEY(id)
)
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
CREATE TABLE Fornecedor(
	id INT IDENTITY,
	razaoSocial VARCHAR(max) NOT NULL,
	cnpj VARCHAR(15) NOT NULL,
	inscricaoEstadual CHAR(2) NOT NULL,
	telefone VARCHAR(11) NOT NULL

	CONSTRAINT pk_id_fornecedor PRIMARY KEY(id)
)
CREATE TABLE Categoria (
	id INT IDENTITY,
	nome VARCHAR(20) NOT NULL

	CONSTRAINT pk_categoria PRIMARY KEY(id)
)
CREATE TABLE Produto (
	id INT IDENTITY,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(max),
	ncmSh VARCHAR(15) NOT NULL,
	preco DECIMAL(7,2) NOT NULL,
	id_categoria INT NOT NULL

	CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
	CONSTRAINT pk_produto PRIMARY KEY (id)
)
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
CREATE TABLE Tipo_De_Usuario(
	id INT IDENTITY,
	nome CHAR(13) NOT NULL

	CONSTRAINT pk_id_tipoDeUsuario PRIMARY KEY (id)
)

INSERT INTO Cliente (nomeRazaoSocial,cpfCnpj,telefone,email,inscricaoEstadual) VALUES 
('Marcos Josue','19238592832','11983275921','majosue@gmail.com',null),
('Roberto Freitas','12682957294','11987460692','rfreitas@outlook.com.br',null),
('Joao Queiroz','40928592401','13972650193','queirozjoao@gmail.com',null),
('Gabriel Felipe','01956728491','11903951728','gabrielgabriel@outlook.com.br',null),
('Igor Santos','49028591307','11972635912','igorsa@gmail.com',null),
('Marcela Zambrosio','12349672821','11997128543','marcelazambrosio@outlook.com.br',null)

INSERT INTO Endereco (id_cliente,cep,cidade,estado,logradouro,numero,complemento) VALUES 
(5,'40623315','Sao Paulo','SP','rua da Arvore','152',null),
(4,'50421343','Sao Paulo','SP','rua da Macieira','23',null),
(2,'12958585','Sao Paulo','SP','Av. Seu Jorge','567',null),
(3,'43964392','Sao Paulo','SP','rua Erivaldo Rossi','125',null),
(6,'12521689','Sao Paulo','SP','Pra�a Dom Luiz','13',null),
(1,'50354103','Sao Paulo','SP','rua Cachoeira da Luz','1252',null)

INSERT INTO Fornecedor (razaoSocial, cnpj, inscricaoEstadual, telefone) VALUES
('3F CHAVES LTDA','14842903000124', 'MG', '2225250030'),
('PADO SA','61144150000678', 'PR', '1121251400'),
('STAM METALURGICA SA','30560205000192', 'RJ', '2225251006')

INSERT INTO Endereco_Fornecedor(id_fornecedor,cep,cidade,estado,logradouro,numero,complemento) VALUES 
(5,'40623315','Sao Paulo','SP','rua da Arvore','152',null),
(6,'50421343','Sao Paulo','SP','rua da Macieira','23',null),
(7,'12958585','Sao Paulo','SP','Av. Seu Jorge','567',null)

INSERT INTO Categoria (nome) values ('Gorje'),
('Yale'),
('Yale Dupla'),
('Tetra'),
('Pantograficas'),
('Codificadas'),
('Laminas de Segredo')

INSERT INTO Produto (nome,descricao,ncmSh,preco, id_categoria) VALUES
('Chave Pado Original 2',null,'83017000',7.9, 2),
('Chave Pado 682',null,'83017000',1.75, 1),
('Chave Stam 799',null,'83017000',1.75, 3),
('Chave Tetram Niquelada Fechadura 1201',null,'83017000',6.30,1),
('Chave 3F 1040 Gold',null,'83017000',1.79, 2),
('Chave 3F 1125.1',null,'83017000',0.97, 1),
('Chave 3F 1125.1',null,'83017000',0.97, 1)

INSERT INTO Tipo_De_Usuario(nome) VALUES
('Administrador'),
('Estoquista'),
('Vendedor')

INSERT INTO Usuario (nome, login_usuario, senha_usuario, email, id_tipoDeUsuario)VALUES
('Higor', 'Higor123', 'senha123', 'gabriel@bol.com.br', 1),
('Gabriel', 'Gabriel123', 'senha123', 'gabriel@bol.com.br', 2),
('Breno', 'Breno789', 'senha123', 'breno@bol.com.br', 3)

