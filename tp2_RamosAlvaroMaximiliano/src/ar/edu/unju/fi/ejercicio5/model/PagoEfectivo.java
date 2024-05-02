package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private Double montoPagado;
	private LocalDate fechaDePago;
	
	
	
	
	public PagoEfectivo(Double montoPagado, LocalDate fechaDePago) {
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
	}
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void realizarPago(Double monto) {
		setMontoPagado(montoPagado - (montoPagado * 0.10));
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: " + fechaDePago);
		System.out.println("Monto pagado: " + montoPagado);
	}
	public Double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}
	public LocalDate getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	
	
	
}
