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
	public List<Produto> pesquisarProdutoPorNome(String nome) throws SQLException, ClassNotFoundException;
	public boolean verificar_duplicidade_categoria(String nome_categoria) throws SQLException, ClassNotFoundException;
	public void adicionar_categoria(Categoria categoria) throws SQLException, ClassNotFoundException;
	public List<Categoria> pesquisar_categoria_por_nome(String nome) throws SQLException, ClassNotFoundException;
	public Categoria pesquisar_categoria_por_id(int id) throws SQLException, ClassNotFoundException;
	public void editar_categoria(Categoria categoria) throws SQLException, ClassNotFoundException;
	public void excluir_categoria_por_id(int id) throws SQLException, ClassNotFoundException;
}
