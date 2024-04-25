package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private Float estatura;
	private Float peso;
	private Posicion posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + "]";
	}



	public Jugador(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, Float estatura,
			Float peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}


	public Integer calcularEdad() {
		return LocalDate.now().getYear() - fechaDeNacimiento.getYear();
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}



	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public Float getEstatura() {
		return estatura;
	}



	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}



	public Float getPeso() {
		return peso;
	}



	public void setPeso(Float peso) {
		this.peso = peso;
	}



	public Posicion getPosicion() {
		return posicion;
	}



	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	
}
