package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.model.Usuario;
import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.UsuarioDAO;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public void autenticar(String email, String senha) throws ClassNotFoundException {
		Usuario u = new Usuario();
		try {
			Connection c = gDAO.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * from usuario WHERE email = ? and senha = ?");
			ps.setString(1, email);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// mostrar mensagem de login efetuado
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// login falhou
	}

	private Usuario instanciarUsuario(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setName(rs.getString("nome"));
		u.setLogin(rs.getString("email"));
		u.setSenha(rs.getString("senha"));
		return u;
	}


}
