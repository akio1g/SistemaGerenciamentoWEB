package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;

@Repository	
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	GenericDAO gDAO;
	
	@Override
	public String verificarAcesso() throws SQLException, ClassNotFoundException{
		
		String cargo = "Usuario não identificado";
		int aux = 0;
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("Exec sp_verificar_cargo");
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			aux = rs.getInt("tipo_usuario");
		}
		switch(aux) {
			case 1:
				cargo = "Administrador";
				break;
			case 2:
				 cargo = "Estoquista";
				break;
			case 3:
				cargo = "Vendedor";
				break;
		}
		return cargo;
	}
	
	@Override
	public void SalvarAutenticacao(String login) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("Exec sp_salvarAutenticacao ?");
		p.setString(1, login);
		p.executeUpdate();
		
		p.close();
		c.close();
	}

	@Override
	public boolean validarAcesso(String nome, String senha) throws SQLException, ClassNotFoundException {
		
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_validar_acesso ?,?");
		p.setString(1, nome);
		p.setString(2, senha);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			return true;
		}
		p.close();
		rs.close();
		c.close();
		return false;
	}
	
	@Override
	public void limpar_acesso() throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_limpar_acesso");
		p.executeUpdate();
		
		p.close();
		c.close();
	}
	@Override
	public void resetar_senha(String email, String login, String senha) throws SQLException, ClassNotFoundException{
		Connection c = gDAO.getConnection();
		
		PreparedStatement p = c.prepareStatement("EXEC sp_resetar_senha ?,?,?");
		p.setString(1, login);
		p.setString(2, email);
		p.setString(3, senha);
		
		p.executeUpdate();
		
		p.close();
		c.close();
	}
}
