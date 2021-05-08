package ar.edu.unrn.modelo;

import java.time.LocalDate;

import java.util.List;

import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;

public interface PersistenciaApi {
	
	boolean agregarVenta(String combustible, String cantidadLitros, float total, LocalDate fecha) 
			throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException;

	List<VentaDTO> obtenerVentas() throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException;
	
	void registrarResumen(String resumen);
	
	boolean registrarVenta(String venta);
}
