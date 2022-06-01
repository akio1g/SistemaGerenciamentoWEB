use DistribuidoraAMZ

CREATE TABLE Cliente(
	id smallint IDENTITY,
	nomeRazaoSocial VARCHAR(max),
	cpfCnpj VARCHAR(max),
	telefone VARCHAR(max),
	email VARCHAR(max),
	inscricaoEstadual VARCHAR(max)

	CONSTRAINT pk_id_cliente PRIMARY KEY(id)
)
CREATE TABLE Endereco(
	id smallint IDENTITY,
	id_cliente smallint,
	cep VARCHAR(max),
	cidade VARCHAR(max),
	estado VARCHAR(max),
	logradouro VARCHAR(max),
	numero VARCHAR(max),
	complemento VARCHAR(max),
	
	CONSTRAINT fk_id_cliente_endereco FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
)
CREATE TABLE FORNECEDOR(
	id smallint IDENTITY,
	razaoSocial VARCHAR(max),
	cnpj VARCHAR(max),
	inscricaoEstadual VARCHAR(max),
	telefone VARCHAR(max),
	CONSTRAINT pk_id_fornecedor PRIMARY KEY(id)
)




CREATE PROC sp_lista_fornecedores
AS
	SELECT * FROM FORNECEDOR

EXEC sp_lista_fornecedores

CREATE PROC sp_lista_clientes
AS
	SELECT c.id, c.nomeRazaoSocial, c.cpfCnpj,c.telefone, c.email, c.inscricaoEstadual,
	 e.cep,  e.estado,e.cidade,e.logradouro, e.numero, e.complemento
	 FROM Cliente c INNER JOIN Endereco e ON c.id = e.id_cliente 

Exec sp_lista_clientes


// 26/05/2022

CREATE TABLE Categoria (
	id smallint IDENTITY,
	nome VARCHAR(max)
	)

ALTER TABLE CATEGORIA
ADD CONSTRAINT pk_id_categoria PRIMARY KEY(id)


CREATE TABLE Produto (
	id smallint IDENTITY,
	nome VARCHAR(max),
	descricao VARCHAR(max),
	ncmSh VARCHAR(max),
	preco FLOAT
	)

ALTER TABLE PRODUTO
ADD CONSTRAINT pk_id_produto PRIMARY KEY(id)

CREATE Table categoria_produto(
	id_categoria smallint,
	id_produto smallint,
	CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
	CONSTRAINT fk_id_produto FOREIGN KEY (id_produto) REFERENCES Produto(id)
	)


INSERT INTO Categoria (nome) values ('Gorje')
INSERT INTO Categoria (nome) values ('Yale')
INSERT INTO Categoria (nome) values ('Yale Dupla')
INSERT INTO Categoria (nome) values ('Tetra')
INSERT INTO Categoria (nome) values ('Pantograficas')
INSERT INTO Categoria (nome) values ('Codificadas')
INSERT INTO Categoria (nome) values ('Laminas de Segredo')

INSERT INTO Cliente (nomeRazaoSocial,cpfCnpj,telefone,email,inscricaoEstadual) VALUES 
('Marcos Josue','19238592832','11983275921','majosue@gmail.com',null),
('Roberto Freitas','12682957294','11987460692','rfreitas@outlook.com.br',null),
('Joao Queiroz','40928592401','13972650193','queirozjoao@gmail.com',null),
('Gabriel Felipe','01956728491','11903951728','gabrielgabriel@outlook.com.br',null),
('Igor Santos','49028591307','11972635912','igorsa@gmail.com',null),
('Marcela Zambrosio','12349672821','11997128543','marcelazambrosio@outlook.com.br',null)

INSERT INTO Endereco (id_cliente,cep,cidade,estado,logradouro,numero,complemento) VALUES 
(5,'40623315','São Paulo','SP','rua da Arvore','152',null),
(4,'50421343','São Paulo','SP','rua da Macieira','23',null),
(1,'12958585','São Paulo','SP','Av. Seu Jorge','567',null),
(3,'43964392','São Paulo','SP','rua Erivaldo Rossi','125',null),
(6,'12521689','São Paulo','SP','Praça Dom Luiz','13',null),
(2,'50354103','São Paulo','SP','rua Cachoeira da Luz','1252',null)

INSERT INTO FORNECEDOR (razaoSocial, cnpj, inscricaoEstadual, telefone) VALUES
('3F CHAVES LTDA','14842903000124', 'MG', '2225250030'),
('PADO SA','61144150000678', 'PR', '1121251400'),
('STAM METALURGICA SA','30560205000192', 'RJ', '2225251006')

INSERT INTO Produto (nome,descricao,ncmSh,preco) VALUES
('Chave Pado Original 2',null,'83017000',7.9),
('Chave Pado 682',null,'83017000',1.75),
('Chave Stam 799',null,'83017000',1.75),
('Chave Tetram Niquelada Fechadura 1201',null,'83017000',6.30),
('Chave 3F 1040 Gold',null,'83017000',1.79),
('Chave 3F 1125.1',null,'83017000',0.97)

INSERT INTO categoria_produto VALUES
(2,1),(2,2),(2,3),(4,4),(2,5),(2,6)

