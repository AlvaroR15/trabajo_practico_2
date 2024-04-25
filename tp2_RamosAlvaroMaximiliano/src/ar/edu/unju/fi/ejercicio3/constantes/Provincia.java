package ar.edu.unju.fi.ejercicio3.constantes;


public enum Provincia {
	JUJUY(713971, 53219.0), SALTA(1333000,1554788.0),
	TUCUMAN(1593000,22525.0), CATAMARCA(396895,102602.1),
	LA_RIOJA(362605,89680.0), SANTIAGO_DEL_ESTERO(1060906,136351.2);
	
	
	private Integer cantidadPoblacion;
	private Double superficie;
	
	
	
	private Provincia(Integer cantidadPoblacion, Double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	
	

	public Integer getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public Double getSuperficie() {
		return superficie;
	}


	public Double calcularDensidadPoblacional() {
		return getCantidadPoblacion() / getSuperficie();
	}
}
