package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import com.fateczl.SistemaGerenciamentoWEB.model.Usuario;

public interface UsuarioDAO {
	public void autenticar(String email, String senha) throws ClassNotFoundException;
}
