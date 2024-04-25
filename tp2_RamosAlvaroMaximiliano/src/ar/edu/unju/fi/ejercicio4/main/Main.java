package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Jugador> jugadores = new ArrayList<>();
	
	public static void main(String[] args) {
		Integer opcion;
		do {
		opcion = mostrarOpciones();
		switch(opcion) {
		case 1: altaJugador();break;
		case 2: mostrarJugadores();break;
		case 3: modificarJugador();break;
		case 4: eliminarJugador();break;
		case 5: System.out.println("---FIN DEL PROGRAMA---");break;
		default: System.out.println("La opción ingresada no es válida");
		}
		} while(opcion != 5);
	}

	public static Integer mostrarOpciones() {
		Integer opcion = null;
        do {
        	try {
            System.out.println("----MENU DE OPCIONES----");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar los datos de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        	} catch(Exception e) {
        		System.out.println("ERROR: debes ingresar un número");
        		scanner.nextLine();
        	}
        } while(opcion == null || opcion < 1 || opcion > 8);
        return opcion;
	}
	
	
	
	public static void altaJugador() {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el apellido del jugador: ");
        String apellido = scanner.nextLine();
        
        LocalDate fechaNacimiento = pedirFecha();
        
        System.out.println("Ingrese la nacionalidad del jugador");
        String nacionalidad = scanner.nextLine();
        
        Float[] datos = pedirPesoyAltura();
        Float estatura = datos[0];
        Float peso = datos[1];
        
        
        Posicion posicion = pedirPosicion();

        Jugador jugador = new Jugador(nombre,apellido,fechaNacimiento,nacionalidad,estatura,peso,posicion);
        jugadores.add(jugador);
    }
	
	public static void mostrarJugadores() {
		jugadores.forEach(jugadores -> System.out.println(jugadores));
	}
	
	public static void modificarJugador() {
		String[] nombreYapellidoJugador = pedirNombreYapellido();
        String nombre = nombreYapellidoJugador[0];
        String apellido = nombreYapellidoJugador[1];

		Jugador jugadorAmodificar = null;
        
        for (Jugador jugador: jugadores) {
        	if (jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
        		jugadorAmodificar = jugador;
        		break;
        	}
        }
        
        if (jugadorAmodificar != null) {
        	System.out.println("Ingrese el nuevo nombre del jugador: ");
            jugadorAmodificar.setNombre(scanner.nextLine());
            
            System.out.println("Ingrese el nuevo apellido del jugador: ");
            jugadorAmodificar.setApellido(scanner.nextLine());
            
            jugadorAmodificar.setFechaDeNacimiento(pedirFecha());
            
            System.out.println("Ingrese la nueva nacionalidad del jugador: ");
            jugadorAmodificar.setNacionalidad(scanner.nextLine());
            
            Float[] datos = pedirPesoyAltura();
            jugadorAmodificar.setEstatura(datos[0]);
            jugadorAmodificar.setPeso(datos[1]);
            
            jugadorAmodificar.setPosicion(pedirPosicion());
            
            System.out.println(jugadorAmodificar.toString());
                
        } else {
    		System.out.println("El jugador no esta cargado en el registro");
        }
        
	}
	
	
	public static void eliminarJugador() {
		String[] nombreYapellidoJugador = pedirNombreYapellido();
        String nombre = nombreYapellidoJugador[0];
        String apellido = nombreYapellidoJugador[1];
        
        Boolean encontrado = false;

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
        	Jugador jugador = iterator.next();
        	if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
        		iterator.remove();
        		System.out.println("El jugador "+nombre+" "+apellido+" ha sido eliminado de la lista");
        		encontrado = true;
        	}
        }
        
        if (!encontrado) {
        	System.out.println("No se encontro el jugador en la lista");
        }
	}
	
	public static String[] pedirNombreYapellido() {
		String[] nombreYApellido = new String[2];
	    System.out.println("Ingrese el nombre del jugador:");
	    nombreYApellido[0] = scanner.nextLine();
	    System.out.println("Ingrese el apellido del jugador:");
	    nombreYApellido[1] = scanner.nextLine();
	    return nombreYApellido;
	}
	
	public static Posicion pedirPosicion() {
		Posicion posicionElegida = null;
		do {
			System.out.println("Ingrese la posición del jugador");
			System.out.println("OPCIONES");
		
		for (Posicion posicion: Posicion.values()) {
			System.out.println("- "+posicion);
		}
		
		String opcion = scanner.nextLine().toUpperCase();
		
		try {
			posicionElegida = Posicion.valueOf(opcion);
		} catch(Exception e) {
			System.out.println("La opción ingresada no es válida");
		}
		
		} while (posicionElegida == null);
		
		return posicionElegida;
		}
	
	public static LocalDate pedirFecha() {
		LocalDate fechaIngresada = null;
		do {
			try {
			System.out.println("Ingrese la fecha de nacimiento del jugador de la siguiente manera: "+LocalDate.now());
			fechaIngresada = LocalDate.parse(scanner.nextLine());
			} catch(Exception e) {
				System.out.println("El dato ingresado no es valido, vuelva a intentarlo");
			}
		} while (fechaIngresada == null);
       return fechaIngresada; 
	}
	
	public static Float[] pedirPesoyAltura() {
		Float[] datos = new Float[2];
		Boolean datosValidos = false;
		do {
		   try {
		   System.out.println("Ingrese la ESTATURA del jugador (en metros): ");
	       datos[0] = scanner.nextFloat();scanner.nextLine();
	            
	       System.out.println("Ingrese el PESO del jugador (en kilogramos): ");
	       datos[1] = scanner.nextFloat();scanner.nextLine();
	       datosValidos = true;
	       } catch(Exception e) {
	    	   System.out.println("Los datos deben ser ingresados de la siguiente manera. Ejemplo:");
	           System.out.println("Peso: 70,6. Estatura: 1,80");
	           scanner.nextLine();
	       }
		} while(!datosValidos);
		return datos;
	}
}
