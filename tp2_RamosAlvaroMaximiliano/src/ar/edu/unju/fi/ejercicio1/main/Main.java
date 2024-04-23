package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Producto> productos = new ArrayList<>();
	
	public static void main(String[] args) {
		Integer opcion = null;
		do {
			try {
			System.out.println("----MENU DE OPCIONES----");
			System.out.println("Elija una opción");
			System.out.println("1 - Crear Producto");						
			System.out.println("2 - Mostrar productos");
			System.out.println("3 - Modificar producto");
			System.out.println("4 - Salir");
			opcion = scanner.nextInt();scanner.nextLine();
			
			switch(opcion) {
			case 1: crearProducto();break;
			case 2: mostrarProductos();break;
			case 3: modificarProducto();break;
			case 4: System.out.println("---FIN DEL PROGRAMA---");break;
			default: System.out.println("Debes ingresar un número dentro del rango solicitado");
			}
			} catch(Exception e) {
				System.out.println("¡ERROR! Debes ingresar un número");
				scanner.nextLine();
			}
			
		} while (opcion != 4);
	
	}

		
		
	
	public static OrigenFabricacion pedirOrigenFabricacion() {
		Integer opcion = null;
		OrigenFabricacion origenDeFabricacion = null;
		do {
			try {
				System.out.println("---- Origen de fabricación -----");
				System.out.println("1 - Argentina");
				System.out.println("2 - China");
				System.out.println("3 - Brasil");
				System.out.println("4 - Uruguay");	
				System.out.println("Elija una opción");	
				opcion = scanner.nextInt();
				
			switch(opcion) {
				case 1: origenDeFabricacion = OrigenFabricacion.ARGENTINA;break;
				case 2: origenDeFabricacion = OrigenFabricacion.CHINA;break;
				case 3: origenDeFabricacion = OrigenFabricacion.BRASIL;break;
				case 4: origenDeFabricacion = OrigenFabricacion.URUGUAY;break;
				default: System.out.println("La opción ingresada no es válida");;
			}
			} catch(Exception e) {
				System.out.println("¡ERROR! Debes ingresar un número");
				scanner.nextLine();
			}
		} while(opcion == null || opcion < 1 || opcion > 4);
		return origenDeFabricacion;
	}
	
	public static Categoria pedirCategoria() {
		Categoria categoria = null;
		Integer opcion = null;
		do {
			try {
				System.out.println("---- Categoría -----");
				System.out.println("1 - Telefonía");
				System.out.println("2 - Informática");
				System.out.println("3 - Electro hogar");
				System.out.println("4 - Herramientas");
				System.out.println("Elija una opción");	
				opcion = scanner.nextInt();
				switch (opcion) {
				case 1: categoria = Categoria.TELEFONIA;break;
				case 2: categoria = Categoria.INFORMATICA;break;
				case 3: categoria = Categoria.ELECTROHOGAR;break;
				case 4: categoria = Categoria.HERRAMIENTAS;break;
				default: System.out.println("La opción ingresada no es válida");
				}				
			} catch(Exception e) {
				System.out.println("¡ERROR! Debes ingresar un número");
				scanner.nextLine();
			}
			
		} while(opcion == null || opcion < 1 || opcion > 4);
		return categoria;
	}
	
	public static void crearProducto() {
		Producto producto = new Producto();
		System.out.println("Ingrese el código para el producto");
		producto.setCodigo(scanner.nextLine());
		
		System.out.println("Ingrese la descripcion para el producto");
		producto.setDescripcion(scanner.nextLine());
		
		System.out.println("Ingrese el precio unitario del producto");
		producto.setPrecioUnitario(scanner.nextDouble());scanner.nextLine();
		
		System.out.println("Seleccione el origen de fabricación");
		producto.setOrigenFabricacion(pedirOrigenFabricacion());
		
		System.out.println("Seleccione la categoría del producto");
		producto.setCategoria(pedirCategoria());
		
		productos.add(producto);
	}
	
	public static void mostrarProductos() {
		System.out.println("    PRODUCTOS REGISTRADOS");
		productos.forEach(p -> System.out.println(p));
	}
	
	public static void modificarProducto() {
		System.out.println("Ingrese el código del producto a modificar");
		String codigo = scanner.nextLine();
		
		Producto productoActualizado = null;
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				productoActualizado = producto;break;
			}
		}
		
		if (productoActualizado != null) {
			System.out.println("Ingrese la nueva descripcion del producto");
			productoActualizado.setDescripcion(scanner.nextLine());
			
			System.out.println("Ingrese el nuevo precio unitario del producto");
			productoActualizado.setPrecioUnitario(scanner.nextDouble());scanner.nextLine();
			
			System.out.println("Seleccione el nuevo origen de fabricación del producto");
			productoActualizado.setOrigenFabricacion(pedirOrigenFabricacion());
			
			System.out.println("Seleccione la nueva categoría del producto");
			productoActualizado.setCategoria(pedirCategoria());
		} else {
			System.out.println("El producto no se encuentra registrado");
		}
	}
}
