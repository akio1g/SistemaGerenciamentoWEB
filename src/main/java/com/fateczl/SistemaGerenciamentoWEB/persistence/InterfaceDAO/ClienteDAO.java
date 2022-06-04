package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.Cliente;
import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;

public interface ClienteDAO {
	public List<Cliente> listaClientes() throws SQLException, ClassNotFoundException;
	public void adicionarCliente(Cliente cliente, Endereco end) throws SQLException, ClassNotFoundException;
	public boolean verificarDuplicidade(String cpf) throws SQLException, ClassNotFoundException;
	public void editarClientePorId(Cliente c, Endereco e)throws SQLException, ClassNotFoundException;
	public void excluirClientePorId(int id) throws SQLException, ClassNotFoundException;
	List<Cliente> pesquisarClientesPorNome(String nome) throws SQLException, ClassNotFoundException;
	public Cliente buscarClientePorId(int id_cliente) throws ClassNotFoundException;
	public Endereco buscarEnderecoPorId(int id_cliente) throws ClassNotFoundException;
	}
