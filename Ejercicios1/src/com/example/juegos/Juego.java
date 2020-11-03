package com.example.juegos;

public interface Juego<T> {
	void inicializar();
	@Deprecated
	/**
	 * Intento de adivinar el numero
	 * @param movimiento Cadena con un valor numerico
	 * @throws JuegoException Intentar jugar cuando ya ha terminado
	 */
	void jugada(String movimiento) throws JuegoException;
	/**
	 * Informa si ha terminado el juego
	 * @return true si ha finalizado, false si puede seguir jugando
	 */
	boolean getFinalizado();
	T getResultado();
}
