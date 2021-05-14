package ar.edu.unrn.modelo;

import java.time.LocalDateTime;

public abstract class Combustible {
	private String nombre;
	
	protected Combustible(String nombre) {
		this.nombre= nombre;
	}

	public abstract double precioPorLitro();
	
	public abstract double calcularPrecioPorLitros(int cantLitros, LocalDateTime fecha);
	
	
}
