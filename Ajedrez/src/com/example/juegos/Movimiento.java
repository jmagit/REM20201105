package com.example.juegos;

/**
 * Representa un movimiento del Ajedrez, desde una posición inicial hasta una posición final.
 * @author Javier
 * @version 1.0
 */
public class Movimiento {
	private Posicion posicionInicial, posicionFinal;
	
	/**
	 * Crea una nueva instancia de movimiento es función a una cadena dada. La cadena debe representar un movimiento en notación internacional.
	 * @param jugada Cadena en formato "CFCF", donde C es la columna con valores: A-H; y F es la fila con valores: 1-8.
	 * @throws JuegoException Genera la excepción si la cadena no está en formato internacional o la posición inicial es igual a la posición final.
	 */
	public Movimiento(String jugada) throws JuegoException {
		if(jugada == null || jugada.isBlank())
			throw new JuegoException("Parametro invalido");
		jugada = jugada.toUpperCase();
		if(!jugada.matches("^([A-H][1-8]){2}$")) 
			throw new JuegoException("El movimiento no es correcto según la notación internacional.");
		else if (jugada.substring(0, 2).equals(jugada.substring(2, 4)))
			throw new JuegoException("La posición inicial debe ser distinta de la posición final.");	
		posicionInicial = new Posicion(jugada.charAt(1), jugada.charAt(0));
		posicionFinal = new Posicion(jugada.charAt(3), jugada.charAt(2));
	}
	/**
	 * Crea una nueva instancia de movimiento es función a la posición inicial y la posición final
	 * @param posicionInicial Posición de la pieza a mover
	 * @param posicionFinal Posición de destino
	 * @throws JuegoException La posición inicial debe ser distinta de la posición final.
	 */
	public Movimiento(Posicion posicionInicial, Posicion posicionFinal) throws JuegoException {
		assert posicionInicial != null && posicionFinal != null: "Parametro invalido";
		if (posicionInicial.equals(posicionFinal))
			throw new JuegoException("La posición inicial debe ser distinta de la posición final.");	
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
	}
	
	/**
	 * Posición de la pieza a mover
	 * @return Posición inicial
	 */
	public Posicion getPosicionInicial() {
		return posicionInicial;
	}
	
	/**
	 * Posición de destino
	 * @return Posición final
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
	 * Obtiene un valor que indica cuantos escaques en vertical desde la posición inicial (fila) y la posición final (fila).
	 * @return Valor absoluto con el número de escaques.
	 */
	public int saltoVertical() {		
		return Math.abs(posicionInicial.getFila() - posicionFinal.getFila());
	}

	/**
	 * Obtiene un valor que indica cuantos escaques en horizontal desde la posición inicial (columna) y la posición final (columna).
	 * @return Valor absoluto con el número de escaques.
	 */
	public int saltoHorizontal() {
		return Math.abs(posicionInicial.getColumna() - posicionFinal.getColumna());
	}

	/**
	 * Obtiene el valor que indica cuanto hay que ir incrementando la fila para que recorra todos los escaques entre la posición inicial y la posición final.
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
	 * Obtiene el valor que indica cuanto hay que ir incrementando la columna para que recorra todos los escaques entre la posición inicial y la posición final.
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
