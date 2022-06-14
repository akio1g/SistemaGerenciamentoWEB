package com.fateczl.SistemaGerenciamentoWEB.model;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private String ncmSh;
	private double preco;
	private String categoria;
	private String fornecedor;

	public Produto() {
	}

	public Produto(int id, String nome, String descricao, String ncmSh, double preco, String categoria,
			String fornecedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ncmSh = ncmSh;
		this.preco = preco;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNcmSh() {
		return ncmSh;
	}

	public void setNcmSh(String ncmSh) {
		this.ncmSh = ncmSh;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", ncmSh=" + ncmSh + ", preco="
				+ preco + ", categoria=" + categoria + ", fornecedor=" + fornecedor + "]";
	}
}
