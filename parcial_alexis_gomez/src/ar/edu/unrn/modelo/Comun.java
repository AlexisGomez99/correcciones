package ar.edu.unrn.modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Comun extends Combustible{
	private final double precio=70;
	
	public Comun(String nombre) {
		super(nombre);
	}

	@Override
	public double precioPorLitro() {
		return precio;
	}

	@Override
	public double calcularPrecioPorLitros(int cantLitros,LocalDateTime fecha) {
		double total= precio * cantLitros;
		if(estaEnHora(fecha)) {
			total-= total*0.05;
			
		}
		return total;
	}
	
	private boolean estaEnHora(LocalDateTime fecha) {
		boolean estaEnHora=false;
		if(fecha.getHour()>=8 && fecha.getHour()<=10) 
			estaEnHora=true;
		return estaEnHora;
	}

	
}
