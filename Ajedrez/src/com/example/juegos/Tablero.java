package com.example.juegos;

/**
 * Representa al Tablero del juego como contenedor de piezas.
 * 
 * @author Javier
 * @version 1.0
 */
public class Tablero implements Cloneable {
	private Pieza[][] piezas;

	public Tablero() {
		piezas = new Pieza[8][8];
	}

	private boolean esValido(int indice) {
		return 1 <= indice && indice <= 8;
	}

	/**
	 * Obtiene la pieza del tablero indicada por la fila y la columna.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 * @return Pieza en el tablero, nulo en caso de que no haya pieza.
	 */
	private Pieza get(int fila, int columna) {
		if (!esValido(fila) || !esValido(columna))
			throw new IndexOutOfBoundsException("Posición fuera del tablero.");
		return piezas[fila - 1][columna - 1];
	}

	/**
	 * Obtiene la pieza del tablero indicada por la posición.
	 * 
	 * @param posicion Posición con la fila y la columna en el tablero.
	 * @return Pieza en el tablero, nulo en caso de que no haya pieza.
	 */
	private Pieza get(Posicion posicion) {
		return get(posicion.getFila(), posicion.getColumna());
	}

	/**
	 * Establece la pieza del tablero indicada por la fila y la columna.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 * @param pieza   Pieza a introducir en el tablero, sobre escribe en caso de que
	 *                haya otra pieza.
	 */
	private void set(int fila, int columna, Pieza pieza) {
		if (!esValido(fila) || !esValido(columna))
			throw new IndexOutOfBoundsException("Posición fuera del tablero.");
		piezas[fila - 1][columna - 1] = pieza;
	}

	/**
	 * Establece la pieza del tablero indicada por la posición.
	 * 
	 * @param posicion Posición con la fila y la columna en el tablero.
	 * @param pieza    Pieza a introducir en el tablero, sobre escribe en caso de
	 *                 que haya otra pieza.
	 */
	private void set(Posicion posicion, Pieza pieza) {
		set(posicion.getFila(), posicion.getColumna(), pieza);
	}

	/**
	 * Muestra si hay una pieza ocupando una posición del tablero indicada por la
	 * fila y la columna.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 * @return Es true si hay pieza en el tablero; en caso contrario, es false.
	 */
	public boolean hayPieza(int fila, int columna) {
		return get(fila, columna) != null;
	}

	/**
	 * Muestra si hay una pieza ocupando una posición del tablero indicada por la
	 * posición.
	 * 
	 * @param posicion Posición con la fila y la columna en el tablero.
	 * @return Es true si hay pieza en el tablero; en caso contrario, es false.
	 */
	public boolean hayPieza(Posicion posicion) {
		return hayPieza(posicion.getFila(), posicion.getColumna());
	}

	/**
	 * Obtiene la pieza del tablero indicada por la fila y la columna.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 * @return Pieza en el tablero, nulo en caso de que no haya pieza.
	 */
	public Pieza getPieza(int fila, int columna) {
		if (get(fila, columna) == null)
			throw new NullPointerException("No hay pieza en la posición");
		return get(fila, columna);
	}

	/**
	 * Obtiene la pieza del tablero indicada por la posición.
	 * 
	 * @param posicion Posición con la fila y la columna en el tablero.
	 * @return Pieza en el tablero, nulo en caso de que no haya pieza.
	 */
	public Pieza getPieza(Posicion posicion) {
		return get(posicion.getFila(), posicion.getColumna());
	}

	/**
	 * Establece la pieza del tablero indicada por la fila y la columna.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 * @param pieza   Pieza a introducir en el tablero, sobre escribe en caso de que
	 *                haya otra pieza. No puede ser nula.
	 */
	public void setPieza(int fila, int columna, Pieza pieza) {
		assert pieza != null : "La pieza no puede ser nula.";
		set(fila, columna, pieza);
	}

	/**
	 * Establece la pieza del tablero indicada por la posición.
	 * 
	 * @param posicion Posición con la fila y la columna en el tablero.
	 * @param pieza    Pieza a introducir en el tablero, sobre escribe en caso de
	 *                 que haya otra pieza. No puede ser nula.
	 */
	public void setPieza(Posicion posicion, Pieza pieza) {
		setPieza(posicion.getFila(), posicion.getColumna(), pieza);
	}

	/**
	 * Quita la pieza que ocupa la posición del tablero indicada por la fila y la
	 * columna.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 */
	public void quitaPieza(int fila, int columna) {
		set(fila, columna, null);
	}

	/**
	 * Quita la pieza que ocupa la posición del tablero indicada por la posición.
	 * 
	 * @param posicion Posición con la fila y la columna en el tablero.
	 */
	public void quitaPieza(Posicion posicion) {
		quitaPieza(posicion.getFila(), posicion.getColumna());
	}

	/**
	 * Mueve la pieza del tablero desde la posición inicial a la posición final
	 * indicada por el movimiento.
	 * 
	 * @param movimiento Movimiento a realizar.
	 * @throws JuegoException No hay pieza para mover.
	 */
	public void mover(Movimiento movimiento) throws JuegoException {
		if (!hayPieza(movimiento.getPosicionInicial()))
			throw new JuegoException("No hay pieza para mover.");
		if (hayPieza(movimiento.getPosicionFinal()))
			quitaPieza(movimiento.getPosicionFinal());
		setPieza(movimiento.getPosicionFinal(), get(movimiento.getPosicionInicial()));
		quitaPieza(movimiento.getPosicionInicial());
	}

	/**
	 * Indica si hay piezas en el tablero entre la posición inicial y la posición
	 * final indicada por el movimiento, sin incluir dichas posiciones.
	 * 
	 * @param movimiento Movimiento a realizar.
	 * @return Es true si hay piezas en la trayectoria; en caso contrario, es false.
	 * @throws JuegoException Si el movimiento no es horizontal, vertical o diagonal
	 */
	public boolean hayPiezaEntre(Movimiento movimiento) throws JuegoException {
		if (!movimiento.esDiagonal() && !movimiento.esHorizontal() && !movimiento.esVertical())
			throw new JuegoException(
					"El movimiento debe ser horizontal, vertical o diagonal para verificar si hay piezas entre la posición inicial y la posición final.");
		int dColum = movimiento.deltaColumna();
		int dFila = movimiento.deltaFila();
		Posicion posicion = new Posicion(movimiento.getPosicionInicial().getFila() + dFila,
				movimiento.getPosicionInicial().getColumna() + dColum);
		while (!posicion.equals(movimiento.getPosicionFinal())) {
			if (hayPieza(posicion))
				return true;
			posicion = new Posicion(posicion.getFila() + dFila, posicion.getColumna() + dColum);
		}
		return false;
	}

	/**
	 * Método de clase para informar al interfaz gráfico de qué color es el escaque.
	 * 
	 * @param fila    Valor entre 1 y 8 de la fila en el tablero.
	 * @param columna Valor entre 1 y 8 de la columna en el tablero.
	 * @return Color del escaque.
	 */
	public static Color colorEscaque(int fila, int columna) {
		return (fila + columna) % 2 == 0 ? Color.NEGRO : Color.BLANCO;
	}

	/**
	 * Realiza una copia del tablero.
	 * 
	 * @return Copia del tablero.
	 */
	@Override
	public Tablero clone() {
		try {
			return (Tablero) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
