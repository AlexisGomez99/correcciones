package ar.edu.unrn.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unrn.modelo.PersistenciaApi;
import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;
import ar.edu.unrn.persistencia.PersistenciaVentasBD;

public class PersistenciaVentasBDTest {
	@Test
	public void verificarQueSeAgregoLosDatosAUnaBaseDeDatos() throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException {
		//setup
		PersistenciaApi api= new PersistenciaVentasBD();
		LocalDate diaSabado= LocalDate.of(2021, 5, 8);
		//exercise
		assertTrue("No hay coneccion a base de datos.",api.agregarVenta("Super","20",0,diaSabado));
		
	}
}
