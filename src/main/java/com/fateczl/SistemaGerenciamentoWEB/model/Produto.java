package com.fateczl.SistemaGerenciamentoWEB.model;

import java.util.HashSet;
import java.util.Set;

public class Produto {
	private Long id;
	private String nome;
	private String descricao;
	private String ncmSh;
	private double preco;

	private Set<Categoria> categorias = new HashSet<>();

	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, String ncmSh, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ncmSh = ncmSh;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", ncmSh=" + ncmSh + ", preco="
				+ preco + ", categorias=" + categorias + "]";
	}

}
