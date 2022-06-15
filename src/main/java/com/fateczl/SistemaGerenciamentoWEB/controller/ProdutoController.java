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

import com.fateczl.SistemaGerenciamentoWEB.model.Categoria;
import com.fateczl.SistemaGerenciamentoWEB.model.Fornecedor;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;
import com.fateczl.SistemaGerenciamentoWEB.persistence.DAO.ProdutoDAOImpl;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.FornecedoresDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;

@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoDAOImpl pDAO;
	
	@Autowired
	LoginDAO lDAO;
	
	@Autowired
	FornecedoresDAO fDAO;
	
	private static int id_produto;
	private static int id_categoria;
	
	@RequestMapping(name="Produto", value="/Produto", method=RequestMethod.GET)
	public ModelAndView Produto(ModelMap model) {
		List<Categoria> listaCategorias = new ArrayList<>();
		
		String erro="";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				listaCategorias = pDAO.listarCategorias();
				model.addAttribute("listaCategorias", listaCategorias);
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
		List<Categoria> listaCategorias = new ArrayList<>();
		List<Fornecedor> listaFornecedores = new ArrayList<>();
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				listaFornecedores = fDAO.listaFornecedor();
				listaCategorias = pDAO.listarCategorias();
				model.addAttribute("listaCategorias", listaCategorias);
				model.addAttribute("listaFornecedores", listaFornecedores);
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
				produto.setCategoria(param.get("categoria"));
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
		List<Fornecedor> listaFornecedor = new ArrayList<>();
		List<Categoria> listaCategorias = new ArrayList<>();
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				produto = pDAO.pesquisarProdutoPorId(id_produto);
				listaCategorias = pDAO.listarCategorias();
				listaFornecedor = fDAO.listaFornecedor();
				model.addAttribute("listaFornecedores", listaFornecedor);
				model.addAttribute("listaCategorias", listaCategorias);
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
	@RequestMapping(name="Categorias", value="/Categorias", method=RequestMethod.GET)
	public ModelAndView categorias(ModelMap model) {
		String erro = "";
		try {
			List<Categoria> listaCategorias = pDAO.listarCategorias();
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				model.addAttribute("listaCategorias", listaCategorias);
				return new ModelAndView("Categorias");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("Categorias");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("Categorias");
	}	
	@RequestMapping(name="Categorias", value="/Categorias", method=RequestMethod.POST)
	public ModelAndView categorias(ModelMap model,@RequestParam Map<String, String> param) {
		String erro = "";
		String botaoEditar = param.get("botaoEditar");
		String botaoInput = param.get("inputPesquisa");
		List<Categoria> listaCategorias = new ArrayList<>();
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				if(botaoInput.isEmpty()) {
					listaCategorias = pDAO.listarCategorias();
				}else {
					listaCategorias = pDAO.pesquisar_categoria_por_nome(botaoInput);
					if(listaCategorias.isEmpty()) {
						listaCategorias = pDAO.listarCategorias();
						model.addAttribute("listaCategorias", listaCategorias);
						return new ModelAndView("Categorias");
					}else {
						model.addAttribute("listaCategorias", listaCategorias);
						return new ModelAndView("Categorias");
					}
				}
				if(botaoEditar != null && !botaoEditar.isEmpty()) {
					id_categoria = Integer.parseInt(botaoEditar);
					categoriasEditar(model);
					model.addAttribute("listaCategorias", listaCategorias);
					return new ModelAndView("CategoriasEditar");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("Categorias");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("Categorias");
	}
	@RequestMapping(name="CategoriasAdicionar", value="/CategoriasAdicionar", method=RequestMethod.GET)
	public ModelAndView categoriasAdicionar(ModelMap model) {
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				return new ModelAndView("CategoriasAdicionar");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("CategoriasAdicionar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	@RequestMapping(name="CategoriasAdicionar", value="/CategoriasAdicionar", method=RequestMethod.POST)
	public ModelAndView categoriasAdicionar(ModelMap model,@RequestParam Map<String, String> param) {
		String erro = "";
		String botaoAdicionar = param.get("botaoAdicionar");
		
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				if(!botaoAdicionar.isEmpty()) {
					Categoria categoria = new Categoria();
					
					categoria.setNome(param.get("nome"));
					
					if(!pDAO.verificar_duplicidade_categoria(categoria.getNome())) {
						pDAO.adicionar_categoria(categoria);
						erro = "Categoria Adicionada";
						model.addAttribute("erro", erro);
						return new ModelAndView("CategoriasAdicionar");
					}else {
						erro = "Categoria já cadastrada";
						model.addAttribute("erro", erro);
						return new ModelAndView("CategoriasAdicionar");
					}
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("CategoriasAdicionar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("CategoriasAdicionar");
	}
	@RequestMapping(name="CategoriasEditar", value="/CategoriasEditar", method=RequestMethod.GET)
	public ModelAndView categoriasEditar(ModelMap model) {
		try {
			Categoria categoria = new Categoria();
			String erro = "";
			
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				categoria = pDAO.pesquisar_categoria_por_id(id_categoria);
				model.addAttribute("categoria", categoria);
				return new ModelAndView("CategoriasEditar");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("CategoriasEditar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("CategoriasEditar");
	}
	@RequestMapping(name="CategoriasEditar", value="/CategoriasEditar", method=RequestMethod.POST)
	public ModelAndView categoriasEditar(ModelMap model,@RequestParam Map<String, String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String botaoExcluir = param.get("botaoExcluir");
		String erro = "";
	
		try {
			if(lDAO.verificarAcesso().equals("Estoquista") || lDAO.verificarAcesso().equals("Administrador")) {
				Categoria categoria = new Categoria();
				
				categoria.setId(Integer.parseInt(param.get("id")));
				categoria.setNome(param.get("nome"));
				
				if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
					pDAO.editar_categoria(categoria);
					return new ModelAndView("CategoriasEditar");
				}
				if(botaoExcluir != null && !botaoExcluir.isEmpty()) {
					pDAO.excluir_categoria_por_id(categoria.getId());
					return new ModelAndView("CategoriasEditar");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("CategoriasEditar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("CategoriasEditar");
	}
}
