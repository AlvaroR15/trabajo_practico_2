package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;


public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Producto> productos = new ArrayList<>();
	
	public static void main(String[] args) {
		precargarProductos();
		Integer opcion;
		do {
			opcion = mostrarOpciones();
			switch (opcion) {
			case 1: mostrarProductos();break;
			case 2: realizarCompra();break;
			case 3: System.out.println("-----FIN DEL PROGRAMA-----");break;
			default: System.out.println("Opción inválida.");
			}
		} while(opcion != 3);
	}

	
	/**
	 * Metodo para precargar productos
	 */
	
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
	
	/**
	 * Metodo para mostrar las opciones
	 * @return
	 */
	public static Integer mostrarOpciones() {
		Integer opcion = null;
        do {
        	try {
            System.out.println("----MENU DE OPCIONES----");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        	} catch(Exception e) {
        		System.out.println("ERROR: debes ingresar un número");
        		scanner.nextLine();
        	}
        } while(opcion == null || opcion < 1 || opcion > 3);
        return opcion;
	}
	
	/**
	 * MEtodo para mostrar productos
	 */
	public static void mostrarProductos() {
		productos.forEach(p -> System.out.println(p));
	}
	
	
	/**
	 * Metodo para realizar la compra de uno o mas productos con la opcion de
	 * pagar con efectivo o tarjeta, usando sus clases correspondientes
	 */
	public static void realizarCompra() {
		String codigo = null;
		Boolean salida = true;
		List<Producto> productosComprados = new ArrayList<>();
		
		do {
			System.out.println("Ingrese el código del producto que desea comprar");
			System.out.println("Para salir ingrese SALIR");
			codigo = scanner.next();
			if (codigo.toUpperCase().equals("SALIR")) {
				salida = false;
				break;
			} else {
				Boolean productoEncontrado = false;
				for (Producto producto: productos) {
					if (producto.getCodigo().equals(codigo)) {
						productosComprados.add(producto);
						productoEncontrado = true;
						break;
					} 
				}
				if (!productoEncontrado) {
					System.out.println("No existe el producto con el codigo "+codigo);
				}				
			}
		} while(salida);
		
		
		Double total = 0.0;
		if (!productosComprados.isEmpty()) {
			System.out.println("PRODUCTOS AGREGADOS AL CARRITO:");
			for(Producto producto: productosComprados) {
				total += producto.getPrecioUnitario();
			}
			productosComprados.forEach(p -> System.out.println(p));
			System.out.println("PRECIO TOTAL: "+Math.floor(total));
			Byte opcion = null;
			do {
				try {
				System.out.println("¿Como desea pagar?");
				System.out.println("1 - Pago efectivo");
				System.out.println("2 - Pago con tarjeta");
				opcion = scanner.nextByte();scanner.nextLine();
				
				
				if (opcion == 1) {
					PagoEfectivo pagoEfectivo = new PagoEfectivo(Math.floor(total), LocalDate.now());
					pagoEfectivo.realizarPago(total);
					pagoEfectivo.imprimirRecibo();
					System.out.println("FIN DEL PROGRAMA");
				} else if (opcion == 2) {
					PagoTarjeta pagoTarjeta = new PagoTarjeta();
					System.out.println("Ingrese el número de la tarjeta");
					pagoTarjeta.setNumeroTarjeta(scanner.nextLine());
					pagoTarjeta.setFechaDePago(LocalDate.now());
					pagoTarjeta.setMontoPagado(Math.floor(total));
					pagoTarjeta.realizarPago(total);
					pagoTarjeta.imprimirRecibo();
					System.out.println("FIN DEL PROGRAMA");
				} else {
					System.out.println("La opcion ingresada no es válida");
				}
				} catch(Exception e) {
					System.out.println("ERROR: Debes ingresar un número");
					scanner.nextLine();
				}
			} while(opcion != 1 && opcion != 2 && opcion != null);
		} else {
			System.out.println("No se encuentran productos en el carrito");
			System.out.println("FIN DEL PROGRAMA");
		}
		
	}

}
