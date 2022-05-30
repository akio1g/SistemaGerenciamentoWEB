package com.fateczl.SistemaGerenciamentoWEB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.persistence.DAO.ProdutoDAOImpl;

@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoDAOImpl pDAO;
	
	@RequestMapping(name="Produto", value="/Produto", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="ProdutoListar", value="/ProdutoListar", method=RequestMethod.GET)
	public ModelAndView listaProduto(ModelMap model) {
		return new ModelAndView();
	}
}
