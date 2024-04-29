package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private Double montoPagado;
	private LocalDate fechaDePago;
	
	
	
	
	@Override
	public void realizarPago(Double monto) {
		this.montoPagado = montoPagado - (montoPagado * 0.10);
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: " + fechaDePago);
		System.out.println("Monto pagado: " + montoPagado);
	}
	
}
