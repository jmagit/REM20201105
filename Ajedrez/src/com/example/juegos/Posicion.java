package com.example.juegos;

import java.util.Objects;

/**
 * Clase que encapsula la fila y columna de una posición.
 * @author Javier
 * @version 1.0
 */
public class Posicion {
	private int fila, columna;
	
	/**
	 * Inicializa una nueva instancia de la clase Posicion con valores numéricos.
	 * @param fila Valor entre 1 y 8 con la fila de la posición.
	 * @param columna Valor entre 1 y 8 con la columna de la posición.
	 * @throws JuegoException Fila o Columna fuera de rango
	 */
	public Posicion(int fila, int columna) throws JuegoException {
		if(1 > fila || fila > 8)
			throw new JuegoException("Fila fuera de rango.");
		if(1 > columna || columna > 8)
			throw new JuegoException("Columna fuera de rango.");
		this.fila = fila;
		this.columna = columna;
	}
	
	/**
	 * Inicializa una nueva instancia de la clase Posicion con valores alfanuméricos.
	 * @param fila Dígito entre 1 y 8 con la fila de la posición.
	 * @param columna Letra entre A y H con la columna de la posición.
	 * @throws JuegoException Fila o Columna fuera de rango
	 */
	public Posicion(char fila, char columna) throws JuegoException {
		this((int)(fila - '0'), (int)(Character.toUpperCase(columna) - 'A') + 1);
	}

	/**
	 * Obtiene el valor de la fila.
	 * @return Valor entre 1 y 8 con la fila de la posición.
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Obtiene el valor de la columna.
	 * @return Valor entre 1 y 8 con la columna de la posición.
	 */
	public int getColumna() {
		return columna;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	@Override
	public String toString() {
		return "Posicion [fila=" + fila + ", columna=" + columna + "]";
	}

	
}
