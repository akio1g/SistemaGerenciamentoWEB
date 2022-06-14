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
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;

@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoDAOImpl pDAO;
	
	@Autowired
	LoginDAO lDAO;
	
	private static int id_produto;
	private static int id_categoria;
	
	@RequestMapping(name="Produto", value="/Produto", method=RequestMethod.GET)
	public ModelAndView Produto(ModelMap model) {
		String erro="";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				return new ModelAndView("Produto");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("Produto");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("Produto");
	}
	@RequestMapping(name="Produto", value="/Produto", method=RequestMethod.POST)
	public ModelAndView Produto(ModelMap model, @RequestParam Map<String,String> param) {
		id_categoria = Integer.parseInt(param.get("botaoCategoria"));
		return listaProduto(model);
	}
	@RequestMapping(name="ProdutoAdicionar", value="/ProdutoAdicionar", method=RequestMethod.GET)
	public ModelAndView produtoAdicionar(ModelMap model) {
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				return new ModelAndView("ProdutoAdicionar");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("ProdutoAdicionar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	@RequestMapping(name="ProdutoAdicionar", value="/ProdutoAdicionar", method=RequestMethod.POST)
	public ModelAndView produtoAdicionar(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String erro = "";
		
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				Produto produto = new Produto();
				
				produto.setNome(param.get("Nome"));
				produto.setDescricao(param.get("Descricao"));
				produto.setNcmSh(param.get("ncmSh"));
				produto.setPreco(Double.parseDouble(param.get("preco")));
				
				switch (param.get("categoria")) {
				case "Gorje":
					produto.setCategoria("Gorje");
					break;
				case "Yale":
					produto.setCategoria("Yale");
					break;
				case "Yale Dupla":
					produto.setCategoria("Yale Dupla");
					break;
				case "Tetra":
					produto.setCategoria("Tetra");
					break;
				case "Pantograficas":
					produto.setCategoria("Pantograficas");
					break;
				case "Codificadas":
					produto.setCategoria("Codificadas");
					break;
				case "Laminas de Segredo":
					produto.setCategoria("Laminas de Segredo");
					break;
					
				}
				produto.setFornecedor(param.get("fornecedor"));
				if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
					pDAO.adicionarProduto(produto);
					return new ModelAndView("Produto");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("ProdutoAdicionar");
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	@RequestMapping(name="ProdutoListar", value="/ProdutoListar", method=RequestMethod.GET)
	public ModelAndView listaProduto(ModelMap model) {
		String erro = "";
		List<Produto> listaProduto = new ArrayList<Produto>();
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				listaProduto = pDAO.listarPorCategoria(id_categoria);
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("ProdutoListar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("listaProduto", listaProduto);
		return new ModelAndView("ProdutoListar");
	}
	@RequestMapping(name="ProdutoListar", value="/ProdutoListar", method=RequestMethod.POST)
	public ModelAndView listaProduto(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoInput = param.get("inputPesquisa");
		String botaoEditar = param.get("botaoEditar");
		String erro = "";
		List<Produto> listaProduto = new ArrayList<>();
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				if(botaoInput.isEmpty()) {
					listaProduto = pDAO.listarPorCategoria(id_categoria);
				}else {
					listaProduto = pDAO.pesquisarProdutoPorNome(botaoInput);
					if(listaProduto.isEmpty()) {
						listaProduto = pDAO.listarPorCategoria(id_categoria);
						model.addAttribute("erro", erro);
						model.addAttribute("listaProduto", listaProduto);
					}else {
						model.addAttribute("erro", erro);
						model.addAttribute("listaProduto", listaProduto);
						return new ModelAndView("ProdutoListar");
					}
				}
				if(botaoEditar != null && !botaoEditar.isEmpty()) {
					id_produto = Integer.parseInt(botaoEditar);
					produtoEditar(model);
					return new ModelAndView("ProdutoEditar");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("ProdutoListar");
			}
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("listaProduto", listaProduto);
		}
		return new ModelAndView("ProdutoListar");
	}
	@RequestMapping(name="ProdutoEditar", value="/ProdutoEditar", method=RequestMethod.GET)
	public ModelAndView produtoEditar(ModelMap model) {
		Produto produto = new Produto();
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				produto = pDAO.pesquisarProdutoPorId(id_produto);
				return new ModelAndView("ProdutoEditar");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("ProdutoEditar");
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("produto", produto);
		}
		return new ModelAndView("ProdutoEditar");
		
	}
	@RequestMapping(name="ProdutoEditar", value="/ProdutoEditar", method=RequestMethod.POST)
	public ModelAndView produtoEditar(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String botaoExcluir = param.get("botaoExcluir");
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				Produto produto = new Produto();
				
				produto.setId(Integer.parseInt(param.get("Id")));
				produto.setNome(param.get("Nome"));
				produto.setDescricao(param.get("Descricao"));
				produto.setNcmSh(param.get("ncmSh"));
				produto.setCategoria(param.get("categoria"));
				produto.setPreco(Double.parseDouble(param.get("preco")));
				produto.setFornecedor(param.get("fornecedor"));
				
				if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
					pDAO.editarProduto(produto);
					return new ModelAndView("ProdutoEditar");
				}
				if(botaoExcluir != null && !botaoExcluir.isEmpty()) {
					pDAO.excluirPorId(produto.getId());
					return new ModelAndView("ProdutoEditar");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("ProdutoEditar");
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		return new ModelAndView();
	}
}
