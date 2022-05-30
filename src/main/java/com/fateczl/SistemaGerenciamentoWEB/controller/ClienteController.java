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

import com.fateczl.SistemaGerenciamentoWEB.model.Cliente;
import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.ClienteDAO;

@Controller
public class ClienteController {

	@Autowired
	ClienteDAO cDAO;

	@RequestMapping(name = "Cliente", value = "Cliente", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		String erro = "";
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			listaClientes = cDAO.listaClientes();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listaClientes", listaClientes);
		}
		return new ModelAndView();
	}

	@RequestMapping(name = "Cliente", value = "Cliente", method = RequestMethod.POST)
	public ModelAndView ListarClientes(ModelMap model) {
		String erro = "";
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			listaClientes = cDAO.listaClientes();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listaClientes", listaClientes);
		}

		return new ModelAndView("Cliente");
	}

	@RequestMapping(name = "ClienteAdicionar", value = "ClienteAdicionar", method = RequestMethod.GET)
	public ModelAndView clienteAdicionar(ModelMap model) {
		return new ModelAndView();
	}

	@RequestMapping(name = "ClienteAdicionar", value = "ClienteAdicionar", method = RequestMethod.POST)
	public ModelAndView clienteAdicionarInput(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoAdicionar = param.get("botaoAdicionar");
		String erro = "";
		try {
			if (!botaoAdicionar.isEmpty()) {
				Cliente cliente = new Cliente();
				Endereco end = new Endereco();
				
				end.setCep(param.get("CEP"));
				end.setCidade(param.get("Cidade"));
				end.setComplemento(param.get("Complemento"));
				end.setEstado(param.get("Estado"));
				end.setLogradouro(param.get("Logradouro"));
				end.setNumero(param.get("Numero"));
			
				cliente.setNomeRazaoSocial(param.get("Nome"));
				cliente.setCpfCnpj(param.get("CPF"));
				cliente.setTelefone(param.get("Telefone"));
				cliente.setEmail(param.get("Email"));
				cliente.setEndereco(end);
				cliente.setInscricaoEstadual(param.get("InscricaoEstadual"));

				if (cDAO.verificarDuplicidade(cliente.getCpfCnpj())) {
					cDAO.adicionarCliente(cliente, end);
				} else {
					System.out.println("duplicado");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
		}
		return new ModelAndView();
	}

	@RequestMapping(name = "ClienteEditar", value = "ClienteEditar", method = RequestMethod.GET)
	public ModelAndView clienteEditar(ModelMap model, @RequestParam Map<String, String> param) {

		return new ModelAndView();
	}

	@RequestMapping(name = "ClienteVisualizar", value = "ClienteVisualizar", method = RequestMethod.GET)
	public ModelAndView clienteVisualizar(ModelMap model) {
		return new ModelAndView();
	}
}
