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
	public void adicionarProduto(Produto p) throws SQLException, ClassNotFoundException {
		try {
			Connection c = gDAO.getConnection();

			String sql = "INSERT INTO Produto (nome, descricao, ncmSh, preco) VALUES(?,?,?,?)"; 

			PreparedStatement ps = c.prepareStatement(sql);
		
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setString(3, p.getNcmSh());
			ps.setDouble(4, p.getPreco()); 
			ps.executeUpdate(); 
			c.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verificarDuplicidade(String ncmsh) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "SELECT ncmSh FROM Produto WHERE ncmSh = ?"; 
		
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, ncmsh);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			return false;
		}
		c.close();
		p.close();
		rs.close();
		return true;
	}

	@Override
	public List<Produto> listarPorCategoria(Categoria cat) throws SQLException, ClassNotFoundException {
		List<Produto> lista = new ArrayList<>();
		try {
			Connection c = gDAO.getConnection();
			PreparedStatement ps = c.prepareStatement("select p.* from Produto as p\r\n"
					+ "inner join categoria_produto as cp on p.id = cp.id_produto\r\n"
					+ "where cp.id_categoria = ?");
			ps.setLong(1, cat.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produto p = instanciarProduto(rs);
				lista.add(p);
			}
			c.close();
			ps.close();
			rs.close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Produto instanciarProduto(ResultSet rs) throws SQLException {
		Produto p = new Produto();
		p.setId(rs.getLong("id"));
		p.setNome(rs.getString("nome"));
		p.setDescricao(rs.getString("descricao"));
		p.setNcmSh(rs.getString("ncmSh"));
		p.setPreco(rs.getDouble("preco"));
		return p;
		
	}

	@Override
	public void apagarPorId(int id) throws ClassNotFoundException {
		try {
			Connection c = gDAO.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM Produto WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			c.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editarProduto(Produto p) throws ClassNotFoundException { // NAO FINALIZADO
		try {
			Connection c = gDAO.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE Produto SET nome = ?, descricao = ?, ncmSh = ?, preco = ?"
							+ " WHERE id = ?");
			// ps.setInt(1, );
			//ps.setInt(2, );
			//ps.setDate(3, );
			//ps.setTime(4, );
			//ps.setInt(5, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
