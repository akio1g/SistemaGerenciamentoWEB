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

import com.fateczl.SistemaGerenciamentoWEB.model.Endereco;
import com.fateczl.SistemaGerenciamentoWEB.model.Fornecedor;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.FornecedoresDAO;

@Controller
public class FornecedoresController {

	@Autowired
	FornecedoresDAO fDAO;
	
	private static int id_fornecedor;
	
	@RequestMapping(name="Fornecedores", value="/Fornecedores", method=RequestMethod.GET)
	public ModelAndView fornecedores(ModelMap model) {
		String erro = "";
		
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		try {
			listaFornecedores = fDAO.listaFornecedor();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listaFornecedores", listaFornecedores);
		}
		return new ModelAndView();
	}
	@RequestMapping(name="Fornecedores", value="/Fornecedores", method=RequestMethod.POST)
	public ModelAndView fornecedores(ModelMap model, @RequestParam Map<String,String> param) {
		String erro="";
		String botaoEditar = param.get("botaoEditar");
		String botaoInput = param.get("inputPesquisa");
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		
		try {
			if(botaoInput.isEmpty()) {
				listaFornecedores = fDAO.listaFornecedor();
			}else{
				listaFornecedores = fDAO.pesquisarFornecedoresPorNome(botaoInput);
				if(listaFornecedores.isEmpty()) {
					listaFornecedores = fDAO.listaFornecedor();
					model.addAttribute("erro", erro);
					model.addAttribute("listaFornecedores", listaFornecedores);
					
				}else {	
					model.addAttribute("erro", erro);
					model.addAttribute("listaFornecedores", listaFornecedores);
					return new ModelAndView("Fornecedores");
				}
			}
			if(botaoEditar != null && !botaoEditar.isEmpty()) {
				id_fornecedor = Integer.parseInt(botaoEditar);
				fornecedorEditar(model);
				model.addAttribute("listaFornecedores", listaFornecedores);
				return new ModelAndView("FornecedorEditar");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listaFornecedores", listaFornecedores);
		}
		return new ModelAndView("Fornecedores");
	}
	@RequestMapping(name="FornecedorAdicionar", value="/FornecedorAdicionar", method=RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="FornecedorAdicionar", value="/FornecedorAdicionar", method=RequestMethod.POST)
	public ModelAndView adicionarFornecedor(ModelMap model, @RequestParam Map<String,String> param) {
		String botaoAdicionar = param.get("botaoAdicionar");
		String erro = "";
		try {
			if (!botaoAdicionar.isEmpty()) {
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setRazaoSocial(param.get("razaoSocial"));
				fornecedor.setCnpj(param.get("cnpj"));
				fornecedor.setTelefone(param.get("telefone"));
				fornecedor.setInscricaoEstadual(param.get("inscricaoEstadual"));
				
				Endereco end = new Endereco();
				end.setCep(param.get("CEP"));
				end.setCidade(param.get("Cidade"));
				end.setComplemento(param.get("Complemento"));
				end.setEstado(param.get("Estado"));
				end.setLogradouro(param.get("Logradouro"));
				end.setNumero(Integer.parseInt(param.get("Numero")));
		
				if (fDAO.verificarDuplicidade(fornecedor.getCnpj())) {
					fDAO.adicionarFornecedor(fornecedor, end);
				} else {
					System.out.println("duplicado");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("erro", erro);
		}
		return new ModelAndView();
	}
	@RequestMapping(name="FornecedorEditar", value="/FornecedorEditar", method = RequestMethod.GET)
	public ModelAndView fornecedorEditar(ModelMap model) {
		Fornecedor fornecedor = new Fornecedor();
		Endereco endereco = new Endereco();
		
		try {
			fornecedor = fDAO.buscarFornecedorPorId(id_fornecedor);
			endereco = fDAO.buscarEnderecoFornecedorPorId(id_fornecedor);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("fornecedor", fornecedor);
			model.addAttribute("endereco", endereco);
		}
		return new ModelAndView("FornecedorEditar");
	}
	@RequestMapping(name="FornecedorEditar", value="/FornecedorEditar", method = RequestMethod.POST)
	public ModelAndView fornecedorEditar(ModelMap model, @RequestParam Map<String,String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String botaoExcluir = param.get("botaoExcluir");
		String erro = "";
		
		try {
			Fornecedor fornecedor = new Fornecedor();
			Endereco endereco = new Endereco();
			
			fornecedor.setId(Integer.parseInt(param.get("Id")));
			fornecedor.setRazaoSocial(param.get("RazaoSocial"));
			fornecedor.setCnpj(param.get("Cnpj"));
			fornecedor.setInscricaoEstadual(param.get("InscricaoEstadual"));
			fornecedor.setTelefone(param.get("Telefone"));
			
			endereco.setCep(param.get("CEP"));
			endereco.setLogradouro(param.get("Logradouro"));
			endereco.setNumero(Integer.parseInt(param.get("Numero")));
			endereco.setComplemento(param.get("Complemento"));
			endereco.setCidade(param.get("Cidade"));
			endereco.setEstado(param.get("Estado"));
		
			if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
				fDAO.editarFornecedor(fornecedor, endereco);
				return new ModelAndView("Fornecedores");
			}
			if(botaoExcluir != null && !botaoExcluir.isEmpty()) {
				fDAO.excluirFornecedorPorId(fornecedor.getId());
				return new ModelAndView("FornecedorEditar");
			}
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}
		return new ModelAndView("Fornecedor");
	}
}
