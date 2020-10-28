package com.example.demos;

public class Demo implements Grafico {
	private static Demo actual = null;
	
	static {
		actual = null;
	}
	private Demo() {
		// TODO Auto-generated constructor stub
	}
	
	public static Demo dameActual( ) {
		if(actual == null) {
			actual = new Demo();
		}
		return actual;
	}

	@Override
	public void Pintate(String tipo) {
		// TODO Auto-generated method stub
	}
}
