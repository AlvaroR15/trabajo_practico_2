package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numeroTarjeta;
	private LocalDate fechaDePago;
	private Double montoPagado;
	
	
	
	
	
	
	@Override
	public void realizarPago(Double monto) {
		this.montoPagado = montoPagado + (montoPagado * 0.15);
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Numero de tarjeta: " + numeroTarjeta);
		System.out.println("Fecha de pago: " + fechaDePago);
		System.out.println("Monto pagado: " + montoPagado);
	}
}
