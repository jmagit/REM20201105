package com.example.demos;

import java.util.Scanner;

public class NumerosJuego implements Juego {
	private int numeroBuscado = 0;
    private int intentos = 0;
    private boolean encontrado = false;
    private String resultado;

    public NumerosJuego() {
		inicializar();
	}
    
	@Override
	public void inicializar() {
     numeroBuscado = (int) (Math.random() * 100);
     intentos = 0;
     encontrado = false;
     resultado = "Pendiente de empezar";
	}

	@Override
	public void jugada(String movimiento) {
		if(getFinalizado()) {
			resultado = "Error";
			return;
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

	@Override
	public Object getResultado() {
		return resultado;
	}

	@Override
	public boolean getFinalizado() {
		return intentos >= 10 || encontrado;
	}

}
