package ar.edu.unrn.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unrn.modelo.PersistenciaApi;
import ar.edu.unrn.persistencia.EnDiscoRegistrarVenta;

public class EnDiscoRegistrarVentaTest {

	@Test
	public void verificarQueSeAgregoLosDatosAUnArchivo() {
		//setup
		PersistenciaApi api= new EnDiscoRegistrarVenta();
		String venta= "2021-05-08|Comun|33| $2310.0 ... Venta.";
		//exercise
		assertTrue(api.registrarVenta(venta));
		
	}
}
