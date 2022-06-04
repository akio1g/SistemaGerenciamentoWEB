package com.fateczl.SistemaGerenciamentoWEB.model;

public class Cliente {
	private int id;
	private String nomeRazaoSocial;
	private String cpfCnpj;
	private String telefone;
	private String email;
	private String inscricaoEstadual;

	public Cliente() {
	}

	public Cliente(int id, String nomeRazaoSocial, String cpfCnpj, String telefone, String email,
			String inscricaoEstadual) {
		super();
		this.id = id;
		this.nomeRazaoSocial = nomeRazaoSocial;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeRazaoSocial=" + nomeRazaoSocial + ", cpfCnpj=" + cpfCnpj + ", telefone="
				+ telefone + ", email=" + email + ", inscricaoEstadual=" + inscricaoEstadual
				+ "]";
	}

}
