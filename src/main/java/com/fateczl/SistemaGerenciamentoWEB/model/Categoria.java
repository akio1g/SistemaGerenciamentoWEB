package com.fateczl.SistemaGerenciamentoWEB.model;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
	private Long id;
	private String nome;
	private Set<Produto> produtos = new HashSet<>();

	public Categoria() {
	}

	public Categoria(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", produtos=" + produtos + "]";
	}
	
}
