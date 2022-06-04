CREATE DATABASE DistribuidoraAMZ
use DistribuidoraAMZ
use A
DROP DATABASE DistribuidoraAMZ 

CREATE TABLE Cliente(
	id INT IDENTITY (1000,1),
	nomeRazaoSocial VARCHAR(max),
	cpfCnpj VARCHAR(max),
	telefone VARCHAR(max),
	email VARCHAR(max),
	inscricaoEstadual VARCHAR(max)

	CONSTRAINT pk_id_cliente PRIMARY KEY(id)
)
CREATE TABLE Endereco(
	id INT IDENTITY(1,1),
	id_cliente INT,
	cep VARCHAR(max),
	cidade VARCHAR(max),
	estado VARCHAR(max),
	logradouro VARCHAR(max),
	numero INT,
	complemento VARCHAR(max),
	
	CONSTRAINT fk_id_cliente_endereco FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
)
CREATE TABLE FORNECEDOR(
	id INT IDENTITY,
	razaoSocial VARCHAR(max),
	cnpj VARCHAR(max),
	inscricaoEstadual VARCHAR(max),
	telefone VARCHAR(max),
	CONSTRAINT pk_id_fornecedor PRIMARY KEY(id)
)
CREATE TABLE Categoria (
	id INT IDENTITY,
	nome VARCHAR(max)
	CONSTRAINT pk_categoria PRIMARY KEY(id)
	)

CREATE TABLE Produto (
	id INT IDENTITY,
	nome VARCHAR(max),
	descricao VARCHAR(max),
	ncmSh VARCHAR(max),
	preco FLOAT

	CONSTRAINT pk_produto PRIMARY KEY (id)
	)
CREATE Table categoria_produto(
	id_categoria INT,
	id_produto INT,
	CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
	CONSTRAINT fk_id_produto FOREIGN KEY (id_produto) REFERENCES Produto(id),
	CONSTRAINT pk_id_categoria_produto PRIMARY KEY(id_categoria, id_produto)
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
(1005,'40623315','Sao Paulo','SP','rua da Arvore','152',null),
(1004,'50421343','Sao Paulo','SP','rua da Macieira','23',null),
(1001,'12958585','Sao Paulo','SP','Av. Seu Jorge','567',null),
(1003,'43964392','Sao Paulo','SP','rua Erivaldo Rossi','125',null),
(1000,'12521689','Sao Paulo','SP','Pra�a Dom Luiz','13',null),
(1002,'50354103','Sao Paulo','SP','rua Cachoeira da Luz','1252',null)

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
