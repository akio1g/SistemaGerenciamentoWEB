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
		String inputLogin = param.get("login");
		String inputSenha = param.get("field-password");
		String botaoAcessar = param.get("btn-login");

		String erro="";
		
		if(botaoAcessar != null && !botaoAcessar.isEmpty()) {
			try {
				if(lDAO.validarAcesso(inputLogin, inputSenha)) {
					lDAO.SalvarAutenticacao(inputLogin);
					return new ModelAndView("Home");
				}else {
					erro = "Usuario ou senha incorreta";
					model.addAttribute("erro", erro);
					return new ModelAndView("Login");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		return new ModelAndView("Login");
	}
	@RequestMapping(name="LoginReset", value="/LoginReset", method=RequestMethod.GET)
	public ModelAndView loginReset(ModelMap model) {
		try {
			lDAO.limpar_acesso();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("LoginReset");
	}
	@RequestMapping(name="LoginReset", value="/LoginReset", method=RequestMethod.POST)
	public ModelAndView loginReset(ModelMap model, @RequestParam Map<String,String> param) {
		String email = param.get("field-email");
		String login = param.get("login");
		String senha = param.get("field-password");
		String botaoSalvar = param.get("btn-salvar");
		
		try {
			if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
				lDAO.resetar_senha(email, login, senha);
				return new ModelAndView("Login");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
 		return new ModelAndView("LoginReset");
	}
	
	@RequestMapping(name="Home", value="/Home", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="Home", value="/Home", method=RequestMethod.POST)
	public ModelAndView home(ModelMap model, @RequestParam Map<String,String> param) {
		String botaoDesconectar = param.get(param.get("desconectar"));
		try {
			if(botaoDesconectar != null && !botaoDesconectar.isEmpty()) {
				lDAO.limpar_acesso();
				return new ModelAndView("Login");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("Login");
	}
}
