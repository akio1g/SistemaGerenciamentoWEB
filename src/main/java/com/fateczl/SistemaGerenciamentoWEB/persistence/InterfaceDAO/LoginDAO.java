package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;

public interface LoginDAO {
	public boolean validarAcesso(String nome, String senha) throws SQLException, ClassNotFoundException;
	public void SalvarAutenticacao(String login) throws SQLException, ClassNotFoundException;
	public String verificarAcesso() throws SQLException, ClassNotFoundException;
	public void limpar_acesso() throws SQLException, ClassNotFoundException;
}
