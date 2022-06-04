package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Categoria;
import com.fateczl.SistemaGerenciamentoWEB.model.Estoque;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;

public interface EstoqueDAO {
	public List<Produto> listarPorCategoria(Categoria c) throws SQLException, ClassNotFoundException;
	public List<Produto> listarProdutoPorNome(String nome) throws SQLException, ClassNotFoundException;
	List<Estoque> listarProduto() throws SQLException, ClassNotFoundException;
}
