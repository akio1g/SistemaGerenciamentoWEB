package com.fateczl.SistemaGerenciamentoWEB.model;

import java.util.Objects;

import com.fateczl.SistemaGerenciamentoWEB.model.enums.Cargo;

public class Usuario {
	private Long id;
	private String name;
	private String login;
	private String senha;
	private int cargo;

	public Usuario() {
	}

	public Usuario(Long id, String name, String login, String senha, Cargo cargo) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", login=" + login + ", senha=" + senha + ", cargo=" + cargo
				+ "]";
	}

}
