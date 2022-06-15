package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Carrinho;
import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;

public interface RegistroVendasDAO {
	public List<RegistroDeVenda> listaVendas() throws SQLException, ClassNotFoundException;

	public List<String> listaVendedores() throws SQLException, ClassNotFoundException;

	public List<String> listaClientes() throws SQLException, ClassNotFoundException;

	public void adicionar_registroDeVenda(String nome_vendedor, String nome_cliente, String dataVenda)
			throws SQLException, ClassNotFoundException;

	public void excluir_registroDeVenda(int id) throws SQLException, ClassNotFoundException;

	public List<String> listaProdutos() throws SQLException, ClassNotFoundException;

	public void adicionar_carrinho(List<String> produtos, List<String> quantidade, int id)
			throws SQLException, ClassNotFoundException;

	public int buscar_registro_id() throws SQLException, ClassNotFoundException;

	public List<Carrinho> listaProdutosCarrinho(int id) throws SQLException, ClassNotFoundException;
}
