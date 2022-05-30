package com.fateczl.SistemaGerenciamentoWEB.model;

public class Fornecedor {
	private long id; 
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String telefone;
	private Endereco endereco;
	
	public Fornecedor(){}
	public Fornecedor(long id, String razaoSocial, String cnpj, String incricaoEstadual,
			String telefone, Endereco endereco) {
		super();
		this.id=id;
		this.cnpj=cnpj;
		this.endereco=endereco;
		this.inscricaoEstadual=incricaoEstadual;
		this.razaoSocial=razaoSocial;
		this.telefone=telefone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
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
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", inscricaoEstadual="
				+ inscricaoEstadual + ", telefone=" + telefone + ", endereco=" + endereco + "]";
	} 
	
}
