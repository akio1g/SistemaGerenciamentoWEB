package com.fateczl.SistemaGerenciamentoWEB.model.pk;

import java.util.Objects;

import com.fateczl.SistemaGerenciamentoWEB.model.Pedido;
import com.fateczl.SistemaGerenciamentoWEB.model.Produto;

public class ProdutoPedidoPK{
	private Pedido pedido;
	private Produto produto;
	
	public ProdutoPedidoPK() {}
	public ProdutoPedidoPK(Pedido pedido, Produto produto) {
		this.pedido = pedido;
		this.produto = produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {return true;}
		if(o == null || getClass() != o.getClass()) {return false;}
		ProdutoPedidoPK that = (ProdutoPedidoPK) o;
		return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
	}
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}
	@Override
	public String toString() {
		return "ProdutoPedidoPK [pedido=" + pedido + ", produto=" + produto + "]";
	}
	
}
