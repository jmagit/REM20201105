package com.example.demos;

public class SubApp extends Application {

	public SubApp(int atributo) {
		this(atributo, 0);
	}
	public SubApp(int atributo1, int atributo2) {
		super(atributo1);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
