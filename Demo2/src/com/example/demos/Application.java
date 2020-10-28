package com.example.demos;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Application app = new Application();
		
		app.run();
	}

	public void run() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame tu nombre: ");
		String nombre = teclado.nextLine();		
		System.out.println("Hola " + nombre +".");
	}
}
