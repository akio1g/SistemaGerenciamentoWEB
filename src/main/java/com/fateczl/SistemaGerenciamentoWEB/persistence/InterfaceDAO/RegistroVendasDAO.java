package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Carrinho;
import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;

public interface RegistroVendasDAO {
	public List<RegistroDeVenda> listaVendas() throws SQLException, ClassNotFoundException;

	public List<Carrinho> listarCarrinho(int id) throws SQLException, ClassNotFoundException;

	public List<RegistroDeVenda> listaVendaPorVendedor(String nome_vendedor) throws SQLException, ClassNotFoundException;

	public String buscarVendedor(String nome) throws SQLException, ClassNotFoundException;

	public String buscarCliente(String nome) throws SQLException, ClassNotFoundException;
}
