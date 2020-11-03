package com.example.juegos;

/**
 * Representa un movimiento del Ajedrez, desde una posici�n inicial hasta una posici�n final.
 * @author Javier
 * @version 1.0
 */
public class Movimiento {
	private Posicion posicionInicial, posicionFinal;
	
	/**
	 * Crea una nueva instancia de movimiento es funci�n a una cadena dada. La cadena debe representar un movimiento en notaci�n internacional.
	 * @param jugada Cadena en formato "CFCF", donde C es la columna con valores: A-H; y F es la fila con valores: 1-8.
	 * @throws JuegoException Genera la excepci�n si la cadena no est� en formato internacional o la posici�n inicial es igual a la posici�n final.
	 */
	public Movimiento(String jugada) throws JuegoException {
		if(jugada == null || jugada.isBlank())
			throw new JuegoException("Parametro invalido");
		jugada = jugada.toUpperCase();
		if(!jugada.matches("^([A-H][1-8]){2}$")) 
			throw new JuegoException("El movimiento no es correcto seg�n la notaci�n internacional.");
		else if (jugada.substring(0, 2).equals(jugada.substring(2, 4)))
			throw new JuegoException("La posici�n inicial debe ser distinta de la posici�n final.");	
		posicionInicial = new Posicion(jugada.charAt(1), jugada.charAt(0));
		posicionFinal = new Posicion(jugada.charAt(3), jugada.charAt(2));
	}
	/**
	 * Crea una nueva instancia de movimiento es funci�n a la posici�n inicial y la posici�n final
	 * @param posicionInicial Posici�n de la pieza a mover
	 * @param posicionFinal Posici�n de destino
	 * @throws JuegoException La posici�n inicial debe ser distinta de la posici�n final.
	 */
	public Movimiento(Posicion posicionInicial, Posicion posicionFinal) throws JuegoException {
		assert posicionInicial != null && posicionFinal != null: "Parametro invalido";
		if (posicionInicial.equals(posicionFinal))
			throw new JuegoException("La posici�n inicial debe ser distinta de la posici�n final.");	
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
	}
	
	/**
	 * Posici�n de la pieza a mover
	 * @return Posici�n inicial
	 */
	public Posicion getPosicionInicial() {
		return posicionInicial;
	}
	
	/**
	 * Posici�n de destino
	 * @return Posici�n final
	 */
	public Posicion getPosicionFinal() {
		return posicionFinal;
	}

	/**
	 * Obtiene un valor que indica si el movimiento es vertical.
	 * @return Es true si el movimiento es vertical; en caso contrario, es false.
	 */
	public boolean esVertical() {
		return posicionInicial.getColumna() == posicionFinal.getColumna();
	}

	/**
	 * Obtiene un valor que indica si el movimiento es horizontal.
	 * @return Es true si el movimiento es horizontal; en caso contrario, es false.
	 */
	public boolean esHorizontal() {
		return posicionInicial.getFila() == posicionFinal.getFila();
	}

	/**
	 * Obtiene un valor que indica si el movimiento es diagonal.
	 * @return Es true si el movimiento es diagonal; en caso contrario, es false.
	 */
	public boolean esDiagonal() {
		return saltoHorizontal() == saltoVertical();
	}

	/**
	 * Obtiene un valor que indica cuantos escaques en vertical desde la posici�n inicial (fila) y la posici�n final (fila).
	 * @return Valor absoluto con el n�mero de escaques.
	 */
	public int saltoVertical() {		
		return Math.abs(posicionInicial.getFila() - posicionFinal.getFila());
	}

	/**
	 * Obtiene un valor que indica cuantos escaques en horizontal desde la posici�n inicial (columna) y la posici�n final (columna).
	 * @return Valor absoluto con el n�mero de escaques.
	 */
	public int saltoHorizontal() {
		return Math.abs(posicionInicial.getColumna() - posicionFinal.getColumna());
	}

	/**
	 * Obtiene el valor que indica cuanto hay que ir incrementando la fila para que recorra todos los escaques entre la posici�n inicial y la posici�n final.
	 * @return Valores posibles:
	 *		-1	Fila inicial menor que Fila final.
	 *		0	Fila inicial igual a la Fila final.
	 *		+1	Fila inicial mayor que Fila final.
	 */
	public int deltaFila() {
		if(posicionInicial.getFila() == posicionFinal.getFila())
			return 0;
		else if(posicionInicial.getFila() > posicionFinal.getFila())
			return -1;
		else
			return 1;
	}

	/**
	 * Obtiene el valor que indica cuanto hay que ir incrementando la columna para que recorra todos los escaques entre la posici�n inicial y la posici�n final.
	 * @return Valores posibles:
	 *		-1	Columna inicial menor que Columna final.
	 *		0	Columna inicial igual a la Columna final.
	 *		+1	Columna inicial mayor que Columna final.
	 *	
	 */
	public int deltaColumna() {
		return (int)Math.signum(posicionFinal.getColumna() - posicionInicial.getColumna());
	}

}
