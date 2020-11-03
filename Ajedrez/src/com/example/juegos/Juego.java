package com.example.juegos;

/**
 * Interfaz com�n de los juegos
 * @author Javier
 * @version 1.0
 * @param <T> Tipo del dato con el resultado de la jugada
 */public interface Juego<T> {
    /**
     * Inicializa el juego
     */
	void inicializar();
	/**
	 * M�todo principal que desarrolla el juego. El juego debe estar iniciado.
	 * @param movimiento Cadena con la jugada a realizar.
	 * @throws JuegoException Posibles errores en la jugada
	 */
	void jugada(String movimiento) throws JuegoException;
	/**
	 * Informa si ha terminado el juego
	 * @return true si ha finalizado, false si puede seguir jugando
	 */
	boolean getFinalizado();
	/**
	 * Resultado de la �ltima jugada para implementar el GUI
	 * @return Resultado de la jugada
	 */
	T getResultado();
}
