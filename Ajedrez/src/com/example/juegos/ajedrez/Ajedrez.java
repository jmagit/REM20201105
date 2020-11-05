package com.example.juegos.ajedrez;

import com.example.juegos.Color;
import com.example.juegos.Juego;
import com.example.juegos.JuegoException;
import com.example.juegos.Movimiento;
import com.example.juegos.Tablero;

/**
 * Clase principal del juego de Ajedrez con la implementaci�n de la l�gica general.
 * @author Javier
 * @version 1.0
 */
public class Ajedrez implements Juego<Tablero> {
	private Color turno;
	private Tablero tablero;
	private boolean partidaActiva;
	// Implementaci�n de eventos mediante los patrones delegate y command
	private PromocionEvent onPromocion;
	
	/**
	 * Constructor que requiere el delegado a invocar cuando se solicita al usuario la pieza de sustituci�n del pe�n cuando promociona.
	 * @param onPromocion Delegado a ejecutar para solicitar al usuario la pieza para la promoci�n del pe�n.
	 */
	public Ajedrez(PromocionEvent onPromocion) {
		assert onPromocion != null : "El m�todo de promoci�n es obligatorio";
		this.onPromocion = onPromocion;
		inicializar();
	}
	
	/**
	 * Obtiene el turno del jugador que le toca jugar.
	 * @return Color del jugador.
	 */
	public Color getTurno() {
		return turno;
	}

	/**
	 * Obtiene el tablero para que el contenedor pueda implementar el interfaz de usuario.
	 * @return Copia del tablero
	 */
	public Tablero getTablero() {
		return tablero.clone();
	}

	@Override
	public void inicializar() {
		turno = Color.BLANCO;
		tablero = new Tablero();

		tablero.setPieza(1, 1, new Torre(Color.BLANCO));
		tablero.setPieza(1, 2, new Caballo(Color.BLANCO));
		tablero.setPieza(1, 3, new Alfil(Color.BLANCO));
		tablero.setPieza(1, 4, new Dama(Color.BLANCO));
		tablero.setPieza(1, 5, new Rey(Color.BLANCO));
		tablero.setPieza(1, 6, new Alfil(Color.BLANCO));
		tablero.setPieza(1, 7, new Caballo(Color.BLANCO));
		tablero.setPieza(1, 8, new Torre(Color.BLANCO));

		tablero.setPieza(8, 1, new Torre(Color.NEGRO));
		tablero.setPieza(8, 2, new Caballo(Color.NEGRO));
		tablero.setPieza(8, 3, new Alfil(Color.NEGRO));
		tablero.setPieza(8, 4, new Dama(Color.NEGRO));
		tablero.setPieza(8, 5, new Rey(Color.NEGRO));
		tablero.setPieza(8, 6, new Alfil(Color.NEGRO));
		tablero.setPieza(8, 7, new Caballo(Color.NEGRO));
		tablero.setPieza(8, 8, new Torre(Color.NEGRO));

		for (byte i = 1; i <= 8; i++) {
			tablero.setPieza(2, i, new Peon(Color.BLANCO, onPromocion));
			tablero.setPieza(7, i, new Peon(Color.NEGRO, onPromocion));
		}

//		tablero.setPieza(7, 1, new Peon(Color.BLANCO, onPromocion));
//		tablero.setPieza(2, 1, new Peon(Color.NEGRO, onPromocion));

		partidaActiva = true;
	}

	private void cambiaTurno() {
		turno = turno == Color.BLANCO ? Color.NEGRO : Color.BLANCO;
	}

	private void mover(Movimiento movimiento) throws JuegoException {
		if (!tablero.hayPieza(movimiento.getPosicionInicial()))
			throw new JuegoException("No hay pieza en la posici�n inicial.");
		else if (tablero.getPieza(movimiento.getPosicionInicial()).getColor() != turno)
			throw new JuegoException("No puede mover piezas del otro jugador.");
		else if (tablero.hayPieza(movimiento.getPosicionFinal())
				&& tablero.getPieza(movimiento.getPosicionFinal()).getColor() == turno)
			throw new JuegoException("No puede capturar sus propias piezas.");
		else
			tablero.getPieza(movimiento.getPosicionInicial()).mover(movimiento, tablero);
	}


	/**
	 * M�todo principal que desarrolla el juego. El juego debe estar iniciado.
	 * NO CONTEMPLA EL JAQUE. As� mismo, no contempla las reglas de finalizaci�n como el jaque mate, el abandono o las tablas. Para terminar la partida es necesario teclear "FIN" o "TABLAS".
	 * @param movimiento Cadena en notaci�n internacional con el movimiento del jugador.
	 * @throws JuegoException Posibles errores en la jugada
	 */
	@Override
	public void jugada(String movimiento) throws JuegoException {
		if(!partidaActiva) 
			throw new JuegoException("El juego ha terminado.");
		if("FIN".equals(movimiento.toUpperCase()) || "TABLAS".equals(movimiento.toUpperCase())) {
			partidaActiva=false;
			return;
		}
		this.mover(new Movimiento(movimiento));
		this.cambiaTurno();
	}

	@Override
	public boolean getFinalizado() {
		return !partidaActiva;
	}

	@Override
	public Tablero getResultado() {
		return tablero.clone();
	}

}
