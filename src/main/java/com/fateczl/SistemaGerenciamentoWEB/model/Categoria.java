package com.fateczl.SistemaGerenciamentoWEB.model;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
	private int id;
	private String nome;

	public Categoria() {
	}

	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	
}
