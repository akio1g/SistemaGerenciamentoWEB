package com.fateczl.SistemaGerenciamentoWEB.model;

import java.time.LocalDate;

public class RegistroDeVenda {
	public int id;
	public String vendedor;
	public String cliente;
	public LocalDate data;
	public double valor;
	public RegistroDeVenda() {
	}
	public RegistroDeVenda(int id, String vendedor, String cliente, LocalDate data, double valor) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.data = data;
		this.valor = valor;
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
		return "RegistroDeVenda [id=" + id + ", vendedor=" + vendedor + ", cliente=" + cliente + ", data=" + data
				+ ", valor=" + valor + "]";
	}
	
}
