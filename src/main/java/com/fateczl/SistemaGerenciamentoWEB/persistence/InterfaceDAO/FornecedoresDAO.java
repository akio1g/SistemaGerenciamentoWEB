package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Cliente;
import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.model.Fornecedor;

public interface FornecedoresDAO {
	public List<Fornecedor> listaFornecedor() throws SQLException, ClassNotFoundException;
	public void adicionarFornecedor(Fornecedor fornecedor, Endereco end) throws SQLException, ClassNotFoundException;
	public boolean verificarDuplicidade(String cnpj) throws SQLException, ClassNotFoundException;
	public void editarFornecedor(Fornecedor c) throws ClassNotFoundException;
	public void excluirFornecedorPorId(Long id) throws ClassNotFoundException;
}
