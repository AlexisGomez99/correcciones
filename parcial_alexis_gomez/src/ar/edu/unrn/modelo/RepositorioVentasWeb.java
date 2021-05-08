package ar.edu.unrn.modelo;


import java.util.List;

import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;

public interface RepositorioVentasWeb {
	
	void registrarVenta(Venta venta);
	
	List<Venta> obtenerVentas() throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException;

}
