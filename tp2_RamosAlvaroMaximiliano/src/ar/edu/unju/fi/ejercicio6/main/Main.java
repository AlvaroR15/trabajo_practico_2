package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoSalvaje felinoSalvaje = new FelinoSalvaje("Tanner", (byte)20,186f);
	
		
        if (Converter.isNotNull(felinoSalvaje)) {
        	FelinoDomestico felinoDomestico = converter.convert(felinoSalvaje);
        	converter.mostrarObjeto(felinoDomestico);
        }
        

	}

}
