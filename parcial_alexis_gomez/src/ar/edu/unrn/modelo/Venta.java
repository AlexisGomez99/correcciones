package ar.edu.unrn.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;

public class Venta {
	
	private LocalDate fecha_de_la_venta;
	private Combustible combustible;
	private int cantidad_de_litros;
	private float total=0;
	private int descuento=0;
	public Venta(Combustible combustible, String cantidad_de_litros,float total, LocalDate fecha) throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException{
		super();
		
		if(esDatoNulo(cantidad_de_litros))
			throw new NotNullException("Cantidad de litros");
		if(esDatoVacio(cantidad_de_litros))
			throw new DataEmptyException("Cantidad de litros");
		if(!esNumero(cantidad_de_litros))
			throw new NotNumbreException("Debe ingresar un numero");
		Integer cantLitros= Integer.parseInt(cantidad_de_litros);
		if(cantLitros<0)
			throw new RuntimeException("La cantidad de litros debe ser mayor a 0.");
		
		
		this.fecha_de_la_venta = fecha;		
		this.combustible = combustible;
		this.cantidad_de_litros = cantLitros;
		this.total=total;
	}
	
	
	//Getters
	public LocalDate fecha() {
		return fecha_de_la_venta;
	}

	public Combustible combustible() {
		return combustible;
	}

	public int cantidadDeLitros() {
		return cantidad_de_litros;
	}

	public float total() {
		return total;
	}
	public int descuento() {
		return descuento;
	}
	
	
	//Calcula total de la venta.
	public float calcularTotal() {
		float total= totalBruto();
		if(combustible.esComun()) {
			if(estaEnHora()) {
				total=total- ((total*5)/100);
				descuento=5;
				
			}
		}
		else {
			if(hoyEs("SATURDAY")&&this.cantidad_de_litros>=20) {
				total=total- ((total*12)/100);
				descuento=12;
				
			}
			else {
				if(hoyEs("SUNDAY")) {
				total=total- ((total*15)/100);
				descuento=15;
				
				}
			}
			
		}
		this.total=total;
		
		return total;
	}
	
	
	//Verificaciones
	private boolean hoyEs(String diaEvaluar) {
		boolean sabado=false;
		if(fecha_de_la_venta.getDayOfWeek().name().equalsIgnoreCase(diaEvaluar))
			sabado=true;
		return sabado;
	}
	private boolean estaEnHora() {
		boolean estaEnHora=false;
		LocalTime hora= LocalTime.now();
		if(hora.getHour()>=8 && hora.getHour()<=10) 
			estaEnHora=true;
		return estaEnHora;
	}
	private float totalBruto() {
		return cantidad_de_litros * combustible.precio();
	}

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
