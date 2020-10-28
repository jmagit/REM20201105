package com.example.demos;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Application app = new Application();
		
		app.run();
	}

	public void run() {
		ejer1Paso3();
		ejer1Paso4();
		ejer1Paso5();
		ejer1Paso6();
	}
	
	public void ejer1Paso3() {
		System.out.println("Cadenas");
		String A = "string", B = "string", C;
		C = A;
		System.out.println("A == B :" + ( A == B ? "Iguales" : "Distintas"));
		System.out.println("A.equals(B) :" + (A.equals(B) ? "Iguales" : "Distintas"));
		System.out.println("A == C :" + (A == C ? "Iguales" : "Distintas"));
		System.out.println("A.equals(C) :" + (A.equals(C) ? "Iguales" : "Distintas"));
		System.out.println("B == C :" + (B == C ? "Iguales" : "Distintas"));
		System.out.println("B.equals(C) :" + (B.equals(C) ? "Iguales" : "Distintas"));
	}
	public void ejer1Paso4() {
		System.out.println("Referencias");
		Point A = new Point(3, 5), B = new Point(3, 5), C;
		C = A;
		System.out.println("A == B :" + ( A == B ? "Iguales" : "Distintas"));
		System.out.println("A.equals(B) :" + (A.equals(B) ? "Iguales" : "Distintas"));
		System.out.println("A == C :" + (A == C ? "Iguales" : "Distintas"));
		System.out.println("A.equals(C) :" + (A.equals(C) ? "Iguales" : "Distintas"));
		System.out.println("B == C :" + (B == C ? "Iguales" : "Distintas"));
		System.out.println("B.equals(C) :" + (B.equals(C) ? "Iguales" : "Distintas"));
	}
	public void ejer1Paso5() {
		Line L = new Line(new Point(3,5), new Point(3,5));
		Point P = L.getPoint1();
		int Ant = L.deltaX();
		P.setX(10);
		int Pos = L.deltaX();
		System.out.println("¿Es Ant igual Posterior? " + (Ant == Pos ? "SI" : "NO"));
	}
	
	void add(Point p) { 
		p.setX(p.getX()+1); 
		}
	
	public void ejer1Paso6() {
		Line L = new Line(new Point(3,5), new Point(3,5));
		Point P = L.getPoint1();
		int Ant = L.deltaX();
		Point old = P;
		add(P);
		int Pos = L.deltaX();
		System.out.println("¿Misma referencia? " + (P == old ? "SI" : "NO"));
		System.out.println("¿Es Ant igual Posterior? " + (Ant == Pos ? "SI" : "NO"));
	}
	
	public void juego() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame número: ");
		String numero = teclado.nextLine();		
	}


}
