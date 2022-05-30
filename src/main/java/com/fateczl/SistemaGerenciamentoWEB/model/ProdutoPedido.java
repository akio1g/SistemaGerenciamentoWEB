package com.fateczl.SistemaGerenciamentoWEB.model;

import com.fateczl.SistemaGerenciamentoWEB.model.pk.ProdutoPedidoPK;

public class ProdutoPedido {
	private ProdutoPedidoPK id = new ProdutoPedidoPK();
	private int quantidade;
	private double price;
	
	public ProdutoPedido() {}
	public ProdutoPedido(Pedido pedido, Produto produto, int quantidade, double price) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.price = price;
	}
	public ProdutoPedidoPK getId() {
		return id;
	}
	public void setId(ProdutoPedidoPK id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
