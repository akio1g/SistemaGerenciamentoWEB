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
}
