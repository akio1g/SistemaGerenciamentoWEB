package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Categoria;
import com.fateczl.SistemaGerenciamentoWEB.model.Estoque;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;

public interface EstoqueDAO {
	public List<Estoque> listarProduto() throws SQLException, ClassNotFoundException;
	public List<Estoque> listarProdutoPorNome(String nome) throws SQLException, ClassNotFoundException;
}
