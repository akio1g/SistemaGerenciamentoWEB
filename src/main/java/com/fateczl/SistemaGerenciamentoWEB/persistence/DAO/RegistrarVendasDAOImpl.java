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
			rg.setVendedor(rs.getString("vendedor"));
			rg.setCliente(rs.getString("cliente"));
			rg.setData(rs.getDate("data"));
			rg.setCarrinho(rs.getInt("id_carrinho"));
			rg.setValor(rs.getDouble("valor"));
			
			listaVenda.add(rg);
		}
		rs.close();
		p.close();
		c.close();
	
		return listaVenda;
	}
	@Override
	public List<RegistroDeVenda> listaVendaPorVendedor(String nome_vendedor) throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		List<RegistroDeVenda> listaVenda = new ArrayList<>();
		
		PreparedStatement p = c.prepareStatement("");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			RegistroDeVenda rg = new RegistroDeVenda();
			
			rg.setId(rs.getInt("id"));
			rg.setVendedor(rs.getString("vendedor"));
			rg.setCliente(rs.getString("cliente"));
			rg.setData(rs.getDate("data"));
			rg.setCarrinho(rs.getInt("id_carrinho"));
			rg.setValor(rs.getDouble("valor"));
			
			listaVenda.add(rg);
		}
		rs.close();
		p.close();	
		c.close();
	
		return listaVenda;
	}
	@Override
	public List<Carrinho> listarCarrinho(int id) throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		List<Carrinho> listaCarrinho = new ArrayList<>();
		
		PreparedStatement p = c.prepareStatement("");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Carrinho carrinho = new Carrinho();
			
			carrinho.setId(rs.getInt("id"));
			carrinho.setProduto(rs.getString("produto"));
			carrinho.setQuantidade(rs.getInt("quantidade"));
			carrinho.setValor(rs.getDouble("valor"));
			
			listaCarrinho.add(carrinho);
		}
		
		return null;
		
	}
	
}
