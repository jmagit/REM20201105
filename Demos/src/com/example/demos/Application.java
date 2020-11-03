package com.example.demos;

public class Application {
	int atributo = 4;
	public Application() {
		this(4);
	}
	public Application(int atributo) {
		this.atributo = atributo;
	}
	
	
	public static void main(String[] args) {
//		String cad = "X";
//		cad = cad + "y";
//		for(int i=0; i < 100; i++) {
//			cad += ' ';
//		}
//		StringBuilder sb = new StringBuilder("Xy");
//		for(int i=0; i < 100; i++) {
//			sb.append(' ');
//		}
//		cad = sb.toString();
		
		Object o = 5;
		if(o instanceof Integer) {
			Integer i = (int)o;
			int rslt = i + 5;
			System.out.println("vale " + i);
		}
		Application app = new Application(4);
		Demo demo = Demo.dameActual();
		SubApp subApp = new SubApp(4);
		Object object = app;
		int a = 1, b = 2, c;
		String cad = "";
		String[] tabla = new String[10];
		demo.Pintate(Grafico.BLANCO_Y_NEGRO);
//		a += 1;
//		a = a + 1;

		b = a++;
		c = ++a;
		// t[++a]
		c = (a > b ? a : b) + 10;
		cad = "unidad" + (c > 1 ? "es" : "");
		System.out.println(c + " unidad" + (c > 1 ? "es" : ""));
//		if(app != null && app.equals(null)) {}
//		if(app.hazAlgo() == 1 & app.hazOtro() == 7) {}

		if (app instanceof Object) {
			if (object instanceof Application) {
				((Application) object).hazAlgo();
			} else {
				((Application) object).hazOtro();
			}
		}
		switch (a) {
		case 1:
		case 2:
			b = a;
			break;
		case 3:
			c = a;
			break;
		default:
			a = 0;
			break;
		}

//		for (int indice = 0, j = 10; indice < tabla.length; indice++, j--)
//			System.out.println(tabla[indice]);
//		for (String item : tabla) {
//			System.out.println(item);
//		}
//
//		exterior: while (true)
//			while (true) {
//				// ...
//				if (condC)
//					continue;
//
//				if (cond)
//					break exterior;
//				// ...
//				if (cond2)
//					break;
//
//			}
	}

	int hazAlgo() {
		return 0;
	}

	int hazOtro() {
		return 0;
	}
}
