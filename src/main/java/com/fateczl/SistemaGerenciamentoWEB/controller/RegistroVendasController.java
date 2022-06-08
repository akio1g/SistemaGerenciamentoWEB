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

import com.fateczl.SistemaGerenciamentoWEB.model.RegistroDeVenda;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.RegistroVendasDAO;

@Controller
public class RegistroVendasController {
	
	@Autowired
	RegistroVendasDAO rDAO;
	
	private int quantidade_itens;
	private String vendedor;
	private String cliente;
	@RequestMapping(name="RegistroVendas", value="/RegistroVendas", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		List<RegistroDeVenda> listaVenda = new ArrayList<>();
		try {
			listaVenda = rDAO.listaVendas();
			model.addAttribute("listaVenda", listaVenda);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("RegistroVendas");
	}
	@RequestMapping(name="RegistroVendas", value="/RegistroVendas", method=RequestMethod.POST)
	public ModelAndView listarVendas(ModelMap model, @RequestParam Map<String,String> param) {
		
		String erro = "";
		String botaoInput = param.get("inputPesquisa");
		
		List<RegistroDeVenda> listaVenda = new ArrayList<>();
		
		try {
			if(botaoInput.isEmpty()) {
				listaVenda = rDAO.listaVendas();
			}else {
				listaVenda = rDAO.listaVendaPorVendedor(botaoInput);
				if(listaVenda.isEmpty()) {
					listaVenda = rDAO.listaVendas();
					model.addAttribute("erro", erro);
					model.addAttribute("listaVenda", listaVenda);
					return new ModelAndView("RegistroVendas");
				}else {
					model.addAttribute("erro", erro);
					model.addAttribute("listaVenda", listaVenda);
					return new ModelAndView("RegistroVendas");
				}
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
		return new ModelAndView("RegistroVendasAdicionar");
		
	}
	@RequestMapping(name="RegistroVendasAdicionar", value="/RegistroVendasAdicionar", method=RequestMethod.POST)
	public ModelAndView adicionarVendas(ModelMap model, @RequestParam Map<String,String> param) {
		quantidade_itens = Integer.parseInt(param.get("botaoQuantidadeItens"));
		vendedor = param.get("vendedor");
		cliente = param.get("cliente");
		
		return new ModelAndView("RegistroVendasAdicionar");
	}
	@RequestMapping(name="RegistrarVendaAdicionarItens", value="/RegistrarVendaAdicionarItens", method=RequestMethod.GET)
	public ModelAndView adicionarItensVendas(ModelMap model) {
		RegistroDeVenda rg = new RegistroDeVenda();
		try {
			rg.setCliente(rDAO.buscarCliente(cliente));
			rg.setVendedor(rDAO.buscarVendedor(vendedor));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("rg", rg);
		
		return new ModelAndView("RegistrarVendaAdicionarItens");
	}
	@RequestMapping(name="RegistrarVendaAdicionarItens", value="/RegistrarVendaAdicionarItens", method=RequestMethod.POST)
	public ModelAndView adicionarItensVendas(ModelMap model, @RequestParam Map<String,String> param) {
		List<String> listaNomeitens = new ArrayList<>();
		List<String> listaQuantidade = new ArrayList<>();
		
		return new ModelAndView("RegistrarVendaAdicionarItens");	
	}
}
