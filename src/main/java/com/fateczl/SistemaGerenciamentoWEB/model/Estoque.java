package com.fateczl.SistemaGerenciamentoWEB.model;

public class Estoque {
	private int id;
	private int quantidade;
	private String nome;
	
	public Estoque(int id, int quantidade, String nome) {
		this.id = id;
		this.quantidade = quantidade;
		this.nome = nome;
	}
	public Estoque() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", quantidade=" + quantidade + ", nome=" + nome + "]";
	}
	
	
	
}
