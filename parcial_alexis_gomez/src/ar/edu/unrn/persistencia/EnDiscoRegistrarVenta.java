package ar.edu.unrn.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

import ar.edu.unrn.modelo.Combustible;
import ar.edu.unrn.modelo.PersistenciaApi;
import ar.edu.unrn.modelo.Venta;
import ar.edu.unrn.modelo.VentaDTO;
import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;


public class EnDiscoRegistrarVenta implements PersistenciaApi{
	@Override
	public boolean registrarVenta(String venta) {
		boolean x=false;
		try {
			Files.write(Paths.get("C:\\Users\\Alexis\\Desktop\\Ventas.txt"), venta.getBytes(),
					StandardOpenOption.APPEND);
			x=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public void registrarResumen(String resumen) {
		try {
			Files.write(Paths.get("C:\\Users\\Alexis\\Desktop\\ResumenCostoTotal.txt"), resumen.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean agregarVenta(String combustible, String cantidadLitros, float total, LocalDate fecha)
			throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException {
		
		Combustible combustible_api = new Combustible(combustible);
		Venta venta= new Venta(combustible_api,cantidadLitros,total,fecha);
		venta.calcularTotal();
		
		String registroVentaEnDisco= ""+venta.fecha().toString()+"|"+venta.combustible().tipoCombustible()+"|"+venta.cantidadDeLitros()+"| $"+venta.total()+" ... Venta.\n";
		registrarVenta(registroVentaEnDisco);
		return true;
	}

	@Override
	public List<VentaDTO> obtenerVentas()
			throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException {
		// TODO Auto-generated method stub
		return null;
	}

}
