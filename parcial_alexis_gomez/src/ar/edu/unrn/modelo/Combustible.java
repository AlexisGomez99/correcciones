package ar.edu.unrn.modelo;

public class Combustible {
	
	private String tipoCombustible;
	private int precio;
	
	public Combustible(String tipoCombustible) {
		super();
		this.tipoCombustible = tipoCombustible;
		this.precio=cambiarPrecio();
	}
	
	
	private int cambiarPrecio() {
		int precio=70;
		if(tipoCombustible.equalsIgnoreCase("Super"))
			precio=90;
		return precio;
	}

	
	public String tipoCombustible() {
		return tipoCombustible;
	}
	
	public boolean esComun() {
		return tipoCombustible.equals("Comun");
	}

	public int precio() {
		return precio;
	}


	@Override
	public String toString() {
		return "Combustible [tipoCombustible=" + tipoCombustible + ", precio=" + precio + "]";
	}
	
	
}
