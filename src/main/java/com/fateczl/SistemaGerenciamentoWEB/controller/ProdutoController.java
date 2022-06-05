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

import com.fateczl.SistemaGerenciamentoWEB.model.Produto;
import com.fateczl.SistemaGerenciamentoWEB.persistence.DAO.ProdutoDAOImpl;

@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoDAOImpl pDAO;
	
	@RequestMapping(name="Produto", value="/Produto", method=RequestMethod.GET)
	public ModelAndView Produto(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="Produto", value="/Produto", method=RequestMethod.POST)
	public ModelAndView Produto(ModelMap model, @RequestParam Map<String,String> param) {
		String botaoCategoria = param.get("botaoCategoria");
		
		List<Produto> listaProduto = new ArrayList<>();
		try {
			switch(botaoCategoria){
				case "Gorje":
					listaProduto = pDAO.listarPorCategoria(1);
					break;
				case "Yale":
					listaProduto = pDAO.listarPorCategoria(2);
					break;
				case "Yale Dupla":
					listaProduto = pDAO.listarPorCategoria(3);
					break;
				case "Tetra":
					listaProduto = pDAO.listarPorCategoria(4);
					break;
				case "Pantográficas":
					listaProduto = pDAO.listarPorCategoria(5);
					break;
				case "Codificadas":
					listaProduto = pDAO.listarPorCategoria(6);
					break;
				case "Lâminas de Segredo":
					listaProduto = pDAO.listarPorCategoria(7);
					break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			model.addAttribute("listaProduto", listaProduto);
		}
		return listaProduto(model);
	}
	@RequestMapping(name="ProdutoAdicionar", value="/ProdutoAdicionar", method=RequestMethod.GET)
	public ModelAndView produtoAdicionar(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="ProdutoAdicionar", value="/ProdutoAdicionar", method=RequestMethod.POST)
	public ModelAndView produtoAdicionar(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		
		try {
			Produto produto = new Produto();
			
			produto.setNome(param.get("Nome"));
			produto.setDescricao(param.get("Descricao"));
			produto.setNcmSh(param.get("ncmSh"));
			produto.setPreco(Double.parseDouble(param.get("preco")));
			produto.setCategoria(param.get("categoria"));
			
			if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
				pDAO.adicionarProduto(produto);
				return new ModelAndView("Produto");
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	@RequestMapping(name="ProdutoListar", value="/ProdutoListar", method=RequestMethod.GET)
	public ModelAndView listaProduto(ModelMap model) {
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		Produto produto = new Produto();
		
		produto.setNome("Higor");
		produto.setNcmSh("200");
		produto.setPreco(10.2);
		produto.setDescricao("");
		listaProduto.add(produto);
		model.addAttribute("listaProduto", listaProduto);
		return new ModelAndView();
	}
	@RequestMapping(name="ProdutoListar", value="/ProdutoListar", method=RequestMethod.POST)
	public ModelAndView listaProduto(ModelMap model, @RequestParam Map<String, String> param) {
		return new ModelAndView("ProdutoListar");
	}
	@RequestMapping(name="ProdutoEditar", value="/ProdutoEditar", method=RequestMethod.GET)
	public ModelAndView produtoEditar(ModelMap model) {
		return new ModelAndView();
		
	}
	@RequestMapping(name="ProdutoEditar", value="/ProdutoEditar", method=RequestMethod.POST)
	public ModelAndView produtoEditar(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String botaoExcluir = param.get("botaoExcluir");
		try {
			Produto produto = new Produto();
			
			produto.setNome(param.get("Nome"));
			produto.setDescricao(param.get("Descricao"));
			produto.setNcmSh(param.get("ncmSh"));
			produto.setPreco(Double.parseDouble(param.get("preco")));
			
			if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
				pDAO.editarProduto(produto);
				return new ModelAndView("Produto");
			}
			if(botaoExcluir != null && !botaoExcluir.isEmpty()) {
				pDAO.excluirPorId(produto.getId());
				return new ModelAndView("Produto");
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		return new ModelAndView();
	}
}
