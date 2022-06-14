package com.fateczl.SistemaGerenciamentoWEB.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fateczl.SistemaGerenciamentoWEB.model.Estoque;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.EstoqueDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;

@Controller
public class EstoqueController{

	@Autowired
	EstoqueDAO eDAO;
	
	@Autowired
	LoginDAO lDAO;
	
	@RequestMapping(name="Estoque", value="/Estoque", method=RequestMethod.GET)
	public ModelAndView estoque(ModelMap model) {
		String erro = "";
		List<Estoque> listaEstoque = new ArrayList<Estoque>();
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				listaEstoque = eDAO.listarEstoque();
				model.addAttribute("listaEstoque", listaEstoque);
				return new ModelAndView("Estoque");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("Estoque");
			}
		}catch(ClassNotFoundException| SQLException e){
			erro = e.getMessage();
		}finally {
			model.addAttribute("listaEstoque", listaEstoque);
		}
		return new ModelAndView();
	}
	@RequestMapping(name="Estoque", value="/Estoque", method=RequestMethod.POST)
	public ModelAndView estoque(ModelMap model, @RequestParam MultiValueMap<String,String> multi, @RequestParam Map<String,String> param) {
		String erro="";
		String botaoInput = param.get("inputPesquisa");
		List<String> ListaQuantidades = multi.get("quantidade{}");
		String botaoSalvar = param.get("botaoSalvar");
		List<Estoque> listaEstoque = new ArrayList<Estoque>();
		
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				if(botaoInput.isEmpty()) {
					listaEstoque = eDAO.listarEstoque();
				}else {
					listaEstoque = eDAO.listarProdutoPorNome(botaoInput);
					if(listaEstoque.isEmpty()) {
						listaEstoque = eDAO.listarEstoque();
						model.addAttribute("listaEstoque", listaEstoque);
						return new ModelAndView("Estoque");
					}else {
						model.addAttribute("erro", erro);
						model.addAttribute("listaEstoque", listaEstoque);
						return new ModelAndView("Estoque");
					}
				}
				if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
					List<Estoque> listaAtualizada = new ArrayList<Estoque>();
					for(int i=0; i< listaEstoque.size(); i++) {
						Estoque novoItem = new Estoque();
						novoItem.setNome(listaEstoque.get(i).getNome());
						novoItem.setQuantidade(Integer.parseInt(ListaQuantidades.get(i)));
						listaAtualizada.add(novoItem);
					}
					eDAO.editarEstoque(listaAtualizada);
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("Estoque");
			}
		}catch (ClassNotFoundException | SQLException e)  {
			erro = e.getMessage();
		}
		model.addAttribute("listaEstoque", listaEstoque);
		return new ModelAndView("Estoque");
	}	
}
