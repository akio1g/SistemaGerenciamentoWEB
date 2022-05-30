package com.fateczl.SistemaGerenciamentoWEB.model;

public class Cliente {
	private Long id;
	private String nomeRazaoSocial;
	private String cpfCnpj;
	private String telefone;
	private Endereco endereco;
	private String email;
	private String inscricaoEstadual;

	public Cliente() {
	}

	public Cliente(Long id, String nomeRazaoSocial, String cpfCnpj, String telefone, Endereco endereco, String email,
			String inscricaoEstadual) {
		super();
		this.id = id;
		this.nomeRazaoSocial = nomeRazaoSocial;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
				+ telefone + ", endereco=" + endereco + ", email=" + email + ", inscricaoEstadual=" + inscricaoEstadual
				+ "]";
	}

}
