package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.Cliente;
import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.ClienteDAO;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public List<Cliente> listaClientes() throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		String sql = "EXEC sp_lista_clientes";
		PreparedStatement p = c.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getLong("id"));
			cliente.setNomeRazaoSocial(rs.getString("nomeRazaoSocial"));
			cliente.setCpfCnpj(rs.getString("cpfCnpj"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setEmail(rs.getString("email"));
			cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
			listaClientes.add(cliente);
		}
		rs.close();
		p.close();
		c.close();
		return listaClientes;
	}

	@Override
	public void adicionarCliente(Cliente cliente, Endereco end) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		String sql = "INSERT INTO Cliente VALUES(?,?,?,?,?)";
		String sqlEndeco = "INSERT INTO Endereco VALUES(?,?,?,?,?,?,?)";
	
		PreparedStatement p = c.prepareStatement(sql);
		PreparedStatement pE = c.prepareStatement(sqlEndeco);
		p.setString(1, cliente.getNomeRazaoSocial());
		p.setString(2, cliente.getCpfCnpj());
		p.setString(3, cliente.getTelefone());
		p.setString(4, cliente.getEmail());
		p.setString(5, cliente.getInscricaoEstadual());
		p.executeUpdate();
		
		
		String buscaId = "SELECT id FROM Cliente WHERE cpfCnpj = ?";
		PreparedStatement pB = c.prepareStatement(buscaId);
		pB.setString(1, cliente.getCpfCnpj());
		ResultSet rs = pB.executeQuery();
		if(rs.next()) {
			pE.setInt(1, rs.getInt("id"));
			pE.setString(2, end.getCep());
			pE.setString(3, end.getCidade());
			pE.setString(4, end.getEstado());
			pE.setString(5, end.getLogradouro());
			pE.setString(6, end.getNumero());
			pE.setString(7, end.getComplemento());
			
			
			pE.executeUpdate();
		}
		
		pE.close();
		p.close();
		c.close();
	
	}

	@Override
	public boolean verificarDuplicidade(String cpf) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "SELECT cpfCnpj FROM Cliente WHERE cpfCnpj = ?";
		
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, cpf);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}
}
