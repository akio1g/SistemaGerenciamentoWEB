package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;

public interface RelatoriosDAOImpl {
	public List<RegistroDeVenda> listaVendas() throws SQLException, ClassNotFoundException;

}
