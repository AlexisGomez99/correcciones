package ar.edu.unrn.main;

import java.awt.EventQueue;

import ar.edu.unrn.iu.PantallaPrincipal;
import ar.edu.unrn.persistencia.EnDiscoRegistrarVenta;


public class MainArchivos {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Main que se utiliza para guardar los archivos en disco
					PantallaPrincipal frame = new PantallaPrincipal(new EnDiscoRegistrarVenta());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
