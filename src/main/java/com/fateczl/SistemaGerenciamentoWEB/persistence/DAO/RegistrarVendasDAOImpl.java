package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.Carrinho;
import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RegistroVendasDAO;

@Repository
public class RegistrarVendasDAOImpl implements RegistroVendasDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public List<RegistroDeVenda> listaVendas() throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		List<RegistroDeVenda> listaVenda = new ArrayList<>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_vendas");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			RegistroDeVenda rg = new RegistroDeVenda();
			
			rg.setId(rs.getInt("id"));
			rg.setVendedor(rs.getString("nome_vendedor"));
			rg.setCliente(rs.getString("nome_cliente"));
			rg.setData(rs.getDate("dataVenda").toLocalDate());
			rg.setValor(rs.getDouble("valor"));
			
			listaVenda.add(rg);
		}
		rs.close();
		p.close();
		c.close();
	
		return listaVenda;
	}
	@Override
	public List<String> listaVendedores() throws SQLException, ClassNotFoundException{
		List<String> listaVendedores = new ArrayList<>();
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_vendedores");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			listaVendedores.add(rs.getString("nome"));
		}
		
		return listaVendedores;
	}
	@Override
	public List<String> listaClientes() throws SQLException, ClassNotFoundException{
		List<String> listaClientes = new ArrayList<>();
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_clientes");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			listaClientes.add(rs.getString("nomeRazaoSocial"));
		}
		
		return listaClientes;
	}
	@Override
	public void adicionar_registroDeVenda(String nome_vendedor, String nome_cliente, String dataVenda) throws SQLException, ClassNotFoundException{
	
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_adicionar_registroDeVenda ?,?,?");
	
		p.setString(1, nome_vendedor);
		p.setString(2, nome_cliente);
		p.setString(3, dataVenda);
		
		p.executeUpdate();
		
		p.close();
		c.close();
	}
	@Override
	public void excluir_registroDeVenda(int id) throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_excluir_registroDeVenda ?");
		p.setInt(1, id);
		p.executeUpdate();
		
		p.close();
		c.close();
	}
	@Override
	public List<String> listaProdutos() throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		List<String> listaProdutos = new ArrayList<>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_produto_carrinho");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			listaProdutos.add(rs.getString("nome"));
		}
		rs.close();
		p.close();
		c.close();
		return listaProdutos;
	}
	@Override
	public int buscar_registro_id()  throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_buscar_id_registro");
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			return rs.getInt("id");
		}
		return 0;
	}
	@Override
	public void adicionar_carrinho(List<String> produtos, List<String> quantidade, int id) throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		for(int i=0; i<produtos.size(); i++) {
			if(!quantidade.get(i).isEmpty() && quantidade.get(i) != "") {
				PreparedStatement p = c.prepareStatement("EXEC sp_adicionar_carrinho ?,?,?");
				p.setString(1, produtos.get(i));
				p.setInt(2, Integer.parseInt(quantidade.get(i)));
				p.setInt(3, id);
				
				p.executeUpdate();
				p.close();
			}
		}
		c.close();
	}
}
