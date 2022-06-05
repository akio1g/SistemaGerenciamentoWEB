package com.fateczl.SistemaGerenciamentoWEB.model;

public class Usuario {
	private int id;
	private String nome;
	private String login;
	private String email;
	private String senha;
	private int tipo_usuario;

	public Usuario() {
	}

	public Usuario(int id, String name, String email, String login, String senha, int tipo_usuario) {
		super();
		this.id = id;
		this.nome = name;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.tipo_usuario = tipo_usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", email=" + email + ", senha=" + senha
				+ ", tipo_usuario=" + tipo_usuario + "]";
	}

	
}