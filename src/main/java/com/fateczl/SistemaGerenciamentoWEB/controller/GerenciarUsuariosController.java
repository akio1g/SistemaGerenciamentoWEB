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

import com.fateczl.SistemaGerenciamentoWEB.model.Usuario;
import com.fateczl.SistemaGerenciamentoWEB.persistence.InterfaceDAO.GerenciarUsuariosDAO;

@Controller
public class GerenciarUsuariosController {
	
	@Autowired
	GerenciarUsuariosDAO guDAO;
	
	@RequestMapping(name="GerenciarUsuarios", value="/GerenciarUsuarios", method=RequestMethod.GET)
	public ModelAndView listarUsuario(ModelMap model) {
		String erro="";
		List<Usuario> listarUsuario = new ArrayList<Usuario>();
		try {
			listarUsuario = guDAO.listaUsuario();
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}finally {
			model.addAttribute("erro", erro);
			model.addAttribute("listarUsuario", listarUsuario);
		}
		return new ModelAndView();
	}
	@RequestMapping(name="GerenciarUsuarios", value="/GerenciarUsuarios", method=RequestMethod.POST)
	public ModelAndView listarUsuario(ModelMap model, @RequestParam Map<String, String> param) {
		String erro="";
		String botaoEditar = param.get("botaoEditar");
		String botaoInput = param.get("inputPesquisa");
		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			if(botaoInput.isEmpty()) {
				listaUsuario = guDAO.listaUsuario();
			}else {
				listaUsuario = guDAO.pesquisarUsuarioPorNome(botaoInput);
				if(listaUsuario.isEmpty()) {
					listaUsuario = guDAO.listaUsuario();
					model.addAttribute("listarUsuario", listaUsuario);
					return new ModelAndView("GerenciarUsuarios");
				}
			}
			if(botaoEditar != null && !botaoEditar.isEmpty()) {
				editarUsuario(model);
				model.addAttribute("listaUsuario", listaUsuario);
			}
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}finally{
			model.addAttribute("listarUsuario", listaUsuario);
		}
		return new ModelAndView();
	}
	
	@RequestMapping(name="GerenciarUsuariosAdicionar", value="/GerenciarUsuariosAdicionar", method=RequestMethod.GET)
	public ModelAndView adicionarUsuario(ModelMap model) {
		return new ModelAndView();
	}
	@RequestMapping(name="GerenciarUsuariosAdicionar", value="/GerenciarUsuariosAdicionar", method=RequestMethod.POST)
	public ModelAndView adicionarUsuario(ModelMap model, @RequestParam Map<String, String> param) {
		Usuario usuario = new Usuario();
		
		usuario.setNome(param.get("nome"));
		usuario.setLogin(param.get("login_usuario"));
		usuario.setSenha(param.get("senha_usuario"));
		usuario.setEmail(param.get("email"));
		switch (param.get("tipoDeUsuario")) {
			case "Administrador":
				usuario.setTipo_usuario("Administrador");
				break;
			case "Estoquista":
				usuario.setTipo_usuario("Estoquista");
				break;
			case "Vendedor":
				usuario.setTipo_usuario("Vendedor");
		}
		
		try {
			if(guDAO.verificarDuplicidade(usuario.getLogin(), usuario.getEmail())) {
				guDAO.adicionarUsuario(usuario);
			}else {
				System.out.println("Duplicado");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	
	@RequestMapping(name="GerenciarUsuariosEditar", value="/GerenciarUsuariosEditar", method=RequestMethod.GET)
	public ModelAndView editarUsuario(ModelMap model) {
		Usuario usuario = new Usuario();
		
		int id_usuario = 1; //lugar onde vai substituir o id passado por parametro da tela de listar usuario.
		try {
			usuario = guDAO.pesquisarUsuarioPorId(id_usuario);
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("usuario", usuario);
		}
		return new ModelAndView();
	}
	@RequestMapping(name="GerenciarUsuariosEditar", value="/GerenciarUsuariosEditar", method=RequestMethod.POST)
	public ModelAndView editarUsuario(ModelMap model, @RequestParam Map<String, String> param) {
		String botaoSalvar = param.get("botaoSalvar");
		String botaoExcluir = param.get("botaoExcluir");
		String erro = "";
		
		try {
			Usuario usuario = new Usuario();
			
			usuario.setId(Integer.parseInt(param.get("id")));
			usuario.setNome(param.get("nome"));
			usuario.setLogin(param.get("email"));
			
			switch (param.get("tipoDeUsuario")) {
			case "Administrador":
				usuario.setTipo_usuario("Administrador");
				break;
			case "Estoquista":
				usuario.setTipo_usuario("Estoquista");
				break;
			case "Vendedor":
				usuario.setTipo_usuario("Vendedor");
			}
			if(botaoSalvar != null && !botaoSalvar.isEmpty()) {
				guDAO.editarUsuarioPorId(usuario);
				return new ModelAndView("GerenciarUsuariosEditar");
			}
			if(botaoExcluir != null && !botaoSalvar.isEmpty()) {
				guDAO.excluirUsuarioPorId(usuario.getId());
			}
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		}finally {
			
		}
		
		return new ModelAndView();
	}
}
