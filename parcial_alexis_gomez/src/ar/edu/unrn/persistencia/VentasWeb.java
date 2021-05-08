package ar.edu.unrn.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unrn.modelo.Combustible;
import ar.edu.unrn.modelo.RepositorioVentasWeb;
import ar.edu.unrn.modelo.Venta;
import ar.edu.unrn.modelo.VentaDTO;
import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;



public class VentasWeb implements RepositorioVentasWeb{

	@Override
	public void registrarVenta(Venta venta) {
		Connection myConexion;
		try {
			myConexion = ConexionBD.conexion();
			Statement sent;
			sent= myConexion.createStatement();
			int id=0;
			String combustible= venta.combustible().tipoCombustible();
			String fecha2 = venta.fecha().toString();
			String cantidadDeLitros= ""+venta.cantidadDeLitros();
			sent.executeUpdate("INSERT INTO `venta`(`IDVenta`,`Total`, `Combustible`, `Fecha`, `CantidadLitros`,`Descuento` ) "
					+ "VALUES ("+id+","+venta.total()+",'"+combustible+"','"+fecha2+"','"+cantidadDeLitros+"',"+venta.descuento()+")");
			
			sent.close();
			myConexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//throw new RuntimeException("Surgio un problema con la base de datos.", e);
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException("No hay conexion.", e);
		}
	}

	@Override
	public List<Venta> obtenerVentas() throws RuntimeException, NotNullException, DataEmptyException, NotNumbreException {
		Connection myConexion;
		List<Venta> ventas= new ArrayList<>();
		try {
			myConexion = ConexionBD.conexion();
			Statement sent;
			sent= myConexion.createStatement();
			ResultSet resul= sent.executeQuery("Select * from venta v");
			while(resul.next()) {
				LocalDate fecha= LocalDate.parse(resul.getString("v.Fecha"));
				LocalDateTime fecha2= LocalDateTime.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth(), 0, 0);
				System.out.println(fecha2.toString());
				ventas.add(new Venta(new Combustible(resul.getString("v.Combustible")), resul.getString("v.CantidadLitros"), resul.getInt("v.Total"),fecha));
			}
			resul.close();
			sent.close();
			myConexion.close();
			return ventas;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
		
		
		
	}

}
