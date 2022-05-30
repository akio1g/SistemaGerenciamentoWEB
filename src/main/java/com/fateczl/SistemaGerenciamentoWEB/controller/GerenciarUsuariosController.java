package com.fateczl.SistemaGerenciamentoWEB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.GerenciarUsuariosDAO;

@Controller
public class GerenciarUsuariosController {
	
	@Autowired
	GerenciarUsuariosDAO guDAO;
	
	@RequestMapping(name="GerenciarUsuarios", value="/GerenciarUsuarios", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView();
	}
}
