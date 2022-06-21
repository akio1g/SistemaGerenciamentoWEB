package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RelatorioDAO;

@Repository
public class RelatorioDAOImpl implements RelatorioDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public List<RegistroDeVenda> listaRelatorios() throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		List<RegistroDeVenda> listaRelatorios = new ArrayList<RegistroDeVenda>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_relatorios");
		
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			RegistroDeVenda r = new RegistroDeVenda();
			
			r.setId(rs.getInt("id"));
			r.setCliente(rs.getString("nome_cliente"));
			r.setValor(rs.getDouble("valor"));
			
			listaRelatorios.add(r);
		}
		c.close();
		p.close();
		rs.close();
		return listaRelatorios;
	}

}
