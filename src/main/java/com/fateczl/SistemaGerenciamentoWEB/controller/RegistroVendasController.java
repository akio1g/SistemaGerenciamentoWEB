package com.fateczl.SistemaGerenciamentoWEB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RegistroVendasDAO;

@Controller
public class RegistroVendasController {
	
	@Autowired
	RegistroVendasDAO rDAO;
	
	@RequestMapping(name="RegistroVendas", value="/RegistroVendas", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView();
	}
}
