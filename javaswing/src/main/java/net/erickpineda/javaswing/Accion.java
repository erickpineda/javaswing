package net.erickpineda.javaswing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Accion {

	private String nombreFichero = "/direcciones";
	
	private InputStream ficheroALeer = null;

	private BufferedReader in = null;
	
	public void leerFichero(){
		
		ficheroALeer = Accion.class.getResourceAsStream(nombreFichero);
		in  = new BufferedReader(new InputStreamReader(ficheroALeer));
	}
	
}
