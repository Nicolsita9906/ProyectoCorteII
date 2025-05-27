package com.example.Proyecto.modelos;

public enum TipoDeDocumento {

	CC(1),  // Cédula de Ciudadanía
	TI(2),  // Tarjeta de Identidad
	CE(3),  // Cédula de Extranjería
	CD(4);  // Pasaporte

	private final int valor;

	TipoDeDocumento(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	// Opcional: Método para obtener TipoDeDocumento desde un int
	public static TipoDeDocumento fromInt(int valor) {
		for (TipoDeDocumento tipo : values()) {
			if (tipo.getValor() == valor) {
				return tipo;
			}
		}
		return null;
	}
}
