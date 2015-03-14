package net.erickpineda.javaswing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accion {
	/**
	 * Ruta del fichero a escribir.
	 */
	private static String nombreFichero = "direcciones";
	/**
	 * Lector del fichero.
	 */
	private static FileReader lecturaFichero = null;
	/**
	 * Fichero en lectura.
	 */
	private static BufferedReader inFile = null;
	/**
	 * Fichero a a escribir
	 */
	private static FileWriter ficheroAEscribir = null;
	/**
	 * Escritor del fichero.
	 */
	private static PrintWriter outFile = null;
	/**
	 * Lista de lo que serán las URL en el fichero.
	 */
	private static List<String> lista = new ArrayList<String>();

	/**
	 * 
	 * @return Retorna la cantida de lineas(una URL por cada) en el fichero.
	 */
	public static int totalLineas() {

		int contadorLineas = 0;

		try {

			String linea;

			lecturaFichero = new FileReader(nombreFichero);
			inFile = new BufferedReader(lecturaFichero);

			while ((linea = inFile.readLine()) != null) {
				lista.add(new String(linea));
				contadorLineas++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contadorLineas;
	}

	/**
	 * 
	 * return Retorna la lista de URLs.
	 */
	public static List<String> getLista() {
		return lista;
	}

	/**
	 * Métod que escribe en el fichero.
	 * 
	 * @param url
	 *            URL a cambiar.
	 */
	public static void escribirFichero(String url) {
		try {

			ficheroAEscribir = new FileWriter(nombreFichero, true);
			outFile = new PrintWriter(ficheroAEscribir);

			outFile.println(url);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outFile != null)
				outFile.close();
		}
	}

	/**
	 * Valida la URL que se escribirá en el fichero.
	 * 
	 * @param url
	 *            URL en String a validar.
	 * @return Retorna falso o true según resulte la validación de la URL.
	 */
	public static boolean comprobarURL(String url) {
		String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		boolean urlCorrecta = false;

		if (!url.trim().equals("")) {

			Pattern exre = Pattern.compile(regex);
			Matcher mat = exre.matcher(url);

			if (mat.matches()) {
				urlCorrecta = true;
			}
		}
		return urlCorrecta;
	}

}
