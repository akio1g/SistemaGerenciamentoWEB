package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Categoria;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;

public interface ProdutoDAO {
	public void adicionarProduto(Produto p) throws SQLException, ClassNotFoundException;
	public List<Produto> listarPorCategoria(int i) throws SQLException, ClassNotFoundException;
	public void excluirPorId(int id) throws SQLException, ClassNotFoundException;
	public void editarProduto(Produto p) throws ClassNotFoundException, SQLException;
	List<Categoria> listarCategorias() throws SQLException, ClassNotFoundException;
}
