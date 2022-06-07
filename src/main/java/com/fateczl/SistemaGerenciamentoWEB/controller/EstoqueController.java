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

import com.fateczl.SistemaGerenciamentoWEB.model.Estoque;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.EstoqueDAO;

@Controller
public class EstoqueController{

	@Autowired
	EstoqueDAO eDAO;
	
	@RequestMapping(name="Estoque", value="/Estoque", method=RequestMethod.GET)
	public ModelAndView estoque(ModelMap model) {
		String erro = "";
		List<Estoque> listaProdutos = new ArrayList<Estoque>();
		try {
			listaProdutos = eDAO.listarProduto();

		}catch(ClassNotFoundException| SQLException e){
			erro = e.getMessage();
		}finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listaProduto", listaProdutos);
		}
		return new ModelAndView();
	}
	@RequestMapping(name="Estoque", value="/Estoque", method=RequestMethod.POST)
	public ModelAndView estoque(ModelMap model, @RequestParam Map<String,String> param) {
		String erro="";
		String botaoInput = param.get("inputPesquisa");
		String botaoSalvar = param.get("botaoSalvar");
		List<Estoque> listaEstoque = new ArrayList<Estoque>();
		
		try {
			if(botaoInput.isEmpty()) {
				listaEstoque = eDAO.listarProduto();
			}else {
				listaEstoque = eDAO.listarProdutoPorNome(botaoInput);
				if(listaEstoque.isEmpty()) {
					listaEstoque = eDAO.listarProduto();
					model.addAttribute("listaEstoque", listaEstoque);
					return new ModelAndView("Estoque");
				}else {
					model.addAttribute("erro", erro);
					model.addAttribute("listaEstoque", listaEstoque);
					return new ModelAndView("Estoque");
				}
				//if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
					//Lugar que vai gerenciar o estoque
				//}
			}
		}catch (ClassNotFoundException | SQLException e)  {
			
		}
		
		return new ModelAndView("Estoque");
	}	
	@RequestMapping(name="EstoqueEditar", value="/EstoqueEditar", method=RequestMethod.GET)
	public ModelAndView estoqueEditar(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="EstoqueEditar", value="/EstoqueEditar", method=RequestMethod.POST)
	public ModelAndView estoqueEditar(ModelMap model, @RequestParam Map<String, String> param) {
		return new ModelAndView();
	}
	
}
