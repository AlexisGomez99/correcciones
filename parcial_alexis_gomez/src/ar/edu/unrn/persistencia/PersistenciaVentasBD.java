package ar.edu.unrn.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unrn.modelo.Combustible;
import ar.edu.unrn.modelo.PersistenciaApi;
import ar.edu.unrn.modelo.Venta;
import ar.edu.unrn.modelo.VentaDTO;
import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;


public class PersistenciaVentasBD implements PersistenciaApi{
	private VentasWeb ventas= new VentasWeb();
	private PersistenciaApi enDiscoVentas= new EnDiscoRegistrarVenta();
	@Override
	public boolean agregarVenta(Venta venta)
			throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException {
		boolean x=false;
		/*Combustible combustible_api = new Combustible(combustible);
		Venta venta= new Venta(combustible_api,cantidadLitros,total,fecha);
		venta.calcularTotal();*/
		
		String registroVentaEnDisco= ""+venta.fecha().toString()+"|"+venta.combustible().tipoCombustible()+"|"+venta.cantidadDeLitros()+"| $"+venta.total()+" ... Venta.\n";
		enDiscoVentas.registrarVenta(registroVentaEnDisco);
		
		ventas.registrarVenta(venta);
		x=true;
		
		
		return x;
	}

	@Override
	public List<VentaDTO> obtenerVentas() throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException {
		List<VentaDTO> listaVentas = new ArrayList<VentaDTO>();
		
		for(Venta v: ventas.obtenerVentas()) {
			listaVentas.add(new VentaDTO(v.fecha().toString(),v.combustible().tipoCombustible(),""+v.cantidadDeLitros(), ""+v.total()));
		}
		return listaVentas;
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
	
	

}
