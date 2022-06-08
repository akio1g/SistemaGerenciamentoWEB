package com.fateczl.SistemaGerenciamentoWEB.model;

public class Carrinho {
	public int id;
	public String produto;
	public int quantidade;
	public double valor;
	public Carrinho(int id, String produto, int quantidade, double valor) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public Carrinho() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
