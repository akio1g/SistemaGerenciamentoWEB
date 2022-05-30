package com.fateczl.SistemaGerenciamentoWEB.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
	private Long id;
	private Instant data;
	private Set<ProdutoPedido> carrinho = new HashSet<>();
	private Cliente cliente;

	public Pedido() {
	}

	public Pedido(Long id, Instant data, Cliente cliente) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Set<ProdutoPedido> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Set<ProdutoPedido> carrinho) {
		this.carrinho = carrinho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", cliente=" + cliente + "]";
	}

}
