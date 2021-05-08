package ar.edu.unrn.persistencia;
import java.sql.*;


public class ConexionBD {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/epp_ypzw";
    private static final String USUARIO = "root";
    private static final String CLAVE="";
    
    private ConexionBD() {
    	
    }
	public static Connection conexion() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
        Class.forName(CONTROLADOR);
        conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        //System.out.println("Obtuvo acceso a su Base de Datos.");
        return conexion; 
	}
}
