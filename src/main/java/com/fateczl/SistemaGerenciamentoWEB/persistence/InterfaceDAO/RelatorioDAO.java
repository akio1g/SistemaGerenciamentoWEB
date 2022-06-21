package com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;

public interface RelatorioDAO {
	public List<RegistroDeVenda> listaRelatorios() throws SQLException, ClassNotFoundException;
}
