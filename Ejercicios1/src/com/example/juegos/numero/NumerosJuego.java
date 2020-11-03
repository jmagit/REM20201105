package com.example.juegos.numero;

import java.util.Scanner;

import com.example.juegos.Juego;
import com.example.juegos.JuegoException;

/**
 * Juego de adivinar numeros
 * @author Javier
 * @version 1.0
 */
public class NumerosJuego implements Juego<String> {
	private int numeroBuscado = 0;
    private int intentos = 0;
    private boolean encontrado = false;
    private String resultado;

    public NumerosJuego() {
		inicializar();
	}
    
    /**
     * Inicializa el juego
     */
	@Override
	public void inicializar() {
     numeroBuscado = (int) (Math.random() * 100);
     intentos = 0;
     encontrado = false;
     resultado = "Pendiente de empezar";
	}

	@Override
	public void jugada(String movimiento) throws JuegoException {
		if(getFinalizado()) {
			throw new JuegoException("El juego a finalizado");
		}
        int numeroIntroducido = Integer.parseInt(movimiento);
        intentos += 1;
        if (numeroBuscado == numeroIntroducido) {
            encontrado = true;
            resultado = "Bieeen!!! Acertaste.";
        } else if (intentos >= 10) {
        	resultado = "Upsss! Se acabaron los intentos, el número era el " + numeroBuscado;
        } else if (numeroBuscado > numeroIntroducido) {
        	resultado = "Mi número es mayor.";
        } else {
        	resultado = "Mi número es menor.";
        }
	}

	/**
	 * Cadena con el mensaje de la ultima jugada
	 */
	@Override
	public String getResultado() {
		return resultado;
	}

	@Override
	public boolean getFinalizado() {
		return intentos >= 10 || encontrado;
	}

}
