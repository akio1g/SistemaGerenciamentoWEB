package com.fateczl.SistemaGerenciamentoWEB.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;

@Controller
public class LoginController {

	@Autowired
	LoginDAO lDAO;
	
	@RequestMapping(name="Login", value="/Login", method=RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		try {
			lDAO.limpar_acesso();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("Login");
	}
	@RequestMapping(name="Login", value="/Login", method=RequestMethod.POST)
	public ModelAndView login(ModelMap model, @RequestParam Map<String, String> param) {
		String inputLogin = param.get("Login");
		String inputSenha = param.get("Senha");
		String botaoAcessar = param.get("Acessar");
		String erro="";
		
		if(botaoAcessar != null && !botaoAcessar.isEmpty()) {
			try {
				if(lDAO.validarAcesso(inputLogin, inputSenha)) {
					lDAO.SalvarAutenticacao(inputLogin);
				}else {
					erro = "Usuario não identificado";
					model.addAttribute(erro);
					return new ModelAndView("Login");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		return new ModelAndView("Login");
	}
}
