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

import com.fateczl.SistemaGerenciamentoWEB.model.Cliente;
import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.ClienteDAO;

@Controller
public class ClienteController {

	@Autowired
	ClienteDAO cDAO;
	
	private static int id_cliente;

	@RequestMapping(name = "Cliente", value = "Cliente", method = RequestMethod.GET)
	public ModelAndView listarCliente(ModelMap model) {
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
	public ModelAndView listarClientes(ModelMap model, @RequestParam Map<String, String> param, @RequestParam MultiValueMap<String, String> paramValorado) {
		String erro = "";
		String botaoEditar = param.get("botaoEditar");
		String botaoInput= param.get("inputPesquisa");
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			if(botaoInput.isEmpty()) {
				listaClientes = cDAO.listaClientes();
			}else {
				listaClientes = cDAO.pesquisarClientesPorNome(botaoInput);
				if(listaClientes.isEmpty()) {
					listaClientes = cDAO.listaClientes();
					model.addAttribute("erro", erro);
					model.addAttribute("listaClientes", listaClientes);
					return new ModelAndView("Cliente");
				}else {
					model.addAttribute("erro", erro);
					model.addAttribute("listaClientes", listaClientes);
					return new ModelAndView("Cliente");
				}
			}
			if(botaoEditar != null && !botaoEditar.isEmpty()){
				id_cliente = Integer.parseInt(param.get("botaoEditar"));
				clienteEditar(model);
				model.addAttribute("erro", erro);
				model.addAttribute("listaClientes", listaClientes);
				return new ModelAndView("ClienteEditar");
			}
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
		return new ModelAndView();
	}
	@RequestMapping(name = "ClienteAdicionarCPF", value="ClienteAdicionarCPF", method =RequestMethod.GET)
	public ModelAndView clienteAdiconarCPF(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name = "ClienteAdicionarCPF", value="ClienteAdicionarCPF", method =RequestMethod.POST)
	public ModelAndView clienteAdiconarCPF(ModelMap model, @RequestParam Map<String, String> param) {
		
		Cliente cliente = new Cliente();
		Endereco end = new Endereco();
			
		cliente.setNomeRazaoSocial(param.get("Nome"));
		cliente.setCpfCnpj(param.get("CPF"));
		cliente.setTelefone(param.get("Telefone"));
		cliente.setEmail(param.get("Email"));
	
		end.setCep(param.get("CEP"));
		end.setLogradouro(param.get("Logradouro"));
		end.setNumero(Integer.parseInt(param.get("Numero")));
		end.setComplemento(param.get("Complemento"));
		end.setCidade(param.get("Cidade"));
		end.setEstado(param.get("Estado"));
	
		try {
			if (cDAO.verificarDuplicidade(cliente.getCpfCnpj())) {
				cDAO.adicionarCliente(cliente, end);
			} else {
				System.out.println("duplicado");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	@RequestMapping(name = "ClienteAdicionarCNPJ", value="ClienteAdicionarCNPJ", method =RequestMethod.GET)
	public ModelAndView clienteAdiconarCNPJ(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name = "ClienteAdicionarCNPJ", value="ClienteAdicionarCNPJ", method =RequestMethod.POST)
	public ModelAndView clienteAdicionarCNPJ(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoAdicionar = param.get("botaoAdicionar");
		String erro = "";
		if (!botaoAdicionar.equals(null) && !botaoAdicionar.isEmpty()) {
			Cliente cliente = new Cliente();
			Endereco end = new Endereco();
				
			cliente.setNomeRazaoSocial(param.get("Nome"));
			cliente.setCpfCnpj(param.get("CNPJ"));
			cliente.setTelefone(param.get("Telefone"));
			cliente.setEmail(param.get("Email"));
		
			end.setCep(param.get("CEP"));
			end.setLogradouro(param.get("Logradouro"));
			end.setNumero(Integer.parseInt(param.get("Numero")));
			end.setComplemento(param.get("Complemento"));
			end.setCidade(param.get("Cidade"));
			end.setEstado(param.get("Estado"));
			try {
				if (cDAO.verificarDuplicidade(cliente.getCpfCnpj())) {
					cDAO.adicionarCliente(cliente, end);
				} else {
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView();
	}
	@RequestMapping(name = "ClienteEditar", value = "ClienteEditar", method = RequestMethod.GET)
	public ModelAndView clienteEditar(ModelMap model) {
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		try {
			cliente = cDAO.buscarClientePorId(id_cliente);
			endereco = cDAO.buscarEnderecoPorId(id_cliente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("cliente", cliente);
			model.addAttribute("endereco", endereco);
		}
		
		return new ModelAndView();
	}
	@RequestMapping(name="ClienteEditar", value="ClienteEditar", method = RequestMethod.POST)
	public ModelAndView clienteEditar(ModelMap model, @RequestParam Map<String,String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String botaoExcluir = param.get("botaoExcluir");
		String erro = "";
		try {		
			Cliente cliente = new Cliente();
			Endereco endereco = new Endereco();
			
			cliente.setId(Integer.parseInt(param.get("Id")));
			cliente.setNomeRazaoSocial((param.get("Nome")));
			cliente.setCpfCnpj(param.get("CPF/CNPJ"));
			cliente.setTelefone(param.get("Telefone"));
			cliente.setEmail(param.get("Email"));
		
			endereco.setCep(param.get("CEP"));
			endereco.setLogradouro(param.get("Logradouro"));
			endereco.setNumero(Integer.parseInt(param.get("Numero")));
			endereco.setComplemento(param.get("Complemento"));
			endereco.setCidade(param.get("Cidade"));
			endereco.setEstado(param.get("Estado"));
			
			if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
				cDAO.editarClientePorId(cliente, endereco);
				return new ModelAndView("ClienteEditar");
			}
			if(botaoExcluir != null && !botaoExcluir.isEmpty()) {
				cDAO.excluirClientePorId(cliente.getId());
				return new ModelAndView("ClienteEditar");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}
		return new ModelAndView();
	}
}
