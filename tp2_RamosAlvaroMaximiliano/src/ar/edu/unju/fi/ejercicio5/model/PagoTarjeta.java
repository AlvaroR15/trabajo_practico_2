package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numeroTarjeta;
	private LocalDate fechaDePago;
	private Double montoPagado;
	
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaDePago, Double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(Double monto) {
		setMontoPagado(montoPagado + (montoPagado * 0.15));
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("Numero de tarjeta: " + numeroTarjeta);
		System.out.println("Fecha de pago: " + fechaDePago.now());
		System.out.println("Monto pagado: " + montoPagado);
	}
	
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public LocalDate getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public Double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	
}
