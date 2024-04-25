package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		for (int i = 0; i < provincias.length; i++) {
			System.out.println("Provincia de "+provincias[i] + " Densidad poblacional: " + provincias[i].calcularDensidadPoblacional() + " (hab/km2)");
		}
	}

}
