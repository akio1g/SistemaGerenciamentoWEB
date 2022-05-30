package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.model.Fornecedor;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.FornecedoresDAO;

@Repository
public class FornecedoresDAOImpl implements FornecedoresDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public List<Fornecedor> listaFornecedor() throws SQLException, ClassNotFoundException {

		Connection c = gDAO.getConnection();
		
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		String sql = "EXEC sp_lista_fornecedores";
		PreparedStatement p = c.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
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
	public void adicionarFornecedor(Fornecedor fornecedor, Endereco end) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		String sql = "INSERT INTO Fornecedor VALUES(?,?,?,?)";
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, fornecedor.getRazaoSocial());
		p.setString(2, fornecedor.getCnpj());
		p.setString(3, fornecedor.getInscricaoEstadual());
		p.setString(4, fornecedor.getTelefone());
		
		p.executeUpdate();
		
		String sqlEndeco = "INSERT INTO Endereco VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pE = c.prepareStatement(sqlEndeco);
		
		String buscaId = "SELECT id FROM Cliente WHERE cpfCnpj = ?";
		PreparedStatement pB = c.prepareStatement(buscaId);
		pB.setString(1, fornecedor.getCnpj());
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
		p.close();
		c.close();
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

	@Override
	public void editarFornecedor(Fornecedor c) throws ClassNotFoundException {
		try {
			Connection con = gDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE FORNECEDOR SET razaoSocial = ?, cnpj = ?, telefone = ?, inscricaoEstadual = ?\r\n"
					+ "WHERE Id = ?");
			ps.setString(1, c.getRazaoSocial());
			ps.setString(2, c.getCnpj());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getInscricaoEstadual());
			ps.setLong(5, c.getId());
			ps.executeUpdate();
			
			con.close();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void excluirFornecedorPorId(Long id) throws ClassNotFoundException {
		try {
			Connection c = gDAO.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM FORNECEDOR WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			c.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
