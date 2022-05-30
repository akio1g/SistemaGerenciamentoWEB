package com.fateczl.SistemaGerenciamentoWEB.model.enums;

public enum Cargo {
	ADMINISTRADOR(1), ESTOQUISTA(2), VENDEDOR(3);

	private int codigo;

	private Cargo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static Cargo valueOf(int codigo) {
		for (Cargo cargo : Cargo.values()) {
			if (cargo.getCodigo() == codigo) {
				return cargo;
			}
		}
		throw new IllegalArgumentException("Código de cargo inválido");
	}
}
