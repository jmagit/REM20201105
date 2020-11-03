package com.example;

import java.util.Scanner;

import com.example.juegos.Color;
import com.example.juegos.Tablero;

public class Aplicacion {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		pintaTablero(tablero);
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


}
