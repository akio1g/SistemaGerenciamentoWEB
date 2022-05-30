package com.fateczl.SistemaGerenciamentoWEB.persistence.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fateczl.SistemaGerenciamentoWEB.persistence.GenericDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.ProdutoDAO;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO{

	@Autowired
	GenericDAO gDAO;
	
}
