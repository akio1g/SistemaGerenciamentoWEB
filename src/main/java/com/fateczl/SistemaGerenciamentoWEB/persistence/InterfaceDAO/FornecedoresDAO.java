package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.model.Fornecedor;

public interface FornecedoresDAO {
	public List<Fornecedor> listaFornecedor() throws SQLException, ClassNotFoundException;
	public void adicionarFornecedor(Fornecedor fornecedor, Endereco end) throws SQLException, ClassNotFoundException;
	public boolean verificarDuplicidade(String cnpj) throws SQLException, ClassNotFoundException;
	public void editarFornecedor(Fornecedor c, Endereco e) throws SQLException, ClassNotFoundException;
	public void excluirFornecedorPorId(int id) throws SQLException, ClassNotFoundException;
	public List<Fornecedor> pesquisarFornecedoresPorNome(String nome_fornecedor) throws SQLException, ClassNotFoundException;
	public Fornecedor buscarFornecedorPorId(int id_fornecedor) throws SQLException, ClassNotFoundException;
	public Endereco buscarEnderecoFornecedorPorId(int id_fornecedor) throws SQLException, ClassNotFoundException;
}
