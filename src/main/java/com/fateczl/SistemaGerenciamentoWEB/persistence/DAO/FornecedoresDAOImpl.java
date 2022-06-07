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
import com.fateczl.SistemaGerenciamentoWEB.model.Fornecedor;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.FornecedoresDAO;

@Repository
public class FornecedoresDAOImpl implements FornecedoresDAO{

	@Autowired
	GenericDAO gDAO;

	@Override
	public void adicionarFornecedor(Fornecedor fornecedor, Endereco end) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		
		PreparedStatement p = c.prepareStatement("EXEC sp_adicionar_fornecedores ?,?,?,?,?,?,?,?,?,?");
		p.setString(1, fornecedor.getRazaoSocial());
		p.setString(2, fornecedor.getCnpj());
		p.setString(3, fornecedor.getInscricaoEstadual());
		p.setString(4, fornecedor.getTelefone());

		p.setString(5, end.getCep());
		p.setString(6, end.getCidade());
		p.setString(7, end.getEstado());
		p.setString(8, end.getLogradouro());
		p.setInt(9, end.getNumero());
		p.setString(10, end.getComplemento());
		
		p.executeUpdate();
		
		p.close();
		c.close();
	}

	@Override
	public List<Fornecedor> listaFornecedor() throws SQLException, ClassNotFoundException {

		Connection c = gDAO.getConnection();
		
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_lista_fornecedores");
		
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(rs.getInt("id"));
			fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setInscricaoEstadual("inscricaoEstadual");
			fornecedor.setTelefone(rs.getString("telefone"));
			listaFornecedores.add(fornecedor);
		}
		rs.close();
		p.close();
		c.close();
		return listaFornecedores;
	}
	@Override
	public List<Fornecedor> pesquisarFornecedoresPorNome(String nome_fornecedor) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		PreparedStatement p = c.prepareStatement("EXEC sp_buscar_fornecedor_por_nome ?");
		
		p.setString(1, nome_fornecedor);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(rs.getInt("id"));
			fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setInscricaoEstadual(rs.getString("telefone"));
			fornecedor.setTelefone(rs.getString("telefone"));
			
			listaFornecedores.add(fornecedor);
		}
		c.close();
		p.close();
		rs.close();
		
		return listaFornecedores;
	}
	@Override
	public Fornecedor buscarFornecedorPorId(int id_fornecedor) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps= c.prepareStatement("EXEC sp_buscar_fornecedor_por_id ?");
		
		ps.setInt(1, id_fornecedor);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(rs.getInt("id"));
			fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setInscricaoEstadual(rs.getString("telefone"));
			fornecedor.setTelefone(rs.getString("telefone"));
			
			return fornecedor;
		}
		c.close();
		ps.close();
		rs.close();
		return null;
	}
	@Override
	public Endereco buscarEnderecoFornecedorPorId(int id_fornecedor) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps= c.prepareStatement("EXEC sp_buscar_endereco_por_id_fornecedor ?");
		
		ps.setInt(1, id_fornecedor);
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
		c.close();
		ps.close();
		rs.close();
		return null;
	}
	@Override
	public void editarFornecedor(Fornecedor f, Endereco e)  throws SQLException, ClassNotFoundException {
	
		Connection c = gDAO.getConnection();
		PreparedStatement p = c.prepareStatement("EXEC sp_update_fornecedor ?,?,?,?,?,?,?,?,?,?,?");
		p.setInt(1, f.getId());
		p.setString(2, f.getRazaoSocial());
		p.setString(3, f.getCnpj());
		p.setString(4, f.getTelefone());
		p.setString(5, f.getInscricaoEstadual());
		
		p.setString(6, e.getCep());
		p.setString(7, e.getCidade());
		p.setString(8, e.getEstado());
		p.setString(9, e.getLogradouro());
		p.setInt(10, e.getNumero());
		p.setString(11, e.getComplemento());
		
		p.executeUpdate();
		
		c.close();
		p.close();
	}

	@Override
	public void excluirFornecedorPorId(int id_fornecedor) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement ps = c.prepareStatement("EXEC sp_excluir_fornecedor_por_id ?");
		
		ps.setLong(1, id_fornecedor);
		ps.executeUpdate();
		c.close();
		ps.close();
	}
	
	@Override
	public boolean verificarDuplicidade(String cnpj) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String sql = "SELECT cnpj FROM Fornecedor WHERE cnpj = ?";
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, cnpj);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}
}
