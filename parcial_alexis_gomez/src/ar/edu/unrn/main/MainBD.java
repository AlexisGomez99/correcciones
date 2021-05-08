package ar.edu.unrn.main;

import java.awt.EventQueue;

import ar.edu.unrn.persistencia.PersistenciaVentasBD;
import ar.edu.unrn.ui.PantallaPrincipal;

public class MainBD {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Main que se utiliza una base de datos para guardar.
					PantallaPrincipal frame = new PantallaPrincipal(new PersistenciaVentasBD());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
