package com.example.juegos;

public interface Juego<T> {
	void inicializar();
	void jugada(String movimiento) throws JuegoException;
	boolean getFinalizado();
	T getResultado();
}
