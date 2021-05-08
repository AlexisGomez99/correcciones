package ar.edu.unrn.modelo;

public class VentaDTO {
	
	private String fecha;
	private String combustible;
	private String litros;
	private String total;
	
	public VentaDTO(String fecha, String combustible, String litros, String total) {
		super();
		this.fecha = fecha;
		this.combustible = combustible;
		this.litros = litros;
		this.total = total;
	}

	public String fecha() {
		return fecha;
	}

	public String combustible() {
		return combustible;
	}

	public String litros() {
		return litros;
	}

	public String total() {
		return total;
	}

	@Override
	public String toString() {
		return "VentaDTO [fecha=" + fecha + ", combustible=" + combustible + ", litros=" + litros + ", total=" + total
				+ "]";
	}
	
	

}
