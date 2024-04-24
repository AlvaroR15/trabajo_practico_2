package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static List<Efemeride> efemerides = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Integer opcion;
		do {
		opcion = mostrarOpciones();
		switch(opcion) {
		case 1: crearEfemeride();break;
		case 2: mostrarEfemerides();break;
		case 3: eliminarEfemeride();break;
		case 4: modificarEfemeride();break;
		case 5: System.out.println("FIN DEL PROGRAMA");break;
		default: System.out.println("La opción ingresada no es válida");
		}
		} while(opcion != 5);
	}
	
	public static Integer mostrarOpciones() {
		Integer opcion = null;
		do {
			try {
			System.out.println("--MENU DE ACCIONES--");
			System.out.println("1 - Crear efemeride");
			System.out.println("2 - Mostrar efeméride");
			System.out.println("3 - Eliminar efeméride");
			System.out.println("4 - Modificar efeméride");
			System.out.println("5 - Salir");
			opcion = scanner.nextInt();scanner.nextLine();
			} catch(Exception e) {
				System.out.println("ERROR: Debes ingresar un número");
				scanner.nextLine();
			}
		} while(opcion == null || opcion < 1 || opcion > 5);
		return opcion;
	}

	public static Mes pedirMes() {
		Mes mesElegido = null;
		Integer numero = null;
		do {
			try {
			System.out.println("Ingrese un número correspondiente a un mes del año");
			System.out.println("1: Enero; 2: Febrero; 3: Marzo; etc.");
			numero = scanner.nextInt();scanner.nextLine();
			switch(numero) {
			case 1: mesElegido = Mes.ENERO;break;
			case 2: mesElegido = Mes.FEBRERO;break;
			case 3: mesElegido = Mes.MARZO;break;
			case 4: mesElegido = Mes.ABRIL;break;
			case 5: mesElegido = Mes.MAYO;break;
			case 6: mesElegido = Mes.JUNIO;break;
			case 7: mesElegido = Mes.JULIO;break;
			case 8: mesElegido = Mes.AGOSTO;break;
			case 9: mesElegido = Mes.SEPTIEMBRE;break;
			case 10: mesElegido = Mes.OCTUBRE;break;
			case 11: mesElegido = Mes.NOVIEMBRE;break;
			case 12: mesElegido = Mes.DICIEMBRE;break;
			default: System.out.println("El número no corresponde a ningun mes");
			}
			} catch(Exception e) {
				System.out.println("ERROR: Debes ingresar un número");
				scanner.nextLine();
			}
		} while(numero == null || numero < 1 || numero > 12);
		
		
		return mesElegido;
	}
	
	public static void crearEfemeride() {
		Efemeride efemeride = new Efemeride();
		System.out.println("Ingrese el código para la efemeride");
		efemeride.setCodigo(scanner.nextLine());
		
		efemeride.setMes(pedirMes());
				
		System.out.println("Ingrese el dia");
		efemeride.setDia(scanner.nextLine());
		
		
		System.out.println("Ingrese el detalle");
		efemeride.setDetalle(scanner.nextLine());
		
		efemerides.add(efemeride);
	}
	
	public static void modificarEfemeride() {
		System.out.println("Ingrese el código de efemeride a modificar");
		String codigo = scanner.nextLine();
		
		Efemeride efemerideActualizada = null;
		for (Efemeride efemeride: efemerides) {
			if (efemeride.getCodigo().equals(codigo)) {
				efemerideActualizada = efemeride;break;
			}
		}
		
		if (efemerideActualizada != null) {
			
			efemerideActualizada.setMes(pedirMes());
					
			System.out.println("Ingrese el dia");
			efemerideActualizada.setDia(scanner.nextLine());
			
			
			System.out.println("Ingrese el detalle");
			efemerideActualizada.setDetalle(scanner.nextLine());
			
		} else {
			System.out.println("La efemeride no se encuentra registrada");
		}
	}
	
	public static void eliminarEfemeride() {
		System.out.println("Ingrese el código de efemeride a eliminar");
		String codigo = scanner.nextLine();
		
		Boolean encontrada = false;
		
		Iterator<Efemeride> iterator = efemerides.iterator();
		while (iterator.hasNext()) {
			Efemeride efemeride = iterator.next();
			if (efemeride.getCodigo().equals(codigo)) {
				iterator.remove();
				encontrada = true;
				System.out.println("Efemeride eliminada");
				break;
			}
		}
		if (!encontrada) {
			System.out.println("La efemeride no se encontro");
		}
	}
	
	public static void mostrarEfemerides() {
		if (efemerides.size() == 0) {
			System.out.println("No hay efemerides registradas todavía");
		} else {
			System.out.println("--------LISTADO-------");
			efemerides.forEach(e -> System.out.println(e));
		}
	}
}
