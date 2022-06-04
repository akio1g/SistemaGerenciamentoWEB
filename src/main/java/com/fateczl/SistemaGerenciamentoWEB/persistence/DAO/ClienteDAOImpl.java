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
			cliente.setId(rs.getInt("id"));
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
	public List<Cliente> pesquisarClientesPorNome(String nome) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		String sql = "EXEC sp_buscar_cliente_por_nome ?";
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		PreparedStatement p = c.prepareStatement(sql);
		
		p.setString(1, nome);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNomeRazaoSocial(rs.getString("nomeRazaoSocial"));
			cliente.setCpfCnpj(rs.getString("cpfCnpj"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setEmail(rs.getString("email"));
			cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
			listaClientes.add(cliente);
		}
		c.close();
		p.close();
		rs.close();
		return listaClientes;
	}

	@Override
	public void adicionarCliente(Cliente cliente, Endereco end) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps = c.prepareStatement("EXEC sp_adicionar_cliente ?,?,?,?,?,?,?,?,?,?,?");
		
		ps.setString(1, cliente.getNomeRazaoSocial());
		ps.setString(2, cliente.getCpfCnpj());
		ps.setString(3, cliente.getTelefone());
		ps.setString(4, cliente.getEmail());
		ps.setString(5, cliente.getInscricaoEstadual());
		ps.setString(6, end.getCep());
		ps.setString(7, end.getCidade());
		ps.setString(8, end.getEstado());
		ps.setString(9, end.getLogradouro());
		ps.setInt(10, end.getNumero());
		ps.setString(11, end.getComplemento());
	
		ps.executeUpdate();
		ps.close();
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
		c.close();
		p.close();
		rs.close();
		return true;
	}
	@Override
	public Cliente buscarClientePorId(int id_cliente) throws ClassNotFoundException{
		try {
			Connection con = gDAO.getConnection();
			
			PreparedStatement ps= con.prepareStatement("EXEC sp_buscar_cliente_por_id ?");
			ps.setInt(1, id_cliente);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNomeRazaoSocial(rs.getString("nomeRazaoSocial"));
				cliente.setCpfCnpj(rs.getString("cpfCnpj"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				return cliente;
			}
			con.close();
			ps.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Endereco buscarEnderecoPorId(int id_cliente) throws ClassNotFoundException{
		try {
			Connection con = gDAO.getConnection();
		
			PreparedStatement ps = con.prepareStatement("EXEC sp_buscar_endereco_por_id_cliente ?");
			ps.setInt(1, id_cliente);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setCep(rs.getString("cep"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				return endereco;
			}
			con.close();
			ps.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void editarClientePorId(Cliente c, Endereco e) throws ClassNotFoundException {
		try {
			Connection con = gDAO.getConnection();
		
			PreparedStatement ps = con.prepareStatement("EXEC sp_update_cliente ?,?,?,?,?,?,?,?,?,?,?,?");
			ps.setLong(1, c.getId());
			ps.setString(2, c.getNomeRazaoSocial());
			ps.setString(3, c.getCpfCnpj());
			ps.setString(4, c.getTelefone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getInscricaoEstadual());
			ps.setString(7, e.getCep());
			ps.setString(8, e.getCidade());
			ps.setString(9, e.getEstado());
			ps.setString(10, e.getLogradouro());
			ps.setInt(11, e.getNumero());
			ps.setString(12, e.getComplemento());
			
			ps.executeUpdate();

			con.close();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void excluirClientePorId(int id) throws ClassNotFoundException {
		try {
			Connection c = gDAO.getConnection();
			PreparedStatement ps = c.prepareStatement("EXEC sp_excluir_cliente ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			c.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
