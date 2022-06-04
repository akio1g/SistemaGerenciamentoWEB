package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.Categoria;
import com.fateczl.SistemaGerenciamentoWEB.model.Estoque;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.EstoqueDAO;

@Repository
public class EstoqueDAOImpl implements EstoqueDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public List<Estoque> listarProduto() throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
	
		List<Estoque> listaProdutos = new ArrayList<Estoque>();
		PreparedStatement ps = c.prepareStatement("EXEC sp_listar_produto");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Estoque estoque = new Estoque();
			estoque.setQuantidade(rs.getInt("quantidade"));
			estoque.setNome(rs.getString("nome"));
			listaProdutos.add(estoque);
		}
		c.close();
		ps.close();
		rs.close();
		
		return listaProdutos;
	}
	@Override
	public List<Produto> listarPorCategoria(Categoria categoria) throws SQLException, ClassNotFoundException {		
		Connection c = gDAO.getConnection();
		
		List<Produto> listaProdutoCategoria = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement("EXEC sp_listar_produto_por_categoria ?");
		
		ps.setLong(1, categoria.getId());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Produto produto = instanciarProduto(rs);
			listaProdutoCategoria.add(produto);
		}
		c.close();
		ps.close();
		rs.close();
		
		return listaProdutoCategoria;
	}

	@Override
	public List<Produto> listarProdutoPorNome(String nome) throws SQLException, ClassNotFoundException {

		Connection c = gDAO.getConnection();
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_produto_por_nome ?");
		
		p.setString(1, nome);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Produto produto = new Produto();
			produto = instanciarProduto(rs);
			listaProduto.add(produto);
		}
		c.close();
		p.close();
		rs.close();
		return listaProduto;
	}
	
	private Produto instanciarProduto(ResultSet rs) throws SQLException, ClassNotFoundException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setNcmSh(rs.getString("ncmSh"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setCategoria(rs.getString("categoria"));
		
		return produto;
	}
}
