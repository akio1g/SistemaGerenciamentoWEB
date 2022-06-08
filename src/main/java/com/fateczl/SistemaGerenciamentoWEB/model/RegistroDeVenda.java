package com.fateczl.SistemaGerenciamentoWEB.model;

import java.sql.Date;

public class RegistroDeVenda {
	public int id;
	public String vendedor;
	public String cliente;
	public int carrinho;
	public Date data;
	public double valor;
	public RegistroDeVenda(int id, String vendedor, String cliente, int carrinho, Date data, double valor) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.carrinho = carrinho;
		this.data = data;
		this.valor = valor;
	}
	public RegistroDeVenda() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(int carrinho) {
		this.carrinho = carrinho;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "RegistroDeVenda [id=" + id + ", vendedor=" + vendedor + ", cliente=" + cliente + ", carrinho="
				+ carrinho + ", data=" + data + ", valor=" + valor + "]";
	}
	
}
