package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.Usuario;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.GerenciarUsuariosDAO;

@Repository
public class GerenciarUsuariosDAOImpl implements GerenciarUsuariosDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public List<Usuario> listaUsuario() throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		List<Usuario> listaUsuario = new ArrayList<>();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_listar_usuarios");
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			listaUsuario.add(instaciarUsuario(rs));
		}
		rs.close();
		p.close();
		c.close();
		return listaUsuario;
	}

	@Override
	public void adicionarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_adicionar_usuario ?, ?, ?, ?, ?");
		p.setString(1, usuario.getNome());
		p.setString(2, usuario.getLogin());
		p.setString(3, usuario.getSenha());
		p.setString(4, usuario.getEmail());
		p.setInt(5, usuario.getTipo_usuario());
		
		p.executeUpdate();
		p.close();
		c.close();
	}

	@Override
	public boolean verificarDuplicidade(String login_usuario, String email) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_verificar_duplicidade ?,?");
		p.setString(1, login_usuario);
		p.setString(2, email);
		ResultSet rs = p.executeQuery();
		if(!rs.next()) {
			return true;
		}
		
		p.close();
		rs.close();
		c.close();
		return false;
	}

	@Override
	public void editarUsuarioPorId(Usuario usuario) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_editar_usuario ?,?,?,?");
		
		p.setInt(1, usuario.getId());
		p.setString(2, usuario.getNome());
		p.setString(3, usuario.getEmail());
		p.setInt(4, usuario.getTipo_usuario());
		
		p.executeUpdate();
		
		p.close();
		c.close();
		
	}

	@Override
	public void excluirUsuarioPorId(int id) throws SQLException, ClassNotFoundException {
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_excluir_usuario ?");
		p.setInt(1, id);
		p.executeUpdate();
		
		p.close();
		c.close();
		
	}

	@Override
	public List<Usuario> pesquisarUsuarioPorNome(String nome) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		List<Usuario> listaUsuario = new ArrayList<>();
		PreparedStatement p = c.prepareStatement("EXEC sp_pesquisar_Usuario_Por_Nome ?");
		p.setString(1, nome);
		
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			listaUsuario.add(instaciarUsuario(rs));
		}
		
		p.close();
		rs.close();
		c.close();
		
		return listaUsuario;
	}
	@Override
	public Usuario pesquisarUsuarioPorId(int id) throws SQLException, ClassNotFoundException{
		
		Connection c = gDAO.getConnection();
		
		Usuario usuario = new Usuario();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_pesquisar_Usuario_Por_Id ?");
		p.setInt(1, id);
		
		ResultSet rs = p.executeQuery();
		if (rs.next()) {
			usuario = instaciarUsuario(rs);
		}
		
		return usuario;
	}
	public Usuario instaciarUsuario(ResultSet rs) {
		Usuario usuario = new Usuario();
		try {
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setLogin(rs.getString("login_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	
}
