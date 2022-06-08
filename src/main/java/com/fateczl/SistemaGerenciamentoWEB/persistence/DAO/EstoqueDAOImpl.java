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
	public List<Estoque> listarEstoque() throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
	
		List<Estoque> listaProdutos = new ArrayList<Estoque>();
		PreparedStatement ps = c.prepareStatement("EXEC sp_listar_estoque");
		
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
	public List<Estoque> listarProdutoPorNome(String nome) throws SQLException, ClassNotFoundException {

		Connection c = gDAO.getConnection();
		
		List<Estoque> listaProdutos = new ArrayList<Estoque>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_procurar_no_estoque ?");
		
		p.setString(1, nome);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Estoque estoque = new Estoque();
			
			estoque.setQuantidade(rs.getInt("quantidade"));
			estoque.setNome(rs.getString("nome"));
			listaProdutos.add(estoque);
		}
		c.close();
		p.close();
		rs.close();
		return listaProdutos;
	}
	@Override
	public void editarEstoque(List<Estoque> estoque) throws SQLException, ClassNotFoundException {
			
		Connection c = gDAO.getConnection();
		
		for(int i=0; i<estoque.size();i++) {
			PreparedStatement p = c.prepareStatement("Exec sp_editar_estoque ?, ?");
			
			p.setString(1, estoque.get(i).getNome());
			p.setInt(2, estoque.get(i).getQuantidade());
			
			p.executeUpdate();
			p.close();
		}
		c.close();
	}
}
