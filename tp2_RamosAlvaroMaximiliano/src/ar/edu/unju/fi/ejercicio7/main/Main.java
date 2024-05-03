package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Producto> productos = new ArrayList<>();

	
	public static void main(String[] args) {
		precargarProductos();
		//mostrarOpciones();
		//mostrarProductosDisponibles();
		// mostrarProductosFaltantes();
		//incrementarPrecioProductos();
		// mostrarProductosElectrohogar();
		//ordenarProductosPorPrecioDescendente();
		mostrarProductosEnMayusculas();
	}

	
	public static void precargarProductos () {
	    Producto[] arrayProductos = new Producto[] {
	        new Producto("1", "Samsung Galaxy A3", 110999.9, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true),
	        new Producto("2", "Lenovo ThinkPad X1 Carbon", 189999.9, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true),
	        new Producto("3", "Philips Smart TV 50 Pulgadas", 89999.9, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true),
	        new Producto("4", "DeWalt Taladro Percutor", 5499.9, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false),
	        new Producto("5", "Motorola Moto G9 Plus", 79999.9, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false),
	        new Producto("6", "Bangho Max G5", 58999.9, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true),
	        new Producto("7", "Philco Lavarropas Automático", 49999.9, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true),
	        new Producto("8", "Black & Decker Juego de Herramientas", 7999.9, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false),
	        new Producto("9", "Xiaomi Redmi Note 10", 89999.9, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true),
	        new Producto("10", "Positivo BGH All-in-One", 64999.9, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true),
	        new Producto("11", "Electrolux Heladera No Frost", 89999.9, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false),
	        new Producto("12", "Tramontina Set de Herramientas", 3999.9, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true),
	        new Producto("13", "Nokia 5.4", 63999.9, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true),
	        new Producto("14", "Exo Ultrabook", 69999.9, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true),
	        new Producto("15", "Midea Aire Acondicionado Split", 71999.9, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true)
	    };
	    
	    for (Producto productoArray: arrayProductos) {
	    	productos.add(productoArray);
	    }
	}
	
	public static Byte mostrarOpciones() {
		Byte option = null;
		Boolean salida = false;
		do {
			try {
				System.out.println("MENU DE OPCIONES");
				System.out.println("1 - Mostrar productos");
				System.out.println("2 - Mostrar productos faltantes");
				System.out.println("3 - Incrementar los precios de los productos en un 20%");
				System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
				System.out.println("5 - Ordenar los productos por precio de forma descendente.");
				System.out.println("6 - Mostrar los productos con los nombres en mayúsculas.");
				option = scanner.nextByte();scanner.nextLine();
				Boolean message = option < 1 || option > 6;
				if (option < 1 || option > 6) {
					System.out.println("Debes ingresar un número solicitado dentro del rango");
				} else {
					salida = true;
				}
			} catch(Exception e) {
				System.out.println("ERROR: debes ingresar un número para una de las opciones");
				scanner.nextLine();
			}
		} while(!salida);
		return option;
	}
	
	
	public static void mostrarProductosDisponibles() {
	   Consumer<Producto> printConsumer = p -> {
		   if (p.getStock()) System.out.println(p);
	   };
	   System.out.println("PRODUCTOS EN STOCK");
	   productos.forEach(printConsumer);
	}
	
	public static void mostrarProductosFaltantes() {
		Predicate<Producto> filterStock = p -> !p.getStock();
		List<Producto> productosFaltantes = productos.stream().filter(filterStock).collect(Collectors.toList());

		System.out.println("PRODUCTOS SIN STOCK");
		Consumer<Producto> printConsumer = p -> System.out.println(p);
		productosFaltantes.forEach(printConsumer);
	}
	
	public static void incrementarPrecioProductos() {
		Function<Producto, Producto> funcionIncrementar = p -> {
			Double resultado = p.getPrecioUnitario() + (p.getPrecioUnitario() * 0.20);
			p.setPrecioUnitario(resultado);
			return p;
		};
		
		List<Producto> productosIncrementados = productos.stream().map(funcionIncrementar).collect(Collectors.toList());
		System.out.println("---PRODUCTOS AUMENTADOS---");
		productosIncrementados.forEach(System.out::println);
	}
	
	public static void mostrarProductosElectrohogar() {
		Predicate<Producto> filterCategoria = p -> p.getCategoria().equals(Categoria.ELECTROHOGAR) && p.getStock();
		productos.stream().filter(filterCategoria).forEach(System.out::println);
		
	}
	
	public static void ordenarProductosPorPrecioDescendente() {
		Comparator<Producto> comparator = Comparator.comparing(Producto::getPrecioUnitario).reversed();
		productos.sort(comparator);
		productos.forEach(System.out::println);
	}
	
	public static void mostrarProductosEnMayusculas() {
		Function<Producto, Producto> funcionTransformar = p -> {
			p.setDescripcion(p.getDescripcion().toUpperCase());
			return p;
		};
		
		List<Producto> productosEnMayusculas = productos.stream().map(funcionTransformar).collect(Collectors.toList());
		productosEnMayusculas.forEach(System.out::println);
	}
}
