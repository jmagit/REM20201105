package com.example;

import java.util.Scanner;

import com.example.juegos.Color;
import com.example.juegos.Juego;
import com.example.juegos.JuegoException;
import com.example.juegos.Pieza;
import com.example.juegos.Tablero;
import com.example.juegos.ajedrez.Ajedrez;
import com.example.juegos.ajedrez.Alfil;
import com.example.juegos.ajedrez.Caballo;
import com.example.juegos.ajedrez.Dama;
import com.example.juegos.ajedrez.PromocionEventArgs;
import com.example.juegos.ajedrez.Rey;
import com.example.juegos.ajedrez.Torre;

public class Aplicacion {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Juego<Tablero> juego = new Ajedrez(e -> pidePieza(e));
		Tablero tablero = juego.getResultado();
		tablero.setPieza(4, 4, new Dama(Color.BLANCO));
		pintaTablero(juego.getResultado());
		juego.inicializar();
		do {
			try {
				pintaTablero(juego.getResultado());
				System.out.print("Juegan las " + (((Ajedrez) juego).getTurno() == Color.BLANCO ? "blancas" : "negras")
						+ ". Dame jugada [CFCF]: ");
				juego.jugada(teclado.nextLine().toUpperCase());
			} catch (JuegoException e) {
				System.out.println(e.getMessage());
			}
		} while (!juego.getFinalizado());
//		busquedas(juego.getResultado());
		System.out.println("Juego Finalizado");
	}

	private static void pintaTablero(Tablero t) {
		for (int f = 8; f > 0; f--) {
			System.out.print(String.format("%2s ", f));
			for (int c = 1; c <= 8; c++) {
				if (t.hayPieza(f, c))
					System.out.print(String.format("%10s ", t.getPieza(f, c)));
				else
					System.out.print(Tablero.colorEscaque(f, c) == Color.BLANCO ? "            " : "-----------");
			}
			System.out.println();
		}
		for (char c = 'A'; c <= 'H'; c++) {
			System.out.print(String.format("%8c    ", c));
		}
		System.out.println();
	}
	
	private static Pieza pidePieza(PromocionEventArgs e) {
		System.out.print("\t1: Dama\n\t2: Alfil\n\t3: Torre\n\t4: Caballo\n\t5: Cancelar\n"
				+ "Dame la opción para promocionar el peón " + (e.getColor() == Color.BLANCO ? "blanco: " : "negro:"));
		switch (Integer.parseInt(teclado.nextLine())) {
		case 1:
			return new Dama(e.getColor());
		case 2:
			return new Alfil(e.getColor());
		case 3:
			return new Torre(e.getColor());
		case 4:
			return new Caballo(e.getColor());
		case 5:
			e.setCancel(true);
		default:
			return null;
		}
	}


	private static void busquedas(Tablero t) {
		System.out.println("Piezas Negras");
		t.buscar(e -> e.hayPieza() && e.getPieza().getColor() == Color.NEGRO).stream()
				.forEach(e -> System.out.println(e));
		System.out.println("Rey Blanco");
		t.buscar(e -> e.hayPieza() && e.getPieza() instanceof Rey && e.getPieza().getColor() == Color.BLANCO).stream()
				.forEach(e -> System.out.println(e));
		System.out.println("Enroque");
		t.buscar(e -> e.getFila() == 1 && 1 < e.getColumna() && e.getColumna() < 5 && e.hayPieza()).stream()
				.forEach(e -> System.out.println(e));
	}

}
