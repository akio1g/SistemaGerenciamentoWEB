package com.fateczl.SistemaGerenciamentoWEB.model;

import java.util.Objects;

import com.fateczl.SistemaGerenciamentoWEB.model.enums.Cargo;

public class Usuario {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private int cargo;

	public Usuario() {
	}

	public Usuario(Long id, String name, String login, String senha, Cargo cargo) {
		super();
		this.id = id;
		this.nome = name;
		this.email = login;
		this.senha = senha;
		setCargo(cargo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getLogin() {
		return email;
	}

	public void setLogin(String login) {
		this.email = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		if (cargo != null) {
			this.cargo = cargo.getCodigo();
		}
	}

	public int hashCode() {
		return Objects.hash(id);
	}
	public boolean equals(Object obj) {
		if(this == obj) {return true;}
		if(obj == null) {return false;}
		if(getClass() != obj.getClass()) {return false;}
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}



}
