package com.fateczl.SistemaGerenciamentoWEB.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.model.Carrinho;
import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RegistroVendasDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RelatorioDAO;

@Controller
public class RelatorioController {
	
	@Autowired
	LoginDAO lDAO;
	
	@Autowired
	RegistroVendasDAO rDAO;
	
	@Autowired
	RelatorioDAO rlDAO;
	
	private static int id_registro;
	
	@RequestMapping(name="RelatorioListar", value="/RelatorioListar", method=RequestMethod.GET)
	public ModelAndView relatorioListar(ModelMap model) {
		String erro="";
		
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				List<RegistroDeVenda> listaRelatorios = new ArrayList<RegistroDeVenda>();
				listaRelatorios = rlDAO.listaRelatorios();
				model.addAttribute("listaRelatorios", listaRelatorios);
				return new ModelAndView("RelatorioListar");
			}else {
				erro="Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RelatorioListar");
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return new ModelAndView();
	}
	@RequestMapping(name="RelatorioListar", value="RelatorioListar", method=RequestMethod.POST)
	public ModelAndView relatorioListar(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoVisualizar = param.get("botaoVisualizar");
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				if(botaoVisualizar != null && !botaoVisualizar.isEmpty()) {
					id_registro = Integer.parseInt(param.get("botaoVisualizar"));
					relatorioExibir(model);
					return new ModelAndView("RelatorioExibir");
				}
			}else {
				erro="Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RelatorioListar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}	
	@RequestMapping(name="RelatorioExibir", value="RelatorioExibir", method=RequestMethod.GET)
	public ModelAndView relatorioExibir(ModelMap model) {
		String erro="";
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				List<Carrinho> carrinho = new ArrayList<Carrinho>();
				RegistroDeVenda registro = new RegistroDeVenda();
				
				registro = rDAO.buscar_registro_por_id(id_registro);
				carrinho = rDAO.listaProdutosCarrinho(id_registro);
				
				model.addAttribute("registro", registro);
				model.addAttribute("carrinho", carrinho);
				
				return new ModelAndView("RelatorioExibir");
				
			}else{
				erro="Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RelatorioExibir");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
