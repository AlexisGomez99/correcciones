package ar.edu.unrn.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Super extends Combustible{
	private final double precio=90;
	
	public Super(String nombre) {
		super(nombre);
	}

	@Override
	public double precioPorLitro() {
		return precio;
	}

	@Override
	public double calcularPrecioPorLitros(int cantLitros,LocalDateTime fecha) {
		double total= precio* cantLitros;
		if(hoyEs(fecha,"SATURDAY")&&cantLitros>=20) {
			total=total- ((total*12)/100);
		}
		else {
			if(hoyEs(fecha,"SUNDAY")) {
			total=total- ((total*15)/100);
			}
		}
		return total;
	}
	private boolean hoyEs(LocalDateTime fecha,String diaEvaluar) {
		boolean sabado=false;

		if(fecha.getDayOfWeek().name().equalsIgnoreCase(diaEvaluar))
			sabado=true;
		return sabado;
	}
}
