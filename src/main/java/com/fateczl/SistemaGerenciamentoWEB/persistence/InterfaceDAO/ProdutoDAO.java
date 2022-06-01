package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Categoria;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;

public interface ProdutoDAO {
	public void adicionarProduto(Produto p) throws SQLException, ClassNotFoundException;
	public List<Produto> listarPorCategoria(Categoria c) throws SQLException, ClassNotFoundException;
	public void apagarPorId(int id) throws ClassNotFoundException;
	public void editarProduto(Produto p) throws ClassNotFoundException;
}
