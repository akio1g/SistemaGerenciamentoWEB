package com.fateczl.SistemaGerenciamentoWEB.model;

public class Estoque {
	private int quantidade;
	private String nome;
	
	
	public Estoque(int quantidade, String nome) {
		this.quantidade = quantidade;
		this.nome = nome;
	}
	public Estoque(){
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
		return "Estoque [quantidade=" + quantidade + ", nome=" + nome + "]";
	}
}
