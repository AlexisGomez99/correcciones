package ar.edu.unrn.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;

public class Venta {
	
	private LocalDateTime fechaDeLaVenta;
	private Combustible combustible;
	private int cantLitros;
	private int descuento=0;
	public Venta(Combustible combustible, String cantLitros, LocalDateTime fecha) throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException{
		super();
		
		if(esDatoNulo(cantLitros))
			throw new NotNullException("Cantidad de litros");
		if(esDatoVacio(cantLitros))
			throw new DataEmptyException("Cantidad de litros");
		if(!esNumero(cantLitros))
			throw new NotNumbreException("Debe ingresar un numero");
		this.cantLitros= Integer.parseInt(cantLitros);
		if(this.cantLitros<0)
			throw new RuntimeException("La cantidad de litros debe ser mayor a 0.");
		
		
		this.fechaDeLaVenta = fecha;		
		this.combustible = combustible;
	}
	
	
	//Getters
	public LocalDateTime fecha() {
		return fechaDeLaVenta;
	}

	public Combustible combustible() {
		return combustible;
	}

	public int cantidadDeLitros() {
		return cantLitros;
	}

	public int descuento() {
		return descuento;
	}
	
	
	//Calcula total de la venta.
	public double calcularTotal() {
		double total= combustible.calcularPrecioPorLitros(cantLitros, this.fechaDeLaVenta);
		return total;
	}
	
	
	//Verificaciones
	private boolean esDatoNulo(String dato) {
		return dato == null;
	}
	private boolean esDatoVacio(String dato) {
		return dato.equals("");
	}
	private static boolean esNumero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	

}
