package com.example.juegos;

/**
 * Clase abstracta que representa las Piezas del Juego.
 * @author Javier
 * @version 1.0
 */
public abstract class Pieza {
	private Color color;
	
	/**
	 * Constructor �nico de la pieza. El color es obligatorio porque no puede cambiar una vez creada.
	 * @param color Color de la pieza.
	 */
	public Pieza(Color color) {
		this.color = color;
	}
	
	/**
	 * Obtiene el color de la pieza.
	 * @return Color de la pieza.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Abstracto. Indica si la pieza puede realizar el movimiento.
	 * @param movimiento Movimiento a verificar.
	 * @param tablero Tablero para verificar que no salta piezas.
	 * @return Es true si la pieza puede realizar el movimiento; en caso contrario, genera una excepci�n.
	 * @throws JuegoException Genera la excepci�n con la raz�n por la que no puede realizar el movimiento.
	 */
	public abstract boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException;
	
	/**
	 * Reemplazable. Mueve la pieza en el tablero.
	 * @param movimiento Movimiento a realizar.
	 * @param tablero Tablero para realizar el movimiento.
	 * @throws JuegoException Genera la excepci�n con la raz�n por la que no puede realizar el movimiento.
	 */
	public void mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
        if (esValido(movimiento, tablero))
            tablero.mover(movimiento);
    }

	@Override
	public String toString() {
		return getClass().getSimpleName() + (color == Color.BLANCO ? " (B)" : " (N)");
	}
	
	
}
