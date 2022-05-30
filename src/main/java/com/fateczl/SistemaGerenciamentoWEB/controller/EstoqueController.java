package com.fateczl.SistemaGerenciamentoWEB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.EstoqueDAO;

@Controller
public class EstoqueController{

	@Autowired
	EstoqueDAO eDAO;
	
	@RequestMapping(name="Estoque", value="/Estoque", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView();
	}
}
