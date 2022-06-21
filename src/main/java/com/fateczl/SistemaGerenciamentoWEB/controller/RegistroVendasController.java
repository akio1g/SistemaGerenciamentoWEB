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

import com.fateczl.SistemaGerenciamentoWEB.model.Carrinho;
import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.LoginDAO;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RegistroVendasDAO;

@Controller
public class RegistroVendasController {
	
	@Autowired
	RegistroVendasDAO rDAO;
	
	@Autowired
	LoginDAO lDAO;
	private int id_registro;
	
	@RequestMapping(name="RegistroVendas", value="/RegistroVendas", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		String erro = "";
		List<RegistroDeVenda> listaVenda = new ArrayList<>();
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				listaVenda = rDAO.listaVendas();
				model.addAttribute("listaVenda", listaVenda);
				return new ModelAndView("RegistroVendas");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RegistroVendas");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("RegistroVendas");
	}
	@RequestMapping(name="RegistroVendas", value="/RegistroVendas", method=RequestMethod.POST)
	public ModelAndView listarVendas(ModelMap model, @RequestParam Map<String,String> param) {
		
		String erro = "";
		String botaoExcluir = param.get("botaoExcluir");
		String botaoCarrinho = param.get("botaoid");
		List<RegistroDeVenda> listaVenda = new ArrayList<>();
		
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				if(botaoExcluir != null && !botaoExcluir.isEmpty()) {
					rDAO.excluir_registroDeVenda(Integer.parseInt(botaoExcluir));
					return new ModelAndView("RegistroVendas");
				}
				if(botaoCarrinho != null && !botaoCarrinho.isEmpty()) {
					id_registro = Integer.parseInt(botaoCarrinho);
					carrinho(model);
					return new ModelAndView("Carrinho");
				}
				listaVenda = rDAO.listaVendas();
				model.addAttribute("erro", erro);
				model.addAttribute("listaVenda", listaVenda);
				return new ModelAndView("RegistroVendas");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RegistroVendas");
			}
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listaVenda", listaVenda);
		}
		return new ModelAndView("RegistroVendas");
	}
	@RequestMapping(name="RegistroVendasAdicionar", value="/RegistroVendasAdicionar", method=RequestMethod.GET)
	public ModelAndView adicionarVendas(ModelMap model) {
		String erro = "";
		List<String> listaVendedores = new ArrayList<>();
		List<String> listaClientes = new ArrayList<>();
		
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				listaVendedores = rDAO.listaVendedores();
				listaClientes = rDAO.listaClientes();
				model.addAttribute("listaClientes", listaClientes);
				model.addAttribute("listaVendedores", listaVendedores);
				return new ModelAndView("RegistroVendasAdicionar");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RegistroVendasAdicionar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("RegistroVendasAdicionar");
		
	}
	@RequestMapping(name="RegistroVendasAdicionar", value="/RegistroVendasAdicionar", method=RequestMethod.POST)
	public ModelAndView adicionarVendas(ModelMap model, @RequestParam Map<String,String> param) {
		String botaoAdicionar = param.get("botaoAdicionar");
		String vendedor = param.get("vendedor");
		String cliente = param.get("cliente");
		String botaoData = param.get("botaoData");
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				if(!botaoAdicionar.isEmpty()) {
					rDAO.adicionar_registroDeVenda(vendedor, cliente, botaoData);
					erro = "Registro de venda adicionado";
					model.addAttribute("erro",erro);
					return new ModelAndView("RegistroVendasAdicionar");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RegistroVendasAdicionar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("RegistroVendasAdicionar");
	}
	@RequestMapping(name="CarrinhoAdicionar", value="/CarrinhoAdicionar", method=RequestMethod.GET)
	public ModelAndView adicionarCarrinho(ModelMap model) {
		List<String> listaProdutos = new ArrayList<>();
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				listaProdutos = rDAO.listaProdutos();
				model.addAttribute("listaProdutos", listaProdutos);
				return new ModelAndView("CarrinhoAdicionar");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("CarrinhoAdicionar");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("CarrinhoAdicionar");
	}
	@RequestMapping(name="CarrinhoAdicionar", value="/CarrinhoAdicionar", method=RequestMethod.POST)
	public ModelAndView adicionarCarrinho(ModelMap model, @RequestParam Map<String,String> param, @RequestParam MultiValueMap<String, String> allParam) {
		String botaoSalvar = param.get("botaoSalvar");
		List<String> listaProdutos = new ArrayList<>();
		List<String> quantidade = allParam.get("idQuantidade{}");
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
					listaProdutos = rDAO.listaProdutos();
					rDAO.adicionar_carrinho(listaProdutos, quantidade, id_registro);
					return new ModelAndView("RegistroVendas");
				}
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("CarrinhoAdicionar");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("CarrinhoAdicionar");
	}
	@RequestMapping(name="Carrinho", value="/Carrinho", method=RequestMethod.GET)
	public ModelAndView carrinho(ModelMap model) {
		List<Carrinho> listaCarrinho = new ArrayList<>();
		String erro = "";
		try {
			if(lDAO.verificarAcesso().equals("Vendedor") || lDAO.verificarAcesso().equals("Administrador")) {
				listaCarrinho = rDAO.listaProdutosCarrinho(id_registro);
				model.addAttribute("listaCarrinho", listaCarrinho);
				return new ModelAndView("Carrinho");
			}else {
				erro = "Acesso não autorizado";
				model.addAttribute("erro", erro);
				return new ModelAndView("RegistroVendas");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("Carrinho");
	}
}
