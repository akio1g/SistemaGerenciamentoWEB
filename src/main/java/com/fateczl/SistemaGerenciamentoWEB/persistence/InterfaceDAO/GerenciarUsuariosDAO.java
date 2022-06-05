package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Usuario;

public interface GerenciarUsuariosDAO {
	public List<Usuario> listaUsuario() throws SQLException, ClassNotFoundException;
	public void adicionarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
	public boolean verificarDuplicidade(String login_usuario, String email) throws SQLException, ClassNotFoundException;
	public void editarUsuarioPorId(Usuario usuario)throws SQLException, ClassNotFoundException;
	public void excluirUsuarioPorId(int id) throws SQLException, ClassNotFoundException;
	List<Usuario> pesquisarUsuarioPorNome(String nome) throws SQLException, ClassNotFoundException;
	Usuario pesquisarUsuarioPorId(int id) throws SQLException, ClassNotFoundException;
}
