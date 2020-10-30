package com.example.demos;

public interface Juego {
	void inicializar();
	void jugada(String movimiento);
	boolean getFinalizado();
	Object getResultado();
}
