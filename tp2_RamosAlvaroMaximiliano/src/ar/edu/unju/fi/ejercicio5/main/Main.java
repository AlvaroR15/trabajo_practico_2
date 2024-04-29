package ar.edu.unju.fi.ejercicio5.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	private Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
	}

	public static void precargarProductos () {
		Producto prod1 = new Producto("1", "Samsung Galaxy A3", 110999.9, OrigenFabricacion.CHINA, Categoria.TELEFONIA);
		Producto prod2 = new Producto("2", "Lenovo ThinkPad X1 Carbon", 189999.9, OrigenFabricacion.CHINA, Categoria.INFORMATICA);
		Producto prod3 = new Producto("3", "Philips Smart TV 50 Pulgadas", 89999.9, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR);
		Producto prod4 = new Producto("4", "DeWalt Taladro Percutor", 5499.9, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS);

		Producto prod5 = new Producto("5", "Motorola Moto G9 Plus", 79999.9, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA);
		Producto prod6 = new Producto("6", "Bangho Max G5", 58999.9, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA);
		Producto prod7 = new Producto("7", "Philco Lavarropas Automático", 49999.9, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR);
		Producto prod8 = new Producto("8", "Black & Decker Juego de Herramientas", 7999.9, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS);

		Producto prod9 = new Producto("9", "Xiaomi Redmi Note 10", 89999.9, OrigenFabricacion.BRASIL, Categoria.TELEFONIA);
		Producto prod10 = new Producto("10", "Positivo BGH All-in-One", 64999.9, OrigenFabricacion.BRASIL, Categoria.INFORMATICA);
		Producto prod11 = new Producto("11", "Electrolux Heladera No Frost", 89999.9, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR);
		Producto prod12 = new Producto("12", "Tramontina Set de Herramientas", 3999.9, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS);

		Producto prod13 = new Producto("13", "Nokia 5.4", 63999.9, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA);
		Producto prod14 = new Producto("14", "Exo Ultrabook", 69999.9, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA);
		Producto prod15 = new Producto("15", "Midea Aire Acondicionado Split", 71999.9, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR);


	}
}
