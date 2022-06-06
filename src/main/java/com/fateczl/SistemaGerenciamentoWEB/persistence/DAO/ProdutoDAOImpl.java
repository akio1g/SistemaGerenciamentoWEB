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
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.ProdutoDAO;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO{

	@Autowired
	GenericDAO gDAO;

	@Override
	public void adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();

		PreparedStatement p = c.prepareStatement("EXEC sp_adicionar_produto ?,?,?,?,?");
	
		p.setString(1, produto.getNome());
		p.setString(2, produto.getDescricao());
		p.setString(3, produto.getNcmSh());
		p.setDouble(4, produto.getPreco()); 
		p.setString(5, produto.getCategoria());
		p.executeUpdate(); 
		
		c.close();
		p.close();
	}

	@Override
	public List<Produto> listarPorCategoria(int id) throws SQLException, ClassNotFoundException {
		
		List<Produto> lista = new ArrayList<>();
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps = c.prepareStatement("EXEC sp_listar_produto_por_categoria ?");
		
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Produto p = instanciarProduto(rs);
			lista.add(p);
		}
		c.close();
		ps.close();
		rs.close();
		
		return lista;
	}

	private Produto instanciarProduto(ResultSet rs) throws SQLException, ClassNotFoundException {
		Produto p = new Produto();
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setDescricao(rs.getString("descricao"));
		p.setNcmSh(rs.getString("ncmSh"));
		p.setPreco(rs.getDouble("preco"));
		
		return p;
	}

	@Override
	public void excluirPorId(int id) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps = c.prepareStatement("EXEC sp_excluir_produto_por_id ?");
		
		ps.setInt(1, id);
		ps.executeUpdate();
		c.close();
		ps.close();
	}

	@Override
	public void editarProduto(Produto produto) throws SQLException, ClassNotFoundException { 
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps = c.prepareStatement("EXEC sp_editar_produto ?,?,?,?,?");
		
		ps.setString(1, produto.getNome());
		ps.setString(2, produto.getDescricao());
		ps.setString(3, produto.getNcmSh());
		ps.setDouble(4, produto.getPreco());
		ps.setInt(5, produto.getId());
		
		ps.executeUpdate();
	
		ps.close();
		c.close();
	}
	@Override
	public List<Categoria> listarCategorias()  throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		List<Categoria> listaCategorias = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement("EXEC sp_listar_categorias");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt("id"));
			categoria.setNome(rs.getString("nome"));
			
			listaCategorias.add(categoria);
		}
		rs.close();
		ps.close();
		c.close();
		return listaCategorias;
	}
	@Override
	public List<Produto> pesquisarProdutoPorNome(String nome) throws SQLException, ClassNotFoundException{
		
		Connection c = gDAO.getConnection();
		
		List<Produto> listaProduto = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement("Exec sp_pesquisar_produto_por_nome ?");
		
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProduto.add(instanciarProduto(rs));
		}
		ps.close();
		rs.close();
		c.close();
		return listaProduto;
	}
}
